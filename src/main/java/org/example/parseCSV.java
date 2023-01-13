package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class parseCSV {
    public static void main(String[] Args) throws FileNotFoundException {


        /*Scanner in = new Scanner (System.in);
        String command = in.nextLine();*/

        String path = "/Users/aryan/Documents/activeCookie/cookie_log.csv";

        Scanner scan = new Scanner(new File(path));
        ArrayList<String[]> records = new ArrayList<String[]>();
        String[] record = new String[2];
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();

        while(scan.hasNext()) {
            record = scan.nextLine().split(",");
            a.add(record[0]);
            b.add(record[1]);
            records.add(record);
        }
        a.remove(0);
        b.remove(0);
        for (int i = 0; i < b.size(); i++) {
            String temp = b.get(i);
            temp = temp.replaceAll("T.*", "");
            b.set(i, temp);
        }


    }
}