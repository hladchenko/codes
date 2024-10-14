package src.com.hladchenko;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var codes = readLines("src/com/hladchenko/codes");
        var lines = readLines("src/com/hladchenko/file.txt");

        List<String> newList = new ArrayList<>(codes);

        int count = 0;

        for (String line : lines) {
            boolean found = false;
            for (String code : codes) {
                if (line.equals(code)) {
                    count++;
                    newList.remove(code);
                }
            }
        }

        System.out.println(newList);

        System.out.println("Total: " + count);
    }

    public static List<String> readLines(String filename) {
        List<String> lines = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line.trim());
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
