// File Name: EmployeeManager.java

import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static void main(String[] args) {
        Constants cons = new Constants();
        if (args.length != 1) {
            System.out.println("Error: This program requires one command line argument.");
            return;
        }

        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                String[] part = readFile(cons.filename);
                for (String emp : part) {
                    System.out.println(emp);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String[] part = readFile(cons.filename);
                Random rand = new Random();
                int idx = rand.nextInt(part.length);
                System.out.println(part[idx]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                appendToFile(cons.filename, ", " + args[0].substring(1));
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String[] part = readFile(cons.filename);
                String query = args[0].substring(1);
                boolean found = Arrays.asList(part).contains(query);
                System.out.println(found ? "Employee found!" : "Employee not found.");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String[] part = readFile(cons.filename);
                int wordCount = Arrays.stream(part).mapToInt(s -> s.split(" ").length).sum();
                System.out.println(wordCount + " word(s) found.");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String[] part = readFile(cons.filename);
                String target = args[0].substring(1);
                for (int i = 0; i < part.length; i++) {
                    if (part[i].equals(target)) {
                        part[i] = "Updated";
                    }
                }
                writeToFile(cons.filename, String.join(",", part));
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String[] part = readFile(cons.filename);
                String target = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(part));
                list.remove(args[0].substring(1));
                writeToFile(cons.filename, String.join(",", list));
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }
    }
    // Method to read data from file
    static String[] readFile(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = fileReader.readLine();
        fileReader.close();
        return line.split(",");
    }

    // Method to append data to file
    static void appendToFile(String fileName, String data) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
        fileWriter.write(data);
        fileWriter.close();
    }

    // Method to write data to file
    static void writeToFile(String fileName, String data) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        fileWriter.write(data);
        fileWriter.close();
    }
}
