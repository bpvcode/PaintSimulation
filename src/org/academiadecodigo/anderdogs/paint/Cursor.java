package org.academiadecodigo.anderdogs.paint;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor extends Cell {
    //Properties


    //Constructor
    public Cursor() {  //Poderei passar argumentos para dizer onde quero iniciar o cursor. Faz sentido neste tipo de programa?! (Pensar sobre sito...)
        super(0,0);
        cell.setColor(Color.DARK_GRAY);
        cell.fill();
    }

    //Methods
    public void moveRight(){
        cell.translate(CELLSIZE,0);
        col++;
        System.out.println("Col: " + getCol() + " | Row: " + getRow());
    }

    public void moveLeft(){
        cell.translate(-CELLSIZE,0);
        col--;
        System.out.println("Col: " + getCol() + " | Row: " + getRow());
    }

    public void moveUp(){
        cell.translate(0,-CELLSIZE);
        row--;
        System.out.println("Col: " + getCol() + " | Row: " + getRow());
    }

    public void moveDown(){
        cell.translate(0,CELLSIZE);
        row++;
        System.out.println("Col: " + getCol() + " | Row: " + getRow());
    }

    /*public void paints(){
        painted=true;
        cell.setColor(colorRandomizer());
        cell.fill();
    }
     */



}
