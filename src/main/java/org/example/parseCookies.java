package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class parseCookies {
    public String readCookies() {
        String path = "/Users/aryan/Documents/activeCookie/cookie_log.csv";
        String line = "";
        String[] vals = new String[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            while ((line = reader.readLine()) != null) {
                vals = line.split(",");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vals[1];
    }
}
