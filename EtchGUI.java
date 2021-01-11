package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class EtchGUI extends BorderPane {

    private int row;
    private int column;
    Game game;
    private Label [][] arrayOfLabels;

    //Create several variables that are needed inside some of the methods..
    Label cursor;
    boolean [][] traverseStatus;
    final int xCoordinate;
    final int yCoordinate;


    //takes the number of rows and columns that will be on the screen also takes a game as a parameter
    public EtchGUI(int row, int column,Game game) {
        this.row = row;
        this.column = column;



        //Create horizontal box for two labels on top
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);

        //create a gridpane
        GridPane grid = new GridPane();
        setTop(box);
        setCenter(grid);
        grid.setAlignment(Pos.CENTER);

        cursor = new Label("Cursor Location: [" + game.getRow() + "]" + "[" + game.getColumn() + "]");
        cursor.getStyleClass().add("cursorLabel");

        Label shake = new Label("Shake");
        shake.getStyleClass().add("shakeLabel");
        box.getChildren().add(0,cursor);
        box.getChildren().add(1,shake);

        //Add horizontal box to border pane top

        //create a 2d array of labels
        arrayOfLabels = new Label[row][column];


         //Starting point is a final to identify the starting coordinates of the game
        xCoordinate = game.getRow();
       yCoordinate = game.getColumn();


        traverseStatus =new boolean[row][column];


        for (int i = 0; i <row; i++) {

            for (int j = 0; j < column; j++) {

                if(i==game.getRow() && j ==game.getColumn()){

                    Label myLabel = new Label(" ");
                    myLabel.getStyleClass().add("currentCursorLocation");

                    arrayOfLabels[i][j] = myLabel;
                    grid.add(arrayOfLabels[i][j], j, i);
                }
                else{
                    Label myLabel = new Label(" ");
                    myLabel.getStyleClass().add("notTraversed");

                    arrayOfLabels[i][j] = myLabel;
                    grid.add(arrayOfLabels[i][j], j, i);
                }






            }


        }
        //After setting all labels to default background, remove the default background and then set the label of the current location to red background

        //Event Handler for shake label click

        shake.setOnMouseClicked(mouseEvent -> {
            revertLabels(getRow(),getColumn(),arrayOfLabels);

        });



    }





//Getters and Setters
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



    public void revertLabels(int row, int column, Label[][] x){




        for (int i = 0; i < row; i++) {

            for (int j = 0; j <column ; j++) {



                if(x[i][j].getStyleClass().equals("notTraversed")==false){
                    x[i][j].getStyleClass().removeAll("traversedButNotCursorLocation","currentCursorLocation");
                    x[i][j].getStyleClass().add("notTraversed");

                    revertTraversebool(traverseStatus);




                }





            }

        }

    }

    //Traverse labels method
//---------------------------------------------------------------------------------------------------------------------
    public void pressKey(Game y){



        if(arrayOfLabels[xCoordinate][yCoordinate].getStyleClass().contains("currentCursorLocation")){
            arrayOfLabels[xCoordinate][yCoordinate].getStyleClass().remove("currentCursorLocation");
            arrayOfLabels[xCoordinate][yCoordinate].getStyleClass().add("traversedButNotCursorLocation");
        }






        for (int i = 0; i < getRow(); i++) {

            for (int j = 0; j < getColumn(); j++) {





                if(i==y.getRow() && j==y.getColumn() ) {

                    arrayOfLabels[i][j].getStyleClass().add("currentCursorLocation");
                    traverseStatus[i][j] = true;
                    System.out.println("[" + i + "]" + "[" + j + "]" + " has been traversed" );
                }





            }
        }
    }
    //---------------------------------------------------------------------------------------------------------------------

    public void changeLabel(Game x){

        String currentLocation = "Cursor Location: [" + x.getRow() + "]" + "[" + x.getColumn() + "]";
        cursor.setText(currentLocation);
    }

    public void colorTraversed(Game x){

        for (int i = 0; i <getRow(); i++) {

            for (int j = 0; j <getColumn() ; j++) {



                if(traverseStatus[i][j] == true ){
                    arrayOfLabels[i][j].getStyleClass().removeAll("currentCursorLocation");
                    arrayOfLabels[i][j].getStyleClass().add("traversedButNotCursorLocation");
                }







            }

        }
    }

    public void revertTraversebool(boolean [][] x){

        for (int i = 0; i <getRow() ; i++) {

            for (int j = 0; j < getColumn(); j++) {

                traverseStatus[i][j] = false;
            }

        }
    }



}

