package org.academiadecodigo.anderdogs.paint;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.io.*;

public class Controls implements KeyboardHandler {
    //Properties
    private Cursor cursor;
    private Game game;
    private Grid grid;
    private Menu menu;

    //Constructor
    public Controls( int col, int row){
        menu = new Menu();
        game = new Game(col, row);
        grid = new Grid(col,row);
        cursor = new Cursor();
        init();


    }

    //Methods

    public void setGame(Game game){
        this.game = game;
    }
    public void setGame(Grid grid){
        this.grid = grid;
    }

    public void pintar(){
        for(int i=0; i <grid.getCellsArr().length; i++){
            for( int j=0; j<grid.getCellsArr()[i].length; j++){
                if( i== cursor.getCol() && j == cursor.getRow()){
                        grid.getCellsArr()[i][j].paints();
                }
            }
        }
    }

    public void apagar(){
        for(int i=0; i <grid.getCellsArr().length; i++){
            for( int j=0; j<grid.getCellsArr()[i].length; j++){
                if( i== cursor.getCol() && j == cursor.getRow()){
                        grid.getCellsArr()[i][j].erase();
                }
            }
        }
    }

    public void delete(){
        for(int i=0; i <grid.getCellsArr().length; i++){
            for( int j=0; j<grid.getCellsArr()[i].length; j++){
                    grid.getCellsArr()[i][j].erase();
            }
        }
    }

    public void save(){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("resources/SavedFile");

            for(int i=0; i <grid.getCellsArr().length; i++){
                for( int j=0; j<grid.getCellsArr()[i].length; j++){
                    byte [] buffer = grid.getCellsArr()[i][j].toString().getBytes();
                    fileOutputStream.write(buffer);
                }
            }
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void load(){
        try {
            FileInputStream fileInputStream = new FileInputStream("resources/SavedFile");
            byte [] buffer = new byte[1024];
            int num;
            for(int i=0; i <grid.getCellsArr().length; i++){
                System.out.println("Hey sou o LOAD[i]");
                for( int j=0; j<grid.getCellsArr()[i].length; j++){
                    System.out.println("Hey sou o LOAD[j]");
                    try {
                        num = fileInputStream.read(buffer,0,grid.getCellsArr()[i].length);
                        if(num == 1){
                            grid.getCellsArr()[i][j].paints();
                            System.out.println("Hey sou o LOAD[j] a pintar");
                        }
                        if(num == 0){
                            grid.getCellsArr()[i][j].erase();
                            System.out.println("Hey sou o LOAD[j] a despintar");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void init(){ // TENTAR FAZER SWITCH STATEMENT PARA TIPOS DE TECLAS E FOR LOOPS PARA CADA EVENTO NOVO E PARA CADA ADDEVENTLISTNER
        Keyboard keyboard = new Keyboard(this);
        //RIGHT
        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType((KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(right);
        //LEFT
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType((KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(left);
        //DOWN
        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType((KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(down);
        //UP
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType((KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(up);
        //SAVE
        KeyboardEvent s = new KeyboardEvent();
        s.setKey(KeyboardEvent.KEY_S);
        s.setKeyboardEventType((KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(s);
        //LOAD
        KeyboardEvent l = new KeyboardEvent();
        l.setKey(KeyboardEvent.KEY_L);
        l.setKeyboardEventType((KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(l);
        //PAINT
        KeyboardEvent p = new KeyboardEvent();
        p.setKey(KeyboardEvent.KEY_P);
        p.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(p);
        //ERASE
        KeyboardEvent x = new KeyboardEvent();
        x.setKey(KeyboardEvent.KEY_X);
        x.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(x);
        //Delete
        KeyboardEvent d = new KeyboardEvent();
        d.setKey(KeyboardEvent.KEY_D);
        d.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(d);
        //Leave Game
        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) { //FAZER IF IS MOVED + SWITCH STATEMENT
                switch (keyboardEvent.getKey()) {
                    case KeyboardEvent.KEY_RIGHT:
                        if(cursor.getCol()<grid.getCol()-1) {
                            cursor.moveRight();
                        }
                        break;
                    case KeyboardEvent.KEY_LEFT:
                        if(cursor.getCol()>0) {
                            cursor.moveLeft();
                        }
                        break;
                    case KeyboardEvent.KEY_UP:
                        if(cursor.getRow() >0) {
                            cursor.moveUp();
                        }
                        break;
                    case KeyboardEvent.KEY_DOWN:
                        if(cursor.getRow()<grid.getRow()-1) {
                            cursor.moveDown();
                        }
                        break;
                    case KeyboardEvent.KEY_X:
                        apagar();
                        break;
                    case KeyboardEvent.KEY_P:
                        pintar();
                        break;
                    case KeyboardEvent.KEY_D:
                        delete();
                        break;
                    case KeyboardEvent.KEY_S:
                        save();
                        break;
                    /*case KeyboardEvent.KEY_L:
                        load();
                        System.out.println("Hey sou o LOAD");
                        break;

                     */
                    case KeyboardEvent.KEY_SPACE:
                        System.exit(0);
                        break;
                }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
//  ------------------------MOUSE----------------------------
   /* private Mouse mouse;
    private double x; //Variável que irá guardar o X do rato
    private double y; //Variável que irá guardar o Y do rato
    private boolean click;
    private Color color;


    public double mouseX(){
        return x;
    }

    public double mouseY(){
        return y;
    }

    public boolean getClick(){
        return click;
    }

    public void resetPos(){
        x=0;
        y=0;
    }

    public void setClick(boolean click){
        this.click=click;
    }

    public Color colorRandomizer(){
        /*int random = (int) Math.floor(Math.random()*4);
        switch (random){
            case 0:
                color = Color.YELLOW;
                break;
            case 1:
                color = Color.CYAN;
                break;
            case 2:
                color = Color.RED;
                break;
            case 3:
                color = Color.GREEN;
                break;
        }
        return color;
         */

       /* if(mouseX() >= 625 && mouseX() <=713 && mouseY() >= 60 && mouseY()<= 150){
            color = Color.YELLOW;
        }
        if(mouseX() >= 625 && mouseX() <=713 && mouseY() >= 172 && mouseY()<= 264){
            color = Color.RED;
        }
        if(mouseX() >= 625 && mouseX() <=713 && mouseY() >= 282 && mouseY()<= 374){
            color = Color.CYAN;
        }
        if(mouseX() >= 625 && mouseX() <=713 && mouseY() >= 393 && mouseY()<= 483){
            color = Color.GREEN;
        }
        return color;
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        x=mouseEvent.getX();
        y=mouseEvent.getY();
        System.out.println("X: " +x+ " Y: "+y);
        click=true;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

        */

}
