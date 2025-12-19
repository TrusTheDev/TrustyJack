package com.trusthecode.trustyjack.controllers;

import com.trusthecode.trustyjack.models.Card;
import com.trusthecode.trustyjack.models.Deck;
import com.trusthecode.trustyjack.models.Player;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class GameController {
    Player player = new Player(null);
    Player crupier = new Player(null);
    Deck deck = initCardDeck();
    int PlayerScore;
    int CrupierScore;
    int MaxScore;
    int CurrentBet;
    int Pot;
    int earnings;

    public GameController() {
        CurrentBet = 0;
        Pot = 100;
    }

    public void resetScoreSystem(){
        MaxScore = 0;
        CurrentBet = 0;
        Pot = 100;
    }

    public int add1(){
        if(Pot > 0){
            CurrentBet = CurrentBet + 1;
            Pot = Pot - 1;
        }
        return Pot;
    }

    public int add2(){
        if(Pot > 9) {
            CurrentBet = CurrentBet + 10;
            Pot = Pot - 10;
        }
        return Pot;
    }

    public int add3(){
        if(Pot > 99) {
            CurrentBet = CurrentBet + 100;
            Pot = Pot - 100;
        }
        return Pot;
    }

    public int dec1() {
        if(CurrentBet >=1){
            CurrentBet = CurrentBet - 1;
            Pot = Pot + 1;
        }
        return Pot;
    }

    public int dec2(){
        if(CurrentBet >=10){
            CurrentBet = CurrentBet - 10;
            Pot = Pot + 10;
        }
        return Pot;
    }

    public int dec3(){
        if(CurrentBet >= 100){
            CurrentBet = CurrentBet - 100;
            Pot = Pot + 100;
        }
        return Pot;
    }

    public void reset(){
        player.reset();
        crupier.reset();
        deck.reset();
    }

    public boolean scoreAbove(int score){
        return score > 21;
    }

    public void stand(){
        while (CrupierScore < PlayerScore){
            addCrupierCard();
        }
    }

    public Image grabCard(Card card){
        Image image = new Image(getClass().getResource("/com/trusthecode/trustyjack/cards/" + card.getName() + ".png").toExternalForm());
        return image;
    }

    public String gameResults(){
        this.earnings = 0;
        if(player.getScore() == crupier.getScore() && player.getScore() <= 21 && crupier.getScore() <= 21){
            earnings = (CurrentBet*2-CurrentBet/4);
            Pot = Pot + earnings;
            return "Draw";
        }
        else if (player.getScore() > crupier.getScore() && player.getScore() <= 21 || crupier.getScore() > 21){
            earnings = CurrentBet*2;
            Pot = Pot + earnings;
            return "You win";
        }
        else {
            earnings = CurrentBet * -1;
            return "Crupier wins";
        }
    }

    public Card addPlayerCard(){
        player.addCard(deck.getRandomCard());
        PlayerScore = player.getScore();
        return player.getLastCard();
    }

    public int getEarnings() {
        return earnings;
    }

    public int getMaxScore() {
        return MaxScore;
    }

    public void setMaxScore(int maxScore) {
        MaxScore = maxScore;
    }

    public int getCurrentBet() {
        return CurrentBet;
    }

    public void setCurrentBet(int currentBet) {
        CurrentBet = currentBet;
    }

    public int getPot() {
        return Pot;
    }

    public void setPot(int pot) {
        Pot = pot;
    }

    public int getPlayerDeckSize(){
        return player.getDeck().size();
    }

    public int getCrupierDeckSize(){
        return crupier.getDeck().size();
    }

    public Card getCrupierLastCard(){
        return crupier.getLastCard();
    }

    public Card getCrupierCard(int index){
        return crupier.getCard(index);
    }

    public void addCrupierCard(){
        crupier.addCard(deck.getRandomCard());
        CrupierScore = crupier.getScore();
    }

    public void setPlayerscore(int playerscore) {
        PlayerScore = playerscore;
    }

    public int getPlayerScore(){
        return PlayerScore;
    }

    public int getCrupierScore() {
        return crupier.getScore();
    }

    public Deck initCardDeck(){
        
        ArrayList<Card> test = new ArrayList<>();
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] shorts = {"C","D","H","S"};
        String[] specials = {"J", "Q", "K"};

        for(int i = 0; i<4; i++){
            test.add(new Card(suits[i], shorts[i], 1));
            for(int j = 2; j<11; j++){
                test.add(new Card(suits[i], shorts[i].concat(String.valueOf(j)), j));
            }
            for(int k = 0; k<3; k++){
                test.add(new Card(suits[i], shorts[i].concat(specials[k]), 10));
            }
        }
        return new Deck(test);
    }
}
