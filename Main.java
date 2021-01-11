package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Instantiate a Game.. this represents the starting location of the cursor
        Game game = new Game(0,0);



        //Instantiate GUI . The GUI constructor takes 3 parameters: amount of rows in grid, amount of columns in grid and a game which represents the starting location of the etch a sketch drawing
        EtchGUI myGui = new EtchGUI(50,60,game);


        primaryStage.setTitle("Homework 7");
         Scene scene = new Scene(myGui, 1150, 900);
                scene.getStylesheets().add("Demo.css");
                primaryStage.setScene(scene );
                if(game.isValidSquare(myGui) == true) {

                    scene.setOnKeyPressed(keyEvent -> {

                        //check to see whether the game is valid
                        if (keyEvent.getCode() == KeyCode.DOWN) {

                            //Everytime the cursor location changes the game class will check if the game is valid

                            game.setRow(game.getRow() + 1);
                            myGui.changeLabel(game);

                            myGui.colorTraversed(game);
                            myGui.pressKey(game);



                        } else if (keyEvent.getCode() == KeyCode.UP) {

                            game.setRow(game.getRow() - 1);
                            myGui.changeLabel(game);
                            myGui.colorTraversed(game);
                            myGui.pressKey(game);

                        } else if (keyEvent.getCode() == KeyCode.LEFT) {


                            game.setColumn(game.getColumn() - 1);
                            myGui.changeLabel(game);
                            myGui.colorTraversed(game);
                            myGui.pressKey(game);

                        } else if (keyEvent.getCode() == KeyCode.RIGHT) {


                            game.setColumn(game.getColumn() + 1);
                            myGui.changeLabel(game);
                            myGui.colorTraversed(game);
                            myGui.pressKey(game);


                        }

                    });
                }
                else{
                    //Console will print an error message and program won't run if the game coordinates are not valid
                    System.out.println("The game is not valid");
                }



                primaryStage.show();


            }
        }


