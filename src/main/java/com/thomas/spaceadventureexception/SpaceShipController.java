package com.thomas.spaceadventureexception;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Optional;

public class SpaceShipController {
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button buttonNext;
    @FXML
    private Button buttonEnding;
    @FXML
    private Button restartButton;
    @FXML
    private TextArea textAreaMain;
    @FXML
    private TextArea textAreaFuelLevel;
    @FXML
    private TextArea textAreaIntegrityLevel;
    @FXML
    private TextField textFieldMain;
    @FXML
    private TextArea textAreaName;

    StoryController storyController = new StoryController();
    Story story = new Story();
    int choice = 0;


    public void initialize() {
        restartButton.setVisible(false);
        button1.setVisible(false);
        button2.setVisible(false);
        buttonNext.setVisible(true);
        buttonEnding.setVisible(false);
        textAreaFuelLevel.setText("100");
        textAreaIntegrityLevel.setText("100");
        textAreaMain.setText("Welcome to Space Ship Rescue\nPlease enter your name in the textbox and hit next");
        textAreaName.clear();
        textFieldMain.setVisible(true);
        choice = 0;
    }

    public void writeText(String text) {
        textAreaMain.appendText(text);
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    public void onNextButtonClicked(ActionEvent actionEvent) throws YourNameIsNotCaptainException{
       try{
        String name = textFieldMain.getText();
        if (!name.equals("Captain")) {
            storyController.wrongName();
        }
       }catch (YourNameIsNotCaptainException e) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("YourNameIsNotValid");
           alert.setHeaderText(null);
           alert.setContentText("Your name MUST be Captain");
           alert.showAndWait();
           return;
        }
        button1.setVisible(true);
        button2.setVisible(true);
        buttonNext.setVisible(false);
        storyController.setSails();
//        spaceShip = new SpaceShip("Captain", "Captain", 100, 100);
        textAreaName.setText("Captain");
        textFieldMain.clear();
        textFieldMain.setVisible(false);
        choice = choice+1;
//        storyController.setChoice();
        runStory();
    }

    @FXML
    public void addOneToChoice(ActionEvent event) {
        this.choice = choice + 1;
        runStory();
    }


    @FXML
    public void addTwoChoice(ActionEvent event) {
        this.choice = choice + 2;
        runStory();
    }

    public void addOneToChoice() {
        this.choice = choice + 1;
    }
    public void addTwoChoice() {
        this.choice = choice + 2;
    }

    public void runStory() {
        Alert alert = null;
        try {
            switch (choice) {
                case 1:
                    String story1 = storyController.getStory1();
                    textAreaMain.setText(story1);
                    break;
                case 2:
                    textAreaMain.setText(storyController.getStory2());
                    storyController.calculateIntegrityHigh();
                    storyController.calculateFuel();
                    textAreaIntegrityLevel.setText(String.valueOf(storyController.spaceShip.getIntegrity()));
                    textAreaFuelLevel.setText(String.valueOf(storyController.spaceShip.getFuel()));
                    textAreaMain.appendText(storyController.getStory4());
                    addTwoChoice();
                    break;
                case 3:
                    storyController.calculateFuelHigh();
                    textAreaFuelLevel.setText(String.valueOf(storyController.spaceShip.getFuel()));
                    textAreaMain.setText(storyController.getStory3());
                    textAreaMain.appendText(storyController.getStory4());
                    addOneToChoice();
                    break;
                case 4:
                    textAreaMain.appendText(storyController.getStory4());
                    break;
                case 5:
                    textAreaMain.appendText("\nFuuj");
                    storyController.calculateIntegrity();
                    textAreaIntegrityLevel.setText(String.valueOf(storyController.spaceShip.getIntegrity()));
                    choice = choice - 1;
                    textAreaMain.setText(storyController.getStory6());
                    break;
                case 6:
                    textAreaMain.setText("Good choice\n" + storyController.getStory7());
                    break;
                case 7:
                    textAreaMain.setText(storyController.getStory8());
                    button1.setVisible(false);
                    button2.setVisible(false);
                    buttonEnding.setVisible(true);
                    break;
                case 8:
                    textAreaMain.setText(storyController.getStory8());
                    button1.setVisible(false);
                    button2.setVisible(false);
                    buttonEnding.setVisible(true);
                    break;
            }
        } catch (NoTradingWithAliensException ntwae) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NoTradingWithAliens");
            alert.setHeaderText(null);
            alert.setContentText("@WeComeInPeaceIsABigFatLie\nGetYourselfSomeDignity");
            alert.showAndWait();
        }

        catch (LowFuelException lowfue) {
            textAreaFuelLevel.setText(String.valueOf(storyController.spaceShip.getFuel()));
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("LowFuel");
            alert.setHeaderText(null);
            alert.setContentText("Warning... You are low on fuel");
            alert.showAndWait();
            if (choice == 2){
                textAreaIntegrityLevel.setText(String.valueOf(storyController.spaceShip.getIntegrity()));
                textAreaMain.setText(storyController.getStory2());
                textAreaMain.appendText(storyController.getStory4());
                choice = 4;
            }
            if (choice == 3) {
                addOneToChoice();
                runStory();
            }
        }
        catch (LowIntegrityException lie){
            textAreaIntegrityLevel.setText(String.valueOf(storyController.spaceShip.getIntegrity()));
            storyController.calculateFuel();
            textAreaFuelLevel.setText(String.valueOf(storyController.spaceShip.getFuel()));
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("LowIntegrity");
            alert.setHeaderText(null);
            alert.setContentText("Warning... You are about to blow up");
            alert.showAndWait();
            if (choice == 2) {
                addTwoChoice();
                runStory();
            }
            else if (choice == 5) {
                choice = choice - 1;
                runStory();
            }
        }
        catch (GameOverException goe){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Game Over");
            alert.setHeaderText("Space Over");
            alert.setContentText("Your integrity reached 0 or below so your ship exploded\nNot sure this game is for you\nPlease start over");
            alert.showAndWait();
            initialize();
        }
        catch (OutAFuelException oafe){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("OutAFuel");
            alert.setHeaderText("Space Over");
            alert.setContentText("Your fuel level reached 0 so your ship is floating in outer space\nToo bad\nCome again");
            alert.showAndWait();
            initialize();
        }
    }
    public void onEndingButtonClicked(ActionEvent actionEvent) {
        textAreaMain.setText(storyController.getEnding());
        buttonEnding.setVisible(false);
        restartButton.setVisible(true);
    }
    @FXML
    public void onRestartButtonClicked(ActionEvent actionEvent) {
        initialize();
    }
}
