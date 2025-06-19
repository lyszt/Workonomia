/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Sound.SoundPlayer;
import java.util.ArrayList;
import java.util.Random;
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
            if (player.getEmployees().isEmpty()) {
                return;
            }
            Random random = new Random();
            if(random.nextInt(50) == 5){
                int choice_i = random.nextInt(player.getEmployees().size());
                Employee chosenEmployee = player.getEmployees().get(choice_i);
                double newWage = (chosenEmployee.getWage()) + random.nextDouble((chosenEmployee.getWage()) * 2.0);
                JOptionPane.showMessageDialog(mainFrame, chosenEmployee.getName() + " pediu um aumento! Agora ele receberá "
                        + newWage + "R$!");
                chosenEmployee.setWage(newWage);
            }
            
            player.getEmployees().forEach(employee -> {
                employee.doJobActivity();
                double lucroLiquido = employee.getProfitability() - employee.getWage();
                String pos_neg = lucroLiquido > 0 ? "+" : "-";
                
                double impostoDevido = 0;
                if (lucroLiquido > 0) {
                    double taxaDeImposto;
                    if (lucroLiquido > 1000) {
                        taxaDeImposto = 0.40; 
                    } else if (lucroLiquido > 300) {
                        taxaDeImposto = 0.25; 
                    } else {
                        taxaDeImposto = 0.10; 
                    }
                impostoDevido = lucroLiquido * taxaDeImposto;
                }
                lucroLiquido -= impostoDevido;
        
                mainFrame.getLucroLabel().setText(pos_neg + " " + lucroLiquido + "R$");
                mainFrame.getLucroLabel().setVisible(true);
                
          
                
                player.setMoney(player.getMoney() + lucroLiquido);
                mainFrame.getEventLabel().setText(employee.doJobActivity());
                mainFrame.getMoneyLabel().setText(player.getMoney() + " R$");
                SoundPlayer.playSound("src/trabalho/resources/audio/money.wav");
            });
        };
        scheduler.scheduleAtFixedRate(task, 0, 4, TimeUnit.SECONDS);
    }

    public void stop() {
        scheduler.shutdown();
    }
}