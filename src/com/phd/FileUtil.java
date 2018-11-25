package com.phd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;


public class FileUtil {

    static String base = "/var/data";
    static String pathInput = new File(base).toURI().relativize(new File("input").toURI()).getPath();
    static String pathOutput = new File(base).toURI().relativize(new File("output").toURI()).getPath();

    static String unique = "unique.txt";
    static String duplicates = "duplicates.txt";
    static String unique_a = "unique_a.txt";

    public static void addEmail(String mail) {

        try
        {
            String filename = pathOutput + unique;
            FileWriter fw = new FileWriter(filename,true);
            fw.write(mail+ ",");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }

    }

    public static void addDuplicate(String mail) {

        try
        {
            String filename = pathOutput + duplicates;
            FileWriter fw = new FileWriter(filename,true);
            fw.write(mail + ",");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }


}