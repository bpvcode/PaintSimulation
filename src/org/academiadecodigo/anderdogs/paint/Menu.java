package org.academiadecodigo.anderdogs.paint;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.anderdogs.paint.Cell.CELLSIZE;
import static org.academiadecodigo.anderdogs.paint.Cell.PADDING;

public class Menu {
    //Properties
    private Grid grid;
    private Rectangle menu;
    public static final int menuX = 120;
    public static final int menuY = 600;
    private Picture snapchat;
    private Picture youtube;
    private Picture skype;
    private Picture whatsapp;
    private Picture instagram;
    private Picture frase;
    private Picture leave;

    //Constructor
    public Menu (){
        menu = new Rectangle(PADDING + 20*CELLSIZE,PADDING ,menuX,menuY);
        menu.setColor(Color.DARK_GRAY);
        menu.fill();
        snapchat = new Picture(620,20,"resources/icons/snapchat .png");
        snapchat.draw();
        youtube = new Picture(620,130,"resources/icons/Youtube round.png");
        youtube.draw();
        skype = new Picture(620,240,"resources/icons/Skype round social media icon free.png");
        skype.draw();
        whatsapp = new Picture(620, 350,"resources/icons/Whatsapp free social media icon round.png");
        whatsapp.draw();
        frase = new Picture(618,455,"resources/icons/Frase4.png");
        frase.draw();
        leave = new Picture(615,568,"resources/icons/leave_v2.png");
        leave.draw();

    }

}
