package simple_db;

import java.io.*;
import java.util.*;

public class Simple_db {

    // Fields
    public static HashMap<Integer, String> map = new HashMap<Integer, String>();
    public static HashMap<String, String> map2 = new HashMap<String, String>();
    public static int id;

    public static void main(String[] args) throws IOException {
        
        // Run this method to create the DB (.txt file database.txt), with hardcoded inputs
        db_create();
        
        // Creating hashmap
        creating_hash();
        
        // Write a name to the database
        //db_write("Mikkel");
        //db_write("Hamza");
        
        // Read entire the database
        db_read();
        
        // Find specific ID in the database
        db_find("4");
    }

    public static void db_create() throws IOException {
        File f = new File("database.txt");
        if (f.exists()) {
            System.out.println("Database entered");
        } else {
            db_hardinput(); // Inputting hardcoded inputs
            try (FileWriter fw = new FileWriter("database.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                for (Integer key : map.keySet()) {
                    out.println(key + " " + map.get(key));
                }
            } catch (IOException e) {
                System.out.println("Could not create database - " + e);
            }
            System.out.println("Database created");
        }
    }

    public static void creating_hash() throws FileNotFoundException, IOException {
        String fileName = "database.txt"; // Opening file
        String line = null; // Referencing one line at a time
        try {
            FileReader fileReader = new FileReader(fileName); // FileReader reads text files in the default encoding.
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Always wrap FileReader in BufferedReader
            while ((line = bufferedReader.readLine()) != null) {
                id++; // Incrementing ID
                String value = line; // Creataing value for line
                String parts[] = value.split(" "); // Splitting based on first space
                map2.put(parts[0], parts[1]); // Adding to map2 hashmap
                //System.out.println(map2.get(Integer.toString(id))); // Printing hashmap
            }
            bufferedReader.close(); // Closing bufferedreader
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public static void db_write(String input) {
        try (FileWriter fw = new FileWriter("database.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            id++; // Icrementing ID
            map2.put(Integer.toString(id), " " + input); // Adding to map2 hashmap
            out.println(id + map2.get(Integer.toString(id))); // Printing new value from hashmap to database
        } catch (IOException e) {
            System.out.println("Error printing string - " + e);
        }
    }

    public static void db_read() {
        String fileName = "database.txt"; // Opening file
        String line = null; // Referencing one line at a time
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public static void db_find(String id) {
        System.out.println("Finding Value for key: " + id);
        System.out.println("Value = " + map2.get(id));
    }

    public static void db_hardinput() {
        map.put(1, "Mikkel");
        map.put(2, "Philip");
        map.put(3, "Iben");
        map.put(4, "Oliver");
        map.put(5, "Jan");
        map.put(6, "Louise");
        map.put(7, "Mette");
        map.put(8, "Emilie");
        map.put(9, "Frederik");
        map.put(10, "Nina");
    }
}
