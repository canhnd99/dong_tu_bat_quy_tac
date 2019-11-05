package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataController {

    private static final String FILENAME = "words.txt";


    public String[][] readData() throws FileNotFoundException {
        File file = new File(FILENAME);
        String[][] res;
        Scanner input = new Scanner(file);
        res = new String[250][4];
        int row = 0;
        while (input.hasNext()) {
            res[row][0] = input.nextLine();
            res[row][1] = input.nextLine();
            res[row][2] = input.nextLine();
            res[row][3] = input.nextLine();
            row++;
        }
        return res;
    }

    public ArrayList<Word> getListWords() throws FileNotFoundException {
        ArrayList<Word> list = new ArrayList<>();

        File file = new File(FILENAME);

        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String v1 = input.nextLine();
            String v2 = input.nextLine();
            String v3 = input.nextLine();
            String m = input.nextLine();
            Word w = new Word(v1, v2, v3, m);
            list.add(w);
        }

        return list;
    }
}
