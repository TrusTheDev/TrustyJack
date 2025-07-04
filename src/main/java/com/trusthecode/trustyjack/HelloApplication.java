package com.trusthecode.trustyjack;

import com.trusthecode.trustyjack.models.Card;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();

        //Clubs
        Card C = new Card("Clubs", "C", 1);
        Card C2 = new Card("Clubs", "C2", 2);
        Card C3 = new Card("Clubs", "C3", 3);
        Card C4 = new Card("Clubs", "C4", 4);
        Card C5 = new Card("Clubs", "C5", 5);
        Card C6 = new Card("Clubs", "C6", 6);
        Card C7 = new Card("Clubs", "C7", 7);
        Card C8 = new Card("Clubs", "C8", 8);
        Card C9 = new Card("Clubs", "C9", 9);
        Card C10 = new Card("Clubs", "C10", 10);
        Card CJ = new Card("Clubs", "CJ", 10);
        Card CQ = new Card("Clubs", "CQ", 10);
        Card CK = new Card("Clubs", "CK", 10);
        //Diamonds
        Card D = new Card("Diamonds", "D", 1);
        Card D2 = new Card("Diamonds", "D2", 2);
        Card D3 = new Card("Diamonds", "D3", 3);
        Card D4 = new Card("Diamonds", "D4", 4);
        Card D5 = new Card("Diamonds", "D5", 5);
        Card D6 = new Card("Diamonds", "D6", 6);
        Card D7 = new Card("Diamonds", "D7", 7);
        Card D8 = new Card("Diamonds", "D8", 8);
        Card D9 = new Card("Diamonds", "D9", 9);
        Card D10 = new Card("Diamonds", "D10", 10);
        Card DJ = new Card("Diamonds", "DJ", 10);
        Card DQ = new Card("Diamonds", "DQ", 10);
        Card DK = new Card("Diamonds", "DK", 10);
        //Hearts
        Card H = new Card("Hearts", "H", 1);
        Card H2 = new Card("Hearts", "H2", 2);
        Card H3 = new Card("Hearts", "H3", 3);
        Card H4 = new Card("Hearts", "H4", 4);
        Card H5 = new Card("Hearts", "H5", 5);
        Card H6 = new Card("Hearts", "H6", 6);
        Card H7 = new Card("Hearts", "H7", 7);
        Card H8 = new Card("Hearts", "H8", 8);
        Card H9 = new Card("Hearts", "H9", 9);
        Card H10 = new Card("Hearts", "H10", 10);
        Card HJ = new Card("Hearts", "HJ", 10);
        Card HQ = new Card("Hearts", "HQ", 10);
        Card HK = new Card("Hearts", "HK", 10);
        //Spades
        Card S = new Card("Spades", "S", 1);
        Card S2 = new Card("Spades", "S2", 2);
        Card S3 = new Card("Spades", "S3", 3);
        Card S4 = new Card("Spades", "S4", 4);
        Card S5 = new Card("Spades", "S5", 5);
        Card S6 = new Card("Spades", "S6", 6);
        Card S7 = new Card("Spades", "S7", 7);
        Card S8 = new Card("Spades", "S8", 8);
        Card S9 = new Card("Spades", "S9", 9);
        Card S10 = new Card("Spades", "S10", 10);
        Card SJ = new Card("Spades", "SJ", 10);
        Card SQ = new Card("Spades", "SQ", 10);
        Card SK = new Card("Spades", "SK", 10);

        Card Deck[] = {/*Clubs*/C,C2,C3,C4,C5,C6,C7,C8,C9,C10,CJ,CQ,CK, /*Diamonds*/D,D2,D3,D4,D5,D6,D7,D8,D9,D10,DJ,DQ,DK, /*Hearts*/H,H2,H3,H4,H5,H6,H7,H8,H9,H10,HJ,HQ,HK, /*Spades*/S,S2,S3,S4,S5,S6,S7,S8,S9,S10,SJ,SQ,SK};
        for (int i=0; i<Deck.length; i++){
            if(Deck[i].getType() == "Spades"){
                System.out.println(Deck[i].getName());
            }
        }
    }
}