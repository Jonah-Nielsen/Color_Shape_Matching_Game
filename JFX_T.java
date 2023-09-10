package jfx_t;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import java.util.*;
import javafx.scene.control.ToggleGroup;

public class JFX_T extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
      
      
      // Here we set up the Border Pane to hold the start-up scene
      BorderPane strtSkrn = new BorderPane();
      //Here we make the label used to introduce the game
      Label startScreen = new Label("The Color and Shape Matching Game!");
      startScreen.setAlignment(Pos.CENTER);
      // Here we make a HBox to hold our buttons for starting the game and
      // exiting the game
      HBox sb = new HBox(50);
      Button startGame = new Button("Start Game"); 
      Button exit = new Button("Exit");
      exit.setOnAction(e -> {
          System.exit(0);
      });
      startGame.setOnAction(e -> {
          mainGame(primaryStage);
      });
      sb.getChildren().addAll(exit, startGame);
      sb.setAlignment(Pos.CENTER);
      // Here we put everything into the Border Pane
      strtSkrn.setBottom(sb);
      strtSkrn.setCenter(startScreen);
      // Here we create and show the scene on the stage
      Scene strt = new Scene(strtSkrn);
      primaryStage.setTitle("Color and Shape Matching Game");
      primaryStage.setScene(strt);
      primaryStage.show();
      
      
  
      
  
       
      
   
}

