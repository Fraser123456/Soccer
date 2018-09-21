
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author frase
 */
public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new FileReader("Soccer.txt"));
            Points point = new Points();
            String str;
            int count = 0;
            
            while(in.hasNext())
            {
                str = in.nextLine();
                String comma[] = str.split(",");
                for(int j=0; j<=1; j++){
                    String space[] = comma[j].split(" ");
                    String name = space[0];
                    int score = Integer.parseInt(space[1]);
                    if(j==0)
                    {
                        point.setName(name);
                        point.setScore(score);
                    }
                    if(j==1)
                    {
                        point.scoreCalc(name, score);
                    }
                }
            }
            in.close();
            point.ScoreBoard();
        } catch (Exception e) {
            System.out.println("File Not Found" + e);
        }
    }
}
