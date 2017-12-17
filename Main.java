import java.util.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    Label Heading1;
    TextField DenaryInput;
    ComboBox<String> Conv1;
    Label DenaryOutput;
    Label Heading2;
    TextField BinaryInput;
    ComboBox<String> Conv2;
    Label BinaryOutput;

    String binary1, binary2, denary1, denary2;

    @Override
    public void start(Stage primaryStage) {
        Heading1 = new Label();
        Heading1.setText("Denary to Binary Conversion:");
        Heading2 = new Label();
        Heading2.setText("Binary to Denary Conversion:");
        DenaryOutput = new Label();
        DenaryOutput.setText("Denary Output: ");
        BinaryOutput = new Label();
        BinaryOutput.setText("Binary Output: ");

        DenaryInput = new TextField();
        BinaryInput = new TextField();
        DenaryInput.textProperty().addListener(e -> Update());
        BinaryInput.textProperty().addListener(e -> Update());
        Conv1 = new ComboBox<String>();
        Conv1.getItems().addAll("Regular Positive Binary", "Two's Complement Binary", "Floating Point (beta)");
        Conv1.setValue("Regular Positive Binary");
        Conv2 = new ComboBox<String>();
        Conv2.getItems().addAll("Regular Positive Binary", "Two's Complement Binary", "Floating Point (beta)");
        Conv2.setValue("Regular Positive Binary");


        VBox pane = new VBox();
        pane.setSpacing(10);
        pane.setPadding(new Insets(10));
        pane.getChildren().addAll(Heading1, DenaryInput, Conv1, BinaryOutput, Heading2, BinaryInput, Conv2, DenaryOutput);
       // pane.setOnKeyPressed(e -> Update());

        Scene scene = new Scene(pane, 350, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Base Convertor");
        primaryStage.show();
    }

    public void Update(){
        BinaryNormal binary1 = new BinaryNormal();
        TCBinaryConv binary2 = new TCBinaryConv();
        TCFloatingPtConv binary3 = new TCFloatingPtConv();

        String denaryinput = DenaryInput.getText();
        String binaryinput = BinaryInput.getText();
        String binaryoutput = "";
        String denaryoutput = "";
        if(Conv1.getValue() == "Regular Positive Binary"){
            binaryoutput = binary1.convertToBinary(denaryinput);

        }
        else if(Conv1.getValue() == "Two's Complement Binary"){
            binaryoutput = binary2.convertToBinary(denaryinput);

        }
        else if(Conv1.getValue() == "Floating Point (beta)"){
            binaryoutput = binary3.convertToBinary(denaryinput);
        }


        if(Conv2.getValue() == "Regular Positive Binary"){
            denaryoutput = binary1.convertToDenary(binaryinput);

        }
        else if(Conv2.getValue() == "Two's Complement Binary"){
            denaryoutput = binary2.convertToDenary(binaryinput);
            System.out.println("Yee");
        }
        else if(Conv2.getValue() == "Floating Point (beta)"){
            denaryoutput = binary3.convertToDenary(binaryinput);
        }


        DenaryOutput.setText("Denary Output: " + denaryoutput);
        BinaryOutput.setText("Binary Output: " + binaryoutput);


    }

}
