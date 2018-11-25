package com.phd;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.IOException;
        import java.io.BufferedReader;
        import java.io.FileReader;


public class DocumentFileReader {

    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
                readFile(fileEntry);
            }
        }
    }

    private void readFile(File inFile) {
//        File inFile = new File("inputText.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {

            String sCurrentLine;
            int i = 0;
//            while (((sCurrentLine = br.readLine()) != null) && (i<2))  {
//                System.out.println("line: " + i + "\n tex: " + sCurrentLine);
//                i++;
//            }
           if ((sCurrentLine = br.readLine()) != null) {
                System.out.println("line: " + i + "\ntex: " + sCurrentLine);
                i++;
            }

            ParserUtil.parseText(sCurrentLine);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}