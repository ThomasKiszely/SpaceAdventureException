package com.thomas.spaceadventureexception;

import javafx.scene.control.Alert;


public class Story {

    String story1(){
        return "You are facing a space storm. Do you:\n1 Fly through\nor\n2 Fly around it?";
    }
    public String story2(){
        return "You chose to fly through the storm and lost some integrity";
    }
    public String story3(){
        return "You chose to fly around the storm and lost some fuel";
    }
    public String story4(){
        return "\nYou meet up with a mysterious alien\nDo you:\n1 Ask him for fuel\nor\n2 Ask him to go funk himself?";
    }
    public String story6(){
        throw new NoTradingWithAliensException("No trading with aliens");
    }
    public String story7(){
        return "You suddenly start to have motor problems... \n\nClick one or two to restart engine";
    }
    public String story8(){
        try {
            engineOverload();
        }catch (EngineOverloadException eoe){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("EngineOverloadException");
            alert.setHeaderText(null);
            alert.setContentText(eoe.getMessage());
            alert.showAndWait();
        }
        finally {
            return "Engine restarted. Woohoo\nClick Ending to continue";
        }
    }

    public void engineOverload(){
        throw new EngineOverloadException("Engine overloaded - trying to restart");
    }
    public String ending(){
        return "You've finally managed to get through a crazy trip in space to get your beloved princess\nYou find that she is awaiting you in har dad's castle" +
                "\nFilled with excitement you enter her room\nBut...\nInstead of the princess of your dreams you see a little green frog" +
                "\nSince it's not like you to give up so easily, you choose to kiss the frog.\nNothing happens... Except...\nYou start to feel bad..." +
                "\nAll of a sudden the king enters the room and is laughing. By his side is standing the princess of your dreams.\nCongratulations! You did it, Captain";
    }

}
