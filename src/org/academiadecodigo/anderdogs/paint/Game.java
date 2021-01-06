package org.academiadecodigo.anderdogs.paint;

import static org.academiadecodigo.anderdogs.paint.Cell.PADDING;

public class Game {
    //Properties
    private Cell cell;
    private Grid grid;
    private Cursor cursor;
    private Controls controls;
    private boolean moved;

    //Constructor
    public Game(int gridCols, int gridRows){
        grid = new Grid(gridCols, gridRows);
        //cursor = new Cursor();
        //controls = new Controls(cursor);
        //controls.init();
    }

    //Methods

    /*public void pintar(){
        for(int i=0; i <grid.getCellsArr().length; i++){
            for( int j=0; i<grid.getCellsArr()[i].length; j++){
                if( i== cursor.getCol() && j == cursor.getRow()){
                    System.out.println(cursor.getRow());
                    System.out.println(cursor.getCol());
                    grid.getCellsArr()[i][j].paints();
                }
            }
        }
    }

     */

   /*public boolean isMoved(){ //FAZER CONDIÇÕES DE DIREÇÃO (TENTAR COLOCAR AS VARIAS HIPOTESE NUM IF E SE PREENCHEREM A CONDIÇÃO, MUDAR O METODO A VARIAL MOVED PARA TRUE, DEPOIS RETORNAR ESSA VARIÁVEL)
        if(getCol() <= 19){
            return true;
        }
        if(getCol() >= 0){
            return true;
        }
        if(getRow() >= 0){
            return true;
        }
        if(getRow() <= 19){
            return true;
        }
        return false;
    }

    */

    public int getCol(){
        return cursor.getCol();
    }

    public int getRow(){
        return cursor.getRow();
    }



    // FAZER METODO PAINT - IF CELL IS PAINTED == FALSE, CELL.PAINT()

    // FAZER METODO ERASE - IF CELL IS PAINTED == TRUE, CELL.ERASE()
}
