package org.academiadecodigo.anderdogs.paint;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Cell implements MouseHandler {
    //Properties
    protected int col;
    protected int row;
    protected Rectangle cell;
    protected boolean painted;
    private Color color;
    public static final int CELLSIZE = 30; //TAMANHO DA CELULA INDIVIDUAL (COMO É UM QUADRADO WITH E HEIGHT SAO IGUAIS)
    public static final int PADDING = 10; //PADDING DEFAULT DO SIMPLE GRAPHICS


    //Constructor
    public Cell(int col, int row){ //SERÁ INSTANCIADA NA GRID ( metodo init() )
        this.col = col;
        this.row = row;
        cell = new Rectangle(PADDING + col * CELLSIZE,PADDING + row * CELLSIZE, CELLSIZE, CELLSIZE); //AO SER INSTANCIADA, CRIA TODAS AS CÉLULAS, MEDIANTE O Nº DE COLS E ROWS PASSADAS E O TAMANHO DE CADA CELULA (NOTA: TIVE EM CONTA O PADDING)
        cell.draw();
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }


    //Methods
    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    public boolean isPainted(){
        return painted;
    }

    public void paints(){
        painted=true;
        cell.setColor(choosedBrandColor());
        cell.fill();
    }

    public void erase(){
        painted = false;
        cell.setColor(Color.BLACK);
        cell.draw();
    }

    //public Color colorRandomizer(){
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
        /*
        if(mouse.mouseX() >= 625 && mouse.mouseX() <=713 && mouse.mouseY() >= 60 && mouse.mouseY()<= 150){
                color = Color.YELLOW;
        }
        if(mouse.mouseX() >= 625 && mouse.mouseX() <=713 && mouse.mouseY() >= 172 && mouse.mouseY()<= 264){
            color = Color.RED;
        }
        if(mouse.mouseX() >= 625 && mouse.mouseX() <=713 && mouse.mouseY() >= 282 && mouse.mouseY()<= 374){
            color = Color.CYAN;
        }
        if(mouse.mouseX() >= 625 && mouse.mouseX() <=713 && mouse.mouseY() >= 393 && mouse.mouseY()<= 483){
            color = Color.GREEN;
        }
        return color;
    }

         */


    public boolean isMoved(){ //FAZER CONDIÇÕES DE DIREÇÃO (TENTAR COLOCAR AS VARIAS HIPOTESE NUM IF E SE PREENCHEREM A CONDIÇÃO, MUDAR O METODO A VARIAL MOVED PARA TRUE, DEPOIS RETORNAR ESSA VARIÁVEL)
        if(getCol() < 19){
            return true;
        }
        if(getCol() > 0){
            return true;
        }
        if(getRow() > 0){
            return true;
        }
        if(getRow() < 19){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return isPainted() ? "1" : "0";
    }

    //  ------------------------MOUSE----------------------------
    private Mouse mouse;
    private double x; //Variável que irá guardar o X do rato
    private double y; //Variável que irá guardar o Y do rato
    private boolean click;



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

    public Color choosedBrandColor(){
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

        if(mouseX() >= 625 && mouseX() <=713 && mouseY() >= 60 && mouseY()<= 150){
            color = Color.YELLOW;
        }
        else if(mouseX() >= 625 && mouseX() <=713 && mouseY() >= 172 && mouseY()<= 264){
            color = Color.RED;
        }
        else if(mouseX() >= 625 && mouseX() <=713 && mouseY() >= 282 && mouseY()<= 374){
            color = Color.CYAN;
        }
        else if(mouseX() >= 625 && mouseX() <=713 && mouseY() >= 393 && mouseY()<= 483){
            color = Color.GREEN;
        }
        else {
            color = Color.DARK_GRAY;
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



}
