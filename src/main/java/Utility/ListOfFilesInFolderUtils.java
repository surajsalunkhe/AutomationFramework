package Utility;

import java.io.File;

public final class ListOfFilesInFolderUtils {

    private ListOfFilesInFolderUtils(){}

    /**
     * This method is to get file name especially for file name that are created  using date and time and are saved in a folder
     * @param folderPath
     * @return
     */
    public static File[] listOfFilesInFolder(String folderPath){
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
        return listOfFiles;
    }
}
