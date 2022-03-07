package helloworld;
import javafx.scene.Group;
import javafx.scene.shape.Box;
import util.numbers;

//JavaFX Imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.concurrent.atomic.AtomicInteger;


//program has two user inputs and generates a random number between two numbers inputted
public class main extends Application {

    public static void main(String[]args) {
        launch(args); //launches program
    }

    @Override
    public void start(Stage primaryStage) throws Exception { //start of JavaFX application
        primaryStage.setTitle("Generates Random Numbers Between Parameters"); //sets application title
        GridPane root = new GridPane(); //creates a GridPane Layout

        Box box = new Box(200.0f, 120.0f, 150.0f); //creates box
        Group group = new Group(box);

        final Button btn1 = new Button(); //creates submit button
        btn1.setText("Submit"); //sets text for submit button
        final TextField tf0 = new TextField(); //final number appears in this text field
        final Label answer = new Label("Random Generated Number"); //label for answer textfield

        final Label des1 = new Label(); //button for first parameter
        final Label des2 = new Label(); //button for second parameter

        des1.setText("First Parameter, Minimum"); //sets text for button 1
        des2.setText("Second Parameter, Maximum"); //sets text for button 2

        final TextField tf1 = new TextField(); //user input for parameter one
        final TextField tf2 = new TextField(); //user input for parameter two

        btn1.setOnAction(new EventHandler<ActionEvent>() { //event handler for submit button
            @Override public void handle(ActionEvent e) {
                try {
                   int x = Integer.parseInt(tf1.getText()); //gets Integer from first textfield
                   int y = Integer.parseInt(tf2.getText()); //gets Integer from second textfield
                    numbers numbers = new numbers();
                    tf0.setText(String.valueOf(numbers.genrandom(x, y))); //sets the final text field to the generated number

                } catch(NumberFormatException c) { //runs if user does not input numbers
                    System.out.println("Number was not inputted by User"); //lets console know the user had an incorrect input
                }
            }
        });

        root.add(des1, 0, 1); //column 0, row 1
        root.add(tf1, 1, 1); //column 1, row 1

        root.add(des2, 0, 2); //column 0, row 2
        root.add(tf2, 1, 2); //column 1, row 2

        root.add(btn1, 0, 3); //column 0, row 3

        root.add (answer, 0, 4); //column 0, row 4
        root.add(tf0, 1, 4); //column 1, row 3

        Scene scene = new Scene(root, 300, 300); //creates application scene
        primaryStage.setScene(scene); //sets the scene to scene object
        primaryStage.show(); //shows code
    }
}