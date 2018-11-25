package com.phd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class ParserUtil {


    public static void parseText(String text) {

        String[] arr = text.split(",");
        System.out.println("\n Parsed \n");
        for(int i=0; i<arr.length; i++)
        {
            //System.out.println("\n" + arr[i]);

            String email = arr[i].trim();
            if (isEmailExist(email) == false) {
                System.out.println("NOT EXIST " + email);
                FileUtil.addEmail(email);
            } else  {
                System.out.println("EXIST " + email);
                FileUtil.addDuplicate(email);
            }
        }
    }

    static boolean isEmailExist(String email) {
        File file = new File( FileUtil.pathOutput + FileUtil.unique);

        try {
            Scanner scanner = new Scanner(file);

            //now read the file line by line...
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                if(line.contains(email)) {
                    //System.out.println("ho hum, i found it on line " + lineNum);
                    scanner.close();
                    return true;
                }
            }

            scanner.close();

            return false;
        } catch(FileNotFoundException e) {
            //handle this
            return false;
        }
    }
}
