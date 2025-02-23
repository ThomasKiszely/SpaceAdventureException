module com.thomas.spaceadventureexception {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.thomas.spaceadventureexception to javafx.fxml;
    exports com.thomas.spaceadventureexception;
}