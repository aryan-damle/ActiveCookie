package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class MostActiveCookie {
    public static void main(String[] Args) throws FileNotFoundException {

/*
        Scanner sc = new Scanner(new File("cookie_log.csv"));
        sc.useDelimiter(",");
        int count2 = 0;
        while(sc.hasNextLine()) {
            count2++;
            //System.out.print(sc.next() + " | ");

        }

 */
        /*Scanner in = new Scanner (System.in);
        String command = in.nextLine();*/
        String commandInput = "cookie_log.csv -d 2018-12-09";
        commandInput = commandInput.substring(commandInput.lastIndexOf("d ") + 2);



        String path = "cookie_log.csv";

        Scanner scan = new Scanner(new File(path));
        ArrayList<String[]> records = new ArrayList<>();
        String[] record;
        ArrayList<String> cookieArray = new ArrayList<>();
        ArrayList<String> timestampArray = new ArrayList<>();

        while(scan.hasNext()) {
            record = scan.nextLine().split(",");
            cookieArray.add(record[0]);
            timestampArray.add(record[1]);
            records.add(record);
        }
        cookieArray.remove(0);
        timestampArray.remove(0);
        for (int i = 0; i < timestampArray.size(); i++) {
            String temp = timestampArray.get(i);
            temp = temp.replaceAll("T.*", "");
            timestampArray.set(i, temp);
        }

        int count = 0;
        int arrSize = 0;
        for (int i = 0; i < timestampArray.size(); i++) {
            if (timestampArray.get(i).equals(commandInput)) {
                arrSize++;
            }
        }
            int[] targetDate = new int[arrSize];
        for (int i = 0; i < timestampArray.size(); i++) {
            if (timestampArray.get(i).equals(commandInput)) {
                targetDate[count] = i;
                count++;
            }
        }

        String[] targetDateCookie = new String [arrSize];
        for (int i = 0; i < targetDate.length; i++) {
            targetDateCookie[i] = cookieArray.get(targetDate[i]);
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : targetDateCookie) {
            Integer counter = map.get(str);
            if (counter == null) {
                map.put(str, 1);
            } else {
                map.put(str, ++counter);
            }
        }
        final Set<String> keySet = map.keySet();

        /*for (String str:keySet) {


            System.out.println(str + " = " + map.get(str));
        }

         */

        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey());
            }
        }






    }
}
