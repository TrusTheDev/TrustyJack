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

    public Deck initCardDeck(){
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

        ArrayList<Card> DeckList = new ArrayList<Card>();
        // Clubs
        DeckList.add(C);
        DeckList.add(C2);
        DeckList.add(C3);
        DeckList.add(C4);
        DeckList.add(C5);
        DeckList.add(C6);
        DeckList.add(C7);
        DeckList.add(C8);
        DeckList.add(C9);
        DeckList.add(C10);
        DeckList.add(CJ);
        DeckList.add(CQ);
        DeckList.add(CK);

// Diamonds
        DeckList.add(D);
        DeckList.add(D2);
        DeckList.add(D3);
        DeckList.add(D4);
        DeckList.add(D5);
        DeckList.add(D6);
        DeckList.add(D7);
        DeckList.add(D8);
        DeckList.add(D9);
        DeckList.add(D10);
        DeckList.add(DJ);
        DeckList.add(DQ);
        DeckList.add(DK);
// Hearts
        DeckList.add(H);
        DeckList.add(H2);
        DeckList.add(H3);
        DeckList.add(H4);
        DeckList.add(H5);
        DeckList.add(H6);
        DeckList.add(H7);
        DeckList.add(H8);
        DeckList.add(H9);
        DeckList.add(H10);
        DeckList.add(HJ);
        DeckList.add(HQ);
        DeckList.add(HK);
// Spades
        DeckList.add(S);
        DeckList.add(S2);
        DeckList.add(S3);
        DeckList.add(S4);
        DeckList.add(S5);
        DeckList.add(S6);
        DeckList.add(S7);
        DeckList.add(S8);
        DeckList.add(S9);
        DeckList.add(S10);
        DeckList.add(SJ);
        DeckList.add(SQ);
        DeckList.add(SK);
        Deck deck = new Deck(DeckList);
        return deck;
    }
}