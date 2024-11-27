//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("Error: This programe requires one command line argument.");
            return;
        }
        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader filReader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
                String line = filReader.readLine();
                String part[] = line.split(",");
                for (String emp : part) {
                    System.out.println(emp);
                }
            } 
            catch (Exception e) {}
            System.out.println("Data Loaded.");
        } 
        else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            
            try {
                BufferedReader filReader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
                String line = filReader.readLine();
                System.out.println(line);
                String part[] = line.split(",");
                Random rand = new Random();
                int idx = rand.nextInt(part.length);
                System.out.println(part[idx]);
            }catch (Exception e) {}

            System.out.println("Data Loaded.");
        } 
        else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter filWriter = new BufferedWriter(new FileWriter("employees.txt", true));
                String newLine = args[0].substring(1);
                filWriter.write(", " + newLine);
                filWriter.close();
            } 
            catch (Exception e) {}
            
            System.out.println("Data Loaded.");
        } 
        else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader filReader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
                String line = filReader.readLine();
                String part[] = line.split(",");
                boolean found = false;
                String string = args[0].substring(1);
                for (int i = 0; i < part.length && !found; i++) {
                    if (part[i].equals(string)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } 
            catch (Exception e) {}
            System.out.println("Data Loaded.");
        } 
        else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader filReader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
                String line = filReader.readLine();
                char[] chars = line.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
            } 
            catch (Exception e) {}
            System.out.println("Data Loaded.");
        } 
        else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader filReader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
                String line = filReader.readLine();
                String part[] = line.split(",");
                String n = args[0].substring(1);
                for (int i = 0; i < part.length; i++) {
                    if (part[i].equals(n)) {
                        part[i] = "Updated";
                    }
                }
                BufferedWriter filWriter = new BufferedWriter(new FileWriter("employees.txt"));
                filWriter.write(String.join(",", part));
                filWriter.close();
            } 
            catch (Exception e) {}
            System.out.println("Data Updated.");
        } 
        else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader filReader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
                String line = filReader.readLine();
                String part[] = line.split(",");
                String n = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(part));
                list.remove(n);
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter("employees.txt"));
                fileWriter.write(String.join(",", list));
                fileWriter.close();
            } catch (Exception e) {}
            System.out.println("Data Deleted.");
        }
    }
}