/* main game scene*/
      public void mainGame(Stage primaryStage){
      // Here we create an array, answer to hold the users answer
         int[] answer = new int[2];
         answer[0] = 7;
         answer[1] = 7;
      // Here we create an object of the Randomizer class that will allow
      // us to get random colors and draw the random shape
         Randomizer ran = new Randomizer();
         ran.ranColor();
         ran.ranShape();
         int[] cS = {ran.getColor(), ran.getShape()};
      // Create a VBox to hold the Color radio Buttons
         VBox center = new VBox();
      // Place the shape in the VBox
         center.getChildren().addAll(ran.drawShape(cS[0], cS[1]));
         center.setAlignment(Pos.CENTER);
         
         //Creating the box to hold the color's radiobox 
         //on the left side of the screen
         
         VBox left = new VBox(35);
         RadioButton rbRed = new RadioButton ("Red");
         RadioButton rbGreen = new RadioButton ("Green");
         RadioButton rbBlue = new RadioButton ("Blue");
         RadioButton rbYellow = new RadioButton ("Yellow");
         RadioButton rbPurple = new RadioButton ("Purple");
         ToggleGroup cgp = new ToggleGroup();
         // Create the toggle group for the colors
         rbRed.setToggleGroup(cgp);
         rbGreen.setToggleGroup(cgp);
         rbBlue.setToggleGroup(cgp);
         rbYellow.setToggleGroup(cgp);
         rbPurple.setToggleGroup(cgp);
         // Set what each button does
         rbRed.setOnAction(e -> {
             answer[0] = 0;
         });
         rbGreen.setOnAction(e -> {
             answer[0] = 1;
         });
         rbBlue.setOnAction(e -> {
             answer[0] = 2;
         });
         rbYellow.setOnAction(e -> {
             answer[0] = 3;
         });
         rbPurple.setOnAction(e -> {
             answer[0] = 4;
         });
         //Place the buttons in the VBox
         left.getChildren().addAll(rbRed, rbGreen, rbBlue, rbYellow, rbPurple);
         left.setAlignment(Pos.BASELINE_LEFT);
         
         
         //Creating the box to hold the shape's radiobox 
         //on the right side of the screen
         VBox right = new VBox(55);
         ToggleGroup sgp = new ToggleGroup();
         RadioButton rbCircle = new RadioButton("Circle");
         RadioButton rbTriangle = new RadioButton("Triangle");
         RadioButton rbRectangle = new RadioButton("Rectangle");
         RadioButton rbPentagon = new RadioButton("Pentagon");
         // Set the toggle group for the shape radio buttons
         rbCircle.setToggleGroup(sgp);
         rbTriangle.setToggleGroup(sgp);
         rbRectangle.setToggleGroup(sgp);
         rbPentagon.setToggleGroup(sgp);
         // Set what each button does
         rbCircle.setOnAction(e -> {
             answer[1] = 0;
         });
         rbTriangle.setOnAction(e -> {
             answer[1] = 1;
         });
         rbRectangle.setOnAction(e -> {
             answer[1] = 2;
         });
         rbPentagon.setOnAction(e -> {
             answer[1] = 3;
         });
         // Place the buttons in the VBox
         right.getChildren().addAll(rbCircle, rbTriangle, rbRectangle, rbPentagon);
         right.setAlignment(Pos.BASELINE_LEFT);
         
         // Create the bottom hbox to hold the submit and exit button
         // as well as a label instructing the user what to do
         
         HBox bottom = new HBox(50);
         
         Label instructions = new Label("Choose the correct color"
                 + "and shape then select submit when you think you have the"
                 + " answer or click exit if you wish to exit");
         
         Button submit = new Button("Submit");
         
         submit.setOnAction(e ->{
             //Check Answer
             solution(primaryStage, cS[0], answer[0], cS[1], answer[1]);
         });
         
         Button exit = new Button("Exit");
             //Exit Game
             exit.setOnAction(e -> {
          System.exit(0);
         });
         // Place the Label and Buttons in the HBox
         bottom.getChildren().addAll(instructions, exit, submit);
         bottom.setAlignment(Pos.BOTTOM_LEFT);
         //Create a Border Pane to hold all the other panes
         BorderPane layout = new BorderPane();
         
         layout.setCenter(center);
         layout.setBottom(bottom);
         layout.setLeft(left);
         layout.setRight(right);
  //Place the Border Pane in the Scene set the new Scene as the current scene 
         Scene scene = new Scene(layout);
         primaryStage.setScene(scene);
                 
                 
  }
      //End Screen Scene
      public void solution(Stage primaryStage, int correctCol, int answerCol, int correctShape,int answerShape){
          
          //Set the text for the screen
          Label sol = new Label();
          if (correctCol==answerCol&&correctShape==answerShape){
              sol.setText("That's Right, Congradulations!");
          }
          
          else{
              sol.setText("That's Wrong, Sorry");
          }
          //Create the layout
          HBox buttons = new HBox(100);
          Button exit = new Button("Exit");
          Button goAgain = new Button("Go Again");
          //Set up the Exit button
          exit.setOnAction(e -> {
          System.exit(0);
          });
          //Set up the go again button
          goAgain.setOnAction(e -> {
          mainGame(primaryStage);
          });
          
          buttons.getChildren().addAll(exit, goAgain);
          buttons.setAlignment(Pos.CENTER);
          BorderPane layout = new BorderPane();
          layout.setBottom(buttons);
          layout.setCenter(sol);
   //Place the Border Pane in the Scene set the new Scene as the current scene
          Scene scene = new Scene(layout);
          primaryStage.setScene(scene);
      
      }
      
      /* Randomizer Class*/
      public class Randomizer{
          int color = 0;
          int shape = 0;
          Random rand = new Random();
          
          public void ranColor(){
              color = rand.nextInt(5);
          }
          
          public void ranShape(){
              shape = rand.nextInt(4);
          }
          
          public int getColor(){
              return color;
          }
          
          public int getShape(){
              return shape;
          }
          
          public Shape drawShape(int c, int s){
              double[] col = new double[3];
              if (c == 0){
              // RGB for Red
                  col[0] = 1.0;
                  col[1] = 0.1;
                  col[2] = 0.1;
              }
              else if (c == 1){
                  // RGB for Green
                  col[0] = 0.1;
                  col[1] = 1.0;
                  col[2] = 0.1;
              }
              else if (c == 2){
                  // RGB for Blue
                  col[0] = 0.1;
                  col[1] = 0.1;
                  col[2] = 1.0;
              }
              else if (c == 3){
                  // RGB for Yellow
                  col[0] = 1.0;
                  col[1] = 1.0;
                  col[2] = 0.1;
              }
              else{
                  // RGB for Purple
                  col[0] = 0.6;
                  col[1] = 0.1;
                  col[2] = 0.6;
              }
              
              if (s == 0){
                  // Draw a Circle
                  Circle r = new Circle(120);
                  r.setFill(Color.color(col[0], col[1], col[2]));
                  r.setStroke(Color.BLACK);
                  return r;
              }
              
              else if (s == 1){
                  // Draw a Triangle
                  Polygon r = new Polygon();
                  r.getPoints().addAll(new Double[]{
                      70.0, 10.0,
                      140.0, 150.0,
                      0.0, 150.0
                  });
                  r.setFill(Color.color(col[0], col[1], col[2]));
                  r.setStroke(Color.BLACK);
                  return r;
                  
          }
              else if (s == 2){
                  // Draw a Rectangle
                  Rectangle r = new Rectangle(150, 90, 250, 150);
                  r.setFill(Color.color(col[0], col[1], col[2]));
                  r.setStroke(Color.BLACK);
                  return r;
      }
              else {
                  // Draw a Pentagon
                  Polygon r = new Polygon();
                  r.getPoints().addAll(new Double[]{
                      90.0, 30.0,
                      160.0, 90.0,
                      140.0, 170.0,
                      40.0, 170.0,
                      20.0, 90.0
                  });
                  r.setFill(Color.color(col[0], col[1], col[2]));
                  r.setStroke(Color.BLACK);
                  return r;
              }
                
          }
         }

}