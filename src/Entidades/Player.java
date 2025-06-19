/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author joaoluis
 */
public class Player {
    double money;
    String name;
    Profession profession;
    ArrayList<Employee> employees = new ArrayList<Employee>();

    public Player(double money, String name, Profession profession) {
        this.money = money;
        this.name = name;
        this.profession = profession;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    public void addMoney(double amount){
        this.money += amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    public void addEmployee(JFrame game, Employee employee){
        this.employees.add(employee);
        JOptionPane.showMessageDialog(game, "Parabéns! Você contratou " 
                + employee.getName() + ", um " 
                + employee.getProfession() + ". Seu salário é de " + employee.getWage() 
                + "R$, e ele gera " + employee.getProfitability() + "R$ por dia. Impostos foram deduzidos.");
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    
    
    
    
    
    
}
