import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        if (args.length > 0) {
            try {
                File file = new File(args[0]);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null) {
                    list.add(line);
                    line = br.readLine();
                }
                list = getSeats(list);
                /*
                for (String s: list) {
                    System.out.println(s);
                }*/
                File fout = new File("out.txt");
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                for (String s : list) {
                    bw.write(s);
                    bw.newLine();
                }
                bw.close();
                System.out.println("Path: out.txt");
            } catch (FileNotFoundException e) {
                System.out.println("file not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static ArrayList<String> getSeats(ArrayList<String> orders) {
        // 10 rows, 20 seats per row
        char [] row = new char[10];
        for (int i = 0; i < 10; i++) {
            row[i] = (char)('A' + i);
        }
        int c = 0,r=0;
        boolean full = false;
        ArrayList<String> result = new ArrayList<>();
        for (String order : orders) {
            if (full) break;
            String [] str = order.split(" ");
            ArrayList<String> seats = new ArrayList<String>();
            int num_seat = Integer.parseInt(str[1]);
            while (c < 20 && num_seat > 0) {
                seats.add("" + row[r] + c);
                num_seat--;
                c++;
                if (c == 20) {
                    c = 0;
                    r += 2;
                    if (r > 9) {
                        System.out.println("theatre is full.");
                        full = true;
                        break;
                    }
                }
            }
            //now add 3 seats for space
            int empty = 3;
            while (c < 20 && empty > 0) {
                empty--;
                c++;
                if (c == 20) {//reset column
                    c = 0;
                    r += 2;
                    if (r > 9) {
                        full = true;
                        break;
                    }
                }
            }
            //make a string called seating and fill it
            String assigned_seat = "";
            for (String s: seats) {
                assigned_seat += s + ",";
            }
            assigned_seat = assigned_seat.substring(0,assigned_seat.length() -1); // cut off last comma

            result.add(str[0] + " " + assigned_seat); //reservation name + seats
        }
        return result;
    }
}
