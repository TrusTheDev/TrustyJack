package com.trusthecode.trustyjack;

import com.trusthecode.trustyjack.controllers.gameController;
import com.trusthecode.trustyjack.models.Card;
import com.trusthecode.trustyjack.models.Deck;
import com.trusthecode.trustyjack.models.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/trusthecode/trustyjack/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setTitle("TrustyJack");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();


        //Test to see functionalities
//        for(int i=1; i<100; i++) {
//            for (int j = 0; j < 26; j++) {
//                crupier.addCard(Deck.getRandomCard());
//                ivan.addCard(Deck.getRandomCard());
//            }
//            System.out.println("Deck started with 52 cards");
//            System.out.println("Deck now has: " + Deck.getDeck().size() + " cards");
//            System.out.println("James has: " + ivan.getCard(0).getName() + " score: " + ivan.getScore());
//            System.out.println("Crupier has: " + crupier.getCard(0).getName() + " score: " + crupier.getScore());
//
//            System.out.println("Reseting deck");
//            gameController.reset(ivan, crupier, Deck);
//            System.out.println("James deck: " + ivan.getDeck().size() + " score: " + ivan.getScore());
//            System.out.println("Crupier deck: " + crupier.getDeck().size() + " score: " + crupier.getScore());
//            System.out.println("Deck size " + Deck.getDeck().size());
//            System.out.println("------------------------------------------------------------------------");
//        }







    }
}