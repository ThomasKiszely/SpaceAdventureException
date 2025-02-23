package com.thomas.spaceadventureexception;


import javafx.stage.Stage;



public class StoryController {

    Story story = new Story();
    SpaceShip spaceShip;
   

    public void wrongName(){
        throw new YourNameIsNotCaptainException("You are not the real captain");
    }
    public void setSails(){
        spaceShip = new SpaceShip("Captain", 100, 100);
    }

    public void calculateFuel(){
        spaceShip.calculateFuel();
    }
    public void calculateIntegrity(){
        spaceShip.calculateIntegrity();
    }
    public void calculateIntegrityHigh(){
        spaceShip.calculateIntegrityHigh();
    }
    public void calculateFuelHigh(){
        spaceShip.calculateFuelHigh();
    }
    public String getStory1(){
        return story.story1();
    }
    public String getStory2(){
        return story.story2();
    }
    public String getStory3(){
        return story.story3();
    }
    public String getStory4(){
        return story.story4();
    }
    public String getStory6(){
        return story.story6();
    }
    public String getStory7(){
        return story.story7();
    }
    public String getStory8(){
        return story.story8();
    }
    public String getEnding(){
        return story.ending();
    }
}
