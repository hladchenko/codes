package com.hladchenko;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var codes = readLines("codes.txt");
        var lines = readLines("file.txt");

        var newList = new ArrayList<>(codes);

        for (String line : lines) {
            for (String code : codes) {
                if (line.equals(code)) {
                    newList.remove(code);
                }
            }
        }
        crateNewFile(newList);
    }

    public static List<String> readLines(String filename) {
        List<String> lines = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line.trim());
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    public static void crateNewFile(List<String> lines) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("result.txt"))) {
            for (String line : lines) {
                br.write(line);
                br.newLine();
            }
            br.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
