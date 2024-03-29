package main;

import GUI.StartScherm;
import domein.DomeinController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUpGUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        DomeinController dc = new DomeinController();
        StartScherm root = new StartScherm(dc);
        Scene scene = new Scene(root,1280,720);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Splendor");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
