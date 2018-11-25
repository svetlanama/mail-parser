package com.phd;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here

        DocumentFileReader fr = new DocumentFileReader();
        final File folder = new File(FileUtil.pathInput);
        fr.listFilesForFolder(folder);
    }
}
