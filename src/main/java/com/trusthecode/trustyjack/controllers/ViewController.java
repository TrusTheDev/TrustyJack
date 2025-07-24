package com.trusthecode.trustyjack.controllers;
import com.trusthecode.trustyjack.models.Card;
import com.trusthecode.trustyjack.models.Deck;
import com.trusthecode.trustyjack.models.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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


    Image blankCard = new Image(getClass().getResource("/com/trusthecode/trustyjack/cards/blank.png").toExternalForm());

    GameController controller = new GameController();
    public void initialize(){
        resetTable();

    }

    public void StandOnClick(){
        controller.stand();
        if(controller.getCrupierDeckSize() > 2){
            grabCard(Ccard3, controller.getCrupierCard(2));
            for(int i = 3; i< controller.getCrupierDeckSize(); i++){
                grabCard(Ccard4,controller.getCrupierCard(i));
            }
        }
        verifyScore(Cscore, controller.getCrupierScore());
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