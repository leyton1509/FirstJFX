package com.example.firstjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main application to run the quiz and loggin system
 */
public class HelloApplication extends Application {
    /**
     * @param stage The intitial stage
     * @throws IOException throws if the file cant be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // Change the size of the window, stage is controlled by the scene, set and show the scene
        Scene scene = new Scene(fxmlLoader.load(), 350, 200);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * @param args Standard args
     * Calls the launch method
     */
    public static void main(String[] args) {
        launch();
    }
}