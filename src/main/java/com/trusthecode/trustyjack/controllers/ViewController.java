package com.trusthecode.trustyjack.controllers;
import com.trusthecode.trustyjack.models.Card;
import com.trusthecode.trustyjack.models.Deck;
import com.trusthecode.trustyjack.models.Player;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewController {
    @FXML
    private ImageView Pcard1;
    @FXML
    private ImageView Pcard2;
    @FXML
    private ImageView Pcard3;
    @FXML
    private ImageView Pcard4;
    @FXML
    private ImageView Ccard1;
    @FXML
    private ImageView Ccard2;
    @FXML
    private ImageView Ccard3;
    @FXML
    private ImageView Ccard4;
    @FXML
    private Label Cscore;
    @FXML
    private Label Pscore;
    @FXML
    private Label winOrLoseSign;
    @FXML
    private VBox boardBox;
    @FXML
    private StackPane boardStackPane;
    @FXML
    private Label Pot;
    @FXML
    private Button add1;
    @FXML
    private Button add2;
    @FXML
    private Button add3;
    @FXML
    private Button dec1;
    @FXML
    private Button dec2;
    @FXML
    private Button dec3;
    @FXML
    private Label bet;
    @FXML
    private Label maxScore;
    @FXML
    private Label earnings;
    @FXML
    private VBox gameState;
    Image blankCard = new Image(getClass().getResource("/com/trusthecode/trustyjack/cards/blank.png").toExternalForm());
    GameController controller = new GameController();
    public void initialize(){resetTable();}

    public void add1(){
        Pot.setText(String.valueOf(controller.add1()));
        bet.setText(String.valueOf(controller.getCurrentBet()));
    }

    public void add2(){
        Pot.setText(String.valueOf(controller.add2()));
        bet.setText(String.valueOf(controller.getCurrentBet()));
    }

    public void add3(){
        Pot.setText(String.valueOf(controller.add3()));
        bet.setText(String.valueOf(controller.getCurrentBet()));
    }

    public void dec1(){
        Pot.setText(String.valueOf(controller.dec1()));
        bet.setText(String.valueOf(controller.getCurrentBet()));
    }


    public void dec2(){
        Pot.setText(String.valueOf(controller.dec2()));
        bet.setText(String.valueOf(controller.getCurrentBet()));
    }


    public void dec3(){
        Pot.setText(String.valueOf(controller.dec3()));
        bet.setText(String.valueOf(controller.getCurrentBet()));
    }


    public void Reset(){
        controller.resetScoreSystem();
        bet.setText("0");
        maxScore.setText("0");
        Pot.setText("100");
    }

    public void StandOnClick(){
        controller.stand();
        if(controller.getCrupierDeckSize() > 2){
            grabCard(Ccard3, controller.getCrupierCard(2));
            for(int i = 3; i< controller.getCrupierDeckSize(); i++){
                grabCard(Ccard4,controller.getCrupierCard(i));
            }
        }
        results();
    }
    public void grabCard(ImageView imageCard,Card card) {
        imageCard.setImage(controller.grabCard(card));
    }

    public void results(){
        boardBox.setOpacity(0.10);
        boardStackPane.setMouseTransparent(true);
        winOrLoseSign.setStyle("-fx-font-size: 50px; -fx-font-weight: bold;");
        winOrLoseSign.setText(controller.gameResults());
        controller.setCurrentBet(0);
        Pot.setText(String.valueOf(controller.getPot()));
        if(controller.getMaxScore() < controller.getPot()){controller.setMaxScore(controller.getPot()); maxScore.setText(String.valueOf(controller.getMaxScore()));}
        bet.setText("0");
        earnings.setText(String.valueOf(controller.getEarnings()));
        gameState.setVisible(true);
    }

    public void clickCard1(){
        grabCard(Pcard1,controller.addPlayerCard());
        verifyScore(Pscore, controller.getPlayerScore());
    }

    public void clickCard2(){
        grabCard(Pcard2,controller.addPlayerCard());
        verifyScore(Pscore, controller.getPlayerScore());
    }

    public void clickCard3(){
        grabCard(Pcard3,controller.addPlayerCard());
        verifyScore(Pscore, controller.getPlayerScore());
    }

    public void clickCard4(){
        grabCard(Pcard4,controller.addPlayerCard());
        verifyScore(Pscore, controller.getPlayerScore());
    }

    public void verifyScore(Label LScore,int score){
        LScore.setText(Integer.toString(score));
        if(controller.scoreAbove(score)){
            results();
        }
    }

    public void RestartBtn(){
        resetTable();
    }

    public void resetTable() {
        gameState.setVisible(false);
        boardStackPane.setMouseTransparent(false);
        winOrLoseSign.setText("");
        boardBox.setOpacity(1.0);
        controller.reset();
        Pcard1.setImage(blankCard);
        Pcard2.setImage(blankCard);
        Pcard3.setImage(blankCard);
        Pcard4.setImage(blankCard);

        controller.addCrupierCard();
        grabCard(Ccard1,controller.getCrupierLastCard());
        controller.addCrupierCard();
        grabCard(Ccard2,controller.getCrupierLastCard());
        Cscore.setText(String.valueOf(controller.getCrupierScore()));
        Ccard3.setImage(blankCard);
        Ccard4.setImage(blankCard);
        Pscore.setText("0");
    }

    public void PlayerHit(){
        int cont = controller.getPlayerDeckSize();
        ImageView[] PlayerCards = new ImageView[]{Pcard1, Pcard2, Pcard3, Pcard4};
        if(cont < 4){
                grabCard(PlayerCards[blankPosition(PlayerCards)], controller.addPlayerCard());
        }
        else{
            grabCard(Pcard4, controller.addPlayerCard());
        }
        verifyScore(Pscore, controller.getPlayerScore());
    }

    public int blankPosition(ImageView[] imageViews){
        int i = 0;
        while (imageViews[i].getImage() != blankCard) {
            i++;
        }
        return i;
    }
}