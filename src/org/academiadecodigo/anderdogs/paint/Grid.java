package org.academiadecodigo.anderdogs.paint;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Grid {
    //Properties
    private int col;
    private int row;
    private Cell[][] cells;
    private Cell cell;
    private Cursor cursor;

    //Construtor
    public Grid(int col, int row){
        this.col = col;
        this.row = row;
        cells = new Cell[col][row];
        init();

    }

    //Methods
    public void init(){
        for (int col =0; col<this.col; col++){ //Percorre todas as colunas
            for(int row=0; row<this.row; row++){ //Percorre todas as linhas para cada coluna referente ao loop de cima
                cells[col][row] = new Cell(col,row) ; //Guarda cada col e cada row num array de arrays
                //cell = new Cell(col,row);//Cria uma nova célula em cada iteração
            }
        }
    }

    public Cell getCells(int col, int row){
        return cells[col][row];
    }
    public Cell[][] getCellsArr(){
        return cells;
    }
    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    /*public void paints(int col, int row){
        cells[cell.getCol()][cell.getRow()].paints();
    }

     */


}
