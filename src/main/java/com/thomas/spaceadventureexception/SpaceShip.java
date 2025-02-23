package com.thomas.spaceadventureexception;

import javafx.scene.control.Alert;

import java.io.IOException;

public class SpaceShip {
    int fuel = 100;
    int integrity = 100;
    String name;
    String captain;
    StoryController storyController = new StoryController();

    public SpaceShip(String captain, int fuel, int integrity) {
        this.name = name;
        this.captain = captain;
        this.fuel = fuel;
        this.integrity = integrity;
    }
    public int getFuel() {
        return fuel;
    }
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    public int getIntegrity() {
        return integrity;
    }
    public void setIntegrity(int integrity) {
        this.integrity = integrity;
    }
    public void calculateFuel() {
        System.out.println(fuel);
        int fuelLost = (int) (Math.random()*100);
        fuel -= fuelLost;
        if (0 < fuel && fuel < 10) {
            throw new LowFuelException("Warning: Low Fuel");
        }
        if (fuel <= 0){
            throw new OutAFuelException("Warning: Out AFuel");
        }
    }
    public void calculateIntegrity() {
        int integrityLost = (int) (Math.random()*100);
        integrity -= integrityLost;
        if (0 < integrity && integrity < 10) {
            throw new LowIntegrityException("Warning: Low Integrity");
        }
        if (integrity <= 0){
            throw new GameOverException("Space over");
        }
    }
    public void calculateFuelHigh() {
        fuel -= 20;
        calculateFuel();
    }
    public void calculateIntegrityHigh() {
        integrity -= 20;
        calculateIntegrity();
    }
}
