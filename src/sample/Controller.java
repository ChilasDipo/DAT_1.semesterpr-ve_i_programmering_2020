package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class Controller {

    @FXML
    TextArea ingredians;
    @FXML
    TextField select;


    @FXML
    String FindFood() {
        String foodname = select.getText();
        switch (foodname) {
            case "kaffe":
                return "src\\\\sample\\\\kaffe.txt";
            case "te":
                return "src\\\\sample\\\\te.txt";
            default:
                return "no food selected";
        }
    }

    @FXML
    void loadfromfile() throws IOException {
         String foodname = FindFood();
        FileReader file = new FileReader(foodname);
        BufferedReader input = new BufferedReader(file);

          Scanner scanner = new Scanner(new File(foodname));
          while (input.readLine() != null){
              ingredians.appendText(scanner.nextLine() + "/n");

          }




    }


}











