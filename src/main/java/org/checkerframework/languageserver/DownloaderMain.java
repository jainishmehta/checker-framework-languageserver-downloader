/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.checkerframework.languageserver;

import java.io.File;
import java.io.IOException;

public class DownloaderMain {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("args: path-to-a-folder");
            System.exit(1);
        }

        File folder = new File(args[0]);
        if (!folder.isDirectory()) {
            System.err.println("The path provided is not a folder: " + args[0]);
        }

        try {
            File f = Downloader.downloadLanguageServer(folder);
            System.out.println("Got " + f.getAbsolutePath());
        } catch (IOException e) {

        }

        try {
            File f = Downloader.downloadCheckerFramework(folder);
            System.out.println("Got " + f.getAbsolutePath());
        } catch (IOException e) {

        }
    }
}
