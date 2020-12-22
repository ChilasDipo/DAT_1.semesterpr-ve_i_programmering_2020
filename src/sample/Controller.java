package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
        String sammensatlocation ;
        FoodList foodlist = new FoodList();
       /* switch (foodname) {
            case "kaffe":
                return "src\\sample\\opskifter\\kaffe.txt";
            case "te":
                return "src\\sample\\opskifter\\te.txt";
            default:
                return "src\\sample\\opskifter\\" + "foodnotfound.txt";
        }*/
        //finder den rigtige opskrift gennem et forloop, sammen ting med en swich kan ses ovenover
        for (int i = 0; i <foodlist.size(); i++) {
            if (foodlist.readfoodname(i).equals(foodname)){
                return  "src\\sample\\opskifter\\" + foodlist.readfoodname(i) + ".txt";

            }
        }
        return "src\\sample\\opskifter\\foodnotfound.txt";
    }
   ArrayList<Image> findimage(){
        //arrayliste for at finde det rigtige image
        ArrayList<Image> imagelist = new ArrayList<Image>();
        String[] imagelistarray = {"sample/Pic/kaffepic.jpg" , "sample/Pic/te.jpg" , "sample/Pic/imagenotfound.png", "sample/Pic/imagenotfound.png"} ;

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
    @FXML
    TextField navntilopskrift;
    @FXML
    TextArea opskrift;
    @FXML
    void gemNyOpskrift() throws IOException {
        String name =  "src\\sample\\opskifter\\" + navntilopskrift.getText()+".txt";
        FileWriter fw = new FileWriter(name, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);
        String opskriftenstext = opskrift.getText();
        FoodList foodlist = new FoodList();
        foodlist.addtofoodlistarray(navntilopskrift.getText());
        foodlist.listeoveropskriftnavnesave();
        output.println("3");
        output.println(opskriftenstext);
        output.close();
    }
    public void swichpage(javafx.event.ActionEvent event)throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
    public void Tilbage(javafx.event.ActionEvent event)throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
    @FXML
    TextArea Opskriftliste;

    public void opskriftlite() throws IOException {
        FileReader file = new FileReader("opskriftliste.txt");
        BufferedReader input = new BufferedReader(file);
        Scanner scanner = new Scanner(new File("opskriftliste.txt"));
        while (input.readLine() != null) {
            String mad = scanner.next();
            Opskriftliste.appendText(mad + "\n");
        }
        scanner.close();


    }
}











