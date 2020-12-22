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
    String FindFood(String foodname) {
        // Brug af Swich til at finde hvilken opskrift der skal vises
        String[] foodlocation = {"kaffe" , "te" , "foodnotfound.txt"};
        String sammensatlocation ;
       /* switch (foodname) {
            case "kaffe":
                return "src\\sample\\opskifter\\kaffe.txt";
            case "te":
                return "src\\sample\\opskifter\\te.txt";
            default:
                return "src\\sample\\opskifter\\" + "foodnotfound.txt";
        }*/
        //finder den rigtige opskrift gennem et forloop, sammen ting med en swich kan ses ovenover
        for (int i = 0; i <foodlocation.length; i++) {
            if (foodlocation[i].equals(foodname)){
                sammensatlocation = "src\\sample\\opskifter\\" + foodlocation[i] + ".txt";
                return sammensatlocation;
            }
        }
        return "src\\sample\\opskifter\\foodnotfound.txt";
    }
   ArrayList<Image> findimage(){
        //arrayliste for at finde det rigtige image
        ArrayList<Image> imagelist = new ArrayList<Image>();
        String[] imagelistarray = {"sample/Pic/kaffepic.jpg" , "sample/Pic/te.jpg" , "sample/Pic/imagenotfound.png"} ;

        for (int i = 0; i <imagelistarray.length; i++) {
            Image image = new Image(imagelistarray[i]);
            imagelist.add(image);
        }
        return imagelist;
    }

    @FXML
    void loadfromfile() throws IOException {
        ingredians.clear();
        String foodnameinput = select.getText();
        String foodname = FindFood(foodnameinput);
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











