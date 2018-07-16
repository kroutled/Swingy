package co.za.kroutled.Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public boolean readFile(String filename) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("/goinfre/kroutled/Desktop/Swingy/test.txt"));

            String line = reader.readLine();
            System.out.println(line);
            if (line != null) {

                while ((line = reader.readLine()) != null) {

                    System.out.println(line.split(" ")[0]);
                }
            }
        } catch (IOException e) {
            System.out.println("There was an error whilst reading the file ");
        }
        return true;
    }
}
