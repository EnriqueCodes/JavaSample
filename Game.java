package sample;

public class Game {

    private int row;
    private int column;




    public Game(int row, int column) {
        this.row = row;
        this.column = column;



    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }



    //Parameter is a GUI
    public  boolean isValidSquare(EtchGUI x ){



        if(getRow()< 0 || getColumn() <0 || getRow() > x.getRow() || getColumn() >x.getColumn()){
            return false;
        }
        else
            return true;

    }
}
