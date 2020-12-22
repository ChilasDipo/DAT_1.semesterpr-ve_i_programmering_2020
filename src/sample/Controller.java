package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    @FXML
    TextArea ingredians;
    @FXML
    TextField select;
    @FXML
    ImageView imageview;

    @FXML
    String FindFood() {
        // Brug af Swich til at finde hvilken opskrift der skal vises
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
   ArrayList<Image> findimage(){
        //arrayliste for at finde det rigtige image
        ArrayList<Image> imagelist = new ArrayList<Image>();
        String[] imagelistarray = {"sample/Pic/kaffepic.jpg" , "sample/Pic/te.jpg"} ;

        for (int i = 0; i <imagelistarray.length; i++) {
            Image image = new Image(imagelistarray[i]);
            imagelist.add(image);
        }
        return imagelist;
    }

    @FXML
    void loadfromfile() throws IOException {
        ingredians.clear();
        String foodname = FindFood();
        FileReader file = new FileReader(foodname);
        BufferedReader input = new BufferedReader(file);

          Scanner scanner = new Scanner(new File(foodname));
          int arraypladsfromfile = scanner.nextInt();
          while (input.readLine() != null){
              ingredians.appendText(scanner.nextLine());
              ingredians.appendText("\n");
          }
        ArrayList<Image> imagelist = findimage();
        imageview.setImage(imagelist.get(arraypladsfromfile));



    }


}











