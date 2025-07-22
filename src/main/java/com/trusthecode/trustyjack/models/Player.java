package com.trusthecode.trustyjack.models;

import java.util.ArrayList;
import java.util.List;

public class Player implements DeckInterface {
    List<Card> Deck = new ArrayList<Card>();
    private int score;

    public Player(List<Card> deck) {
        this.Deck = Deck;
    }

    @Override
    public List<Card> addCard(Card card) {
        Deck.add(card);
        calcScore();
        return Deck;
    }

    @Override
    public List<Card> deleteCard(Card card) {
        Deck.remove(card);
        return Deck;
    }

    @Override
    public List<Card> reset() {
        Deck.removeAll(Deck);
        score = 0;
        return Deck;
    }

    private void calcScore(){
            score += Deck.getLast().getValue();
    }

    public Card getCard(int index){
        return Deck.get(index);
    }

    public Card getLastCard(){
        return Deck.getLast();
    }

    public List<Card> getDeck() {
        return Deck;
    }

    public void setDeck(List<Card> deck) {
        Deck = deck;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
