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

    public Object[] reset(){
        player.reset();
        crupier.reset();
        deck.reset();
        return new Object[]{player, crupier, deck};
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
        if(player.getScore() == crupier.getScore() && player.getScore() <= 21 && crupier.getScore() <= 21){
            return "Draw";
        }
        else if (player.getScore() > crupier.getScore() && player.getScore() <= 21 || crupier.getScore() > 21){
            return "You win";
        }
        else {
            return "Crupier wins";
        }
    }

    public Card addPlayerCard(){
        player.addCard(deck.getRandomCard());
        PlayerScore = player.getScore();
        return player.getLastCard();
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
