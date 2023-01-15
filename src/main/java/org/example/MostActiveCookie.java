package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class MostActiveCookie {
    /**
     * This program uses Arrays, ArrayLists, Maps, and HashMaps to parse through cookie_log.csv. Based on the parameters
     * provided in the command line, the program will use ArrayLists isolate cookies that have a date which matches the
     * parameter. Then a HashMap is used to extract the cookies that meet the criteria and a Map is used to find the
     * cookie(s) that occur the most and prints them to the console.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) {

        /*Since the file path and date parameter are provided in the command line, I am using args to isolate the
        necessary arguments and assign them each to a String variable.
        */
            String path = args[0];
            String commandInput = args[2];

            //execute
            createArrays(path, commandInput);
            String[] targetCookieFinal = createArrays(path, commandInput);
            findActiveCookie(targetCookieFinal);


    }


    private static String[] createArrays(String path, String commandInput) {
        /*
        ArrayLists will store each timestamp and the cookie array will hold the cookies that match the timestamp
        parameter after scanning through cookie_log.csv.
         */
        String[] record;
        ArrayList<String[]> records = new ArrayList<>();
        ArrayList<String> cookieArray = new ArrayList<>();
        ArrayList<String> timestampArray = new ArrayList<>();

        try {
            Scanner scan = new Scanner(new File(path));

            while (scan.hasNext()) {
            record = scan.nextLine().split(",");
            cookieArray.add(record[0]);
            timestampArray.add(record[1]);
            records.add(record);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        //Remove the first index because we do not need the "cookie" and "timestamp" label.
        cookieArray.remove(0);
        timestampArray.remove(0);


        int tsArraySize = timestampArray.size(); //For ease of usability.

        //Remove time signature, we only need the date.
        for (int i = 0; i < tsArraySize; i++) {
            String temp = timestampArray.get(i);
            temp = temp.replaceAll("T.*", "");
            timestampArray.set(i, temp);
        }

        //If the date matches parameter, store the date and use the index to find the corresponding cookie
        int count = 0;
        int arrSize = 0;
        for (int i = 0; i < tsArraySize; i++) {
            if (timestampArray.get(i).equals(commandInput)) {
                arrSize++;
            }
        }
        int[] targetDate = new int[arrSize];
        for (int i = 0; i < tsArraySize; i++) {
            if (timestampArray.get(i).equals(commandInput)) {
                targetDate[count] = i;
                count++;
            }
        }

        String[] targetCookie = new String[arrSize];
        for (int i = 0; i < targetDate.length; i++) {
            targetCookie[i] = cookieArray.get(targetDate[i]);
        }
        return targetCookie;
    }

    /*
    The HashMap is used to count how many times each cookie occurs in the cookie ArrayList. The Map is used to find
    which cookie(s) appears the most and print the result to the console.
     */
    public static void findActiveCookie(String[] targetCookie) {
        Map<String, Integer> cookieMap = new HashMap<>();
        for (String str : targetCookie) {
            Integer counter = cookieMap.get(str);
            if (counter == null) {
                cookieMap.put(str, 1);
            } else {
                cookieMap.put(str, ++counter);
            }
        }


        int max = 0;
        for (Map.Entry<String, Integer> entry : cookieMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<String, Integer> entry : cookieMap.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey());
            }
        }
    }


}
