/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;

/**
 *
 * @author joaoluis
 */

public class GameLoop {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Player player;

    public GameLoop(Player player) {
        this.player = player;
    }
    
    public void startGameLoop(JLabel eventLabel) {
        Runnable task = () -> {
            if(!player.getEmployees().isEmpty()){
                startEmployeeWorkLoop(eventLabel);
            }
        };
        scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
    }

    public void startEmployeeWorkLoop(JLabel eventLabel) {
        Runnable task = () -> {
            player.getEmployees().forEach(employee -> {
                employee.doJobActivity();
                player.addMoney(employee.getWage());
                eventLabel.setText(employee.doJobActivity());
            });
        };
        scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
    }

    public void stop() {
        scheduler.shutdown();
    }
}