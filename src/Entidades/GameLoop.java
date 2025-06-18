/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Sound.SoundPlayer;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import trabalho.Game;
import trabalho.Menu;
/**
 *
 * @author joaoluis
 */

public class GameLoop {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Player player;
    private final Game mainFrame;
    private final Story gameStory;
    ArrayList<Integer> completedChapters = new ArrayList<>();

    public GameLoop(Player player, Game mainFrame, Story gameStory) {
        this.player = player;
        this.mainFrame = mainFrame;
        this.gameStory = gameStory;
    }
    
    public void startGameLoop() {
        Runnable task = () -> {
            if(!player.getEmployees().isEmpty()){
                startEmployeeWorkLoop();
            }
            
            mainFrame.getEmployeeLabel().setText("" + player.getEmployees().size());
            
            // Condição de derrota
            if(player.getMoney() < -100){
                JOptionPane.showMessageDialog(mainFrame, "Você faliu, o jogo não pode mais continuar. Jombson venceu.");
                System.exit(0);
            }
            if(player.getMoney() > 20 && !completedChapters.contains(2)){
                completedChapters.add(2);
                gameStory.corruptionOfMen();
            }
            
            
        };
        scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
    }
    
    public void startEmployeeWorkLoop() {
        Runnable task = () -> {
            player.getEmployees().forEach(employee -> {
                employee.doJobActivity();
                player.addMoney(employee.profitability);
                player.setMoney(player.getMoney() - employee.wage);
                mainFrame.getEventLabel().setText(employee.doJobActivity());
                mainFrame.getMoneyLabel().setText(player.getMoney() + " R$");
                SoundPlayer.playSound("src/trabalho/resources/audio/money.wav");
            });
        };
        scheduler.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);
    }

    public void stop() {
        scheduler.shutdown();
    }
}