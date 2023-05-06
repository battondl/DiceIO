import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Generating 100 random dice rolls...");
     List<Integer> randomDiceRolls = genereateRandomDiceRolls();

     String fileName = "C:\\Users\\david\\workspace\\TestFiles\\diceRolls.txt";

        System.out.println("Saving dice rolls to file...\n\n");
     saveDiceRolls(fileName, randomDiceRolls);

        System.out.println("Reading dice rolls from file...\n\n");
     var diceRolls = readDiceRolls(fileName);

        System.out.printf("Printing dice rolls from file...\n\n");
     for(var roll : diceRolls) {
         System.out.println(roll);
     }

     int x = 5;
    }

    public static List<Integer> genereateRandomDiceRolls() {
        List<Integer> diceRolls = new ArrayList<>();
        Random rand = new Random();
        System.out.println("Generating 100 d6 rolls...\n\n");
        for(int i = 0; i < 100; i++) {
            int randomNumber = rand.nextInt(6) + 1;
            System.out.println("Roll " + (i+1) + " is: " + randomNumber);
            diceRolls.add(randomNumber);
        }
        return diceRolls;
    }

    public static void saveDiceRolls(String fileName, List<Integer> diceRolls) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for(Integer roll : diceRolls) {
                bufferedWriter.write(roll.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch(IOException ex) {
            System.out.println("Error saving file...");
        }
    }

    public static List<Integer> readDiceRolls(String fileName) throws IOException {
        List<Integer> diceRolls = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String input;
            while((input = bufferedReader.readLine()) != null) {
                diceRolls.add(parseInt(input));
            }
            bufferedReader.close();
        } catch(IOException ex) {
            System.out.println("Error reading file");
        }
        return diceRolls;
    }
}