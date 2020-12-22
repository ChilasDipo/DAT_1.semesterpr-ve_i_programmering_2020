package sample;

import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FoodList {
    ArrayList<String> foodlistarray = new ArrayList<String>();

    FoodList()   {

        try {
            FileReader file = new FileReader("opskriftliste.txt");
            BufferedReader input = new BufferedReader(file);
            Scanner scanner = new Scanner(new File("opskriftliste.txt"));
            while (input.readLine() != null) {

                String mad = scanner.next();
                foodlistarray.add(mad);
            }
                scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  foodlistarray.add("foodnotfound");
    }

    void addtofoodlistarray(String food){
        foodlistarray.add(food);
    }
    String readfoodname(int number){
        return foodlistarray.get(number);
    }
    int size(){
        return foodlistarray.size();
    }
    void listeoveropskriftnavnesave() throws IOException {
        for (int i = 0; i < foodlistarray.size() ; i++) {
            FileWriter fw = new FileWriter("opskriftliste.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter output = new PrintWriter(bw);
            output.println(foodlistarray.get(i));
            output.close();
        }
        //TODO NEED to find a way to make sure that file does not keep saving the same things from diffrent sessions
    }

}
