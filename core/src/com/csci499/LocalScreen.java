/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci499;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.util.NextScreen;

/**
 *
 * @author tmcdaniel
 */
public class LocalScreen extends AbstractScreen implements Screen {

    private Table uiTable;
    private ImageButton startButton;
    private TextArea[] nameAreas;

    private String[] playerNames;

    public LocalScreen(int maxPlayers) {

        super();

        //set up UI widgets
        startButton = new ImageButton(super.skin, "localButton"); //need to add these resources to the TextureAtlas
        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                startGame();
            }
        }); //register click listener

        //table for UI widgets
        uiTable = new Table();
        super.rootTable.add(uiTable);

        uiTable.setSkin(skin);
        uiTable.center(); //center horz
        uiTable.pad(uiTable.getParent().getHeight() / 2); //center vert?
        uiTable.row();
        uiTable.add(new Label("Enter Player Names", skin, "default")).left().expandX(); //replace default when assets added
        uiTable.row();

        nameAreas = new TextArea[maxPlayers];
        for (int i = 0; i < nameAreas.length; i++) {
            nameAreas[i] = new TextArea("default", super.skin); //add to skin
            nameAreas[i].setText("");
            if (i % 2 == 0) {
                uiTable.add(nameAreas[i]).uniform().pad(Value.zero, Value.percentWidth(0.33f),Value.zero, Value.percentWidth(.033f));
            } else {
                uiTable.add(nameAreas[i]).uniform();
                uiTable.row();
            }
        }

        uiTable.add(startButton).colspan(uiTable.getColumns()).padTop(Value.percentHeight(0.1f)); //add button

    }

    private void startGame() {
        //super.setChangeScreen(NextScreen.GAME); //TODO uncomment after implementing GameScreen

    }

    protected String[] getPlayers() {
        return playerNames;
    }
}