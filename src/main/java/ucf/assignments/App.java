package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rachel Cameron
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import java.util.Objects;

public class App  extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //loads my fxml file, ListManager.fxml
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ListManager.fxml")));
        //a theme that looks like the default Windows light theme
        JMetro jMetro = new JMetro(Style.LIGHT);
        Scene scene = new Scene(root);
        //title of my window
        primaryStage.setTitle("ListManager");
        jMetro.setScene(scene);
        //sets my primary and only scene stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}