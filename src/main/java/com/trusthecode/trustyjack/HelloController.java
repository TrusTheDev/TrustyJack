package com.trusthecode.trustyjack;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private Label welcomeText;

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

    public void initialize(){
        Image blankCard = new Image(getClass().getResource("cards/blank.png").toExternalForm());
        Pcard1.setImage(blankCard);
        Pcard2.setImage(blankCard);
        Pcard3.setImage(blankCard);
        Pcard4.setImage(blankCard);

        Ccard1.setImage(blankCard);
        Ccard2.setImage(blankCard);
        Ccard3.setImage(blankCard);
        Ccard4.setImage(blankCard);
    }

    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}