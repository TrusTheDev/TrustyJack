package com.trusthecode.trustyjack.models;

import java.util.ArrayList;
import java.util.List;

public interface DeckInterface {
    public List<Card> addCard(Card card);

    public List<Card> deleteCard(Card card);

    public List<Card> reset();
}
