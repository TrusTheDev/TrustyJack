package com.trusthecode.trustyjack.models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements DeckInterface {
    ArrayList<Card> Deck;
    private ArrayList<Card> Backup;

    public Deck(ArrayList<Card> deck) {
        this.Deck = deck;
        this.Backup = new ArrayList<>(Deck);
    }

    @Override
    public List<Card> reset() {
        Deck = new ArrayList<>(Backup);
        return Deck;
    }

    public ArrayList<Card> addCard(Card card){
        Deck.add(card);
        return Deck;
    }

    @Override
    public List<Card> deleteCard(Card card) {
        Deck.remove(card);
        return Deck;
    }



    public Card getRandomCard(){
        Card randomCard = Deck.get(((int) (Math.random() * Deck.size())));
        Deck.remove(randomCard);
        return randomCard;
    }

    public ArrayList<Card> shuffle(){
        Collections.shuffle(Deck);
        return Deck;
    }

    public ArrayList<Card> getDeck() {
        return Deck;
    }
}
