package com.trusthecode.trustyjack.controllers;

import com.trusthecode.trustyjack.models.Deck;
import com.trusthecode.trustyjack.models.Player;

public class gameController {

    public static Object[] reset(Player player, Player crupier, Deck deck){
        player.reset();
        crupier.reset();
        deck.reset();
        return new Object[]{player, crupier, deck};
    }

}
