/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import trabalho.Game;
/**
 *
 * @author joaoluis
 */

public class GameLoop {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Player player;
    private final Game mainFrame;

    public GameLoop(Player player, Game mainFrame) {
        this.player = player;
        this.mainFrame = mainFrame;
    }
    
    public void startGameLoop() {
        Runnable task = () -> {
            if(!player.getEmployees().isEmpty()){
                startEmployeeWorkLoop();
            }
        };
        scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
    }
    
    public void startEmployeeWorkLoop() {
        Runnable task = () -> {
            player.getEmployees().forEach(employee -> {
                employee.doJobActivity();
                player.addMoney(employee.getWage());
                mainFrame.getEventLabel().setText(employee.doJobActivity());
                mainFrame.getMoneyLabel().setText(player.getMoney() + " R$");
            });
        };
        scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
    }

    public void stop() {
        scheduler.shutdown();
    }
}