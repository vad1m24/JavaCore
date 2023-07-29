package lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BackupFiles {

    /**
     * Написать функцию,
     * создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup
     */

    public static void main(String[] args) throws IOException {
        String sourcePath = "./";
        String destinationPath = "./backup/";

        String[] fileNames = getFiles(sourcePath);
        backupFiles(fileNames, destinationPath);
    }

    public static String[] getFiles(String sourceFilePath){
        File file = new File(sourceFilePath);
        return file.list();
    }

    public static void backupFiles(String[] files, String destinationFilePath) throws IOException {
        new File(destinationFilePath).mkdirs();
        try {
            for (String fileName : files){
                Files.copy(Path.of("./" + fileName), Path.of(destinationFilePath + fileName));
            }
        } catch (FileAlreadyExistsException e){
            System.out.println("File already exists " + e.getMessage());
        }
    }
}
