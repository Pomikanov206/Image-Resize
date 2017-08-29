package resize;

import java.io.File;

public class FileSearchFolder {

    private String pathFolder;
    private File folder;

    public FileSearchFolder(String pathFolder){
        this.pathFolder = pathFolder;
        folder = new File(pathFolder);
    }

    public String[] getFiles(){

        File[] files = folder.listFiles();
        String[] pathFiles = null;

        try {
            pathFiles = new String[files.length];
        }
        catch (NullPointerException e)
        {
            System.out.println(e.getStackTrace());
            return null;
        }

        for(int i = 0; i < files.length; i++)
        {

            pathFiles[i] = files[i].getPath();
        }

        return pathFiles;
    }

    public String[] getFilesNames(){
        return folder.list();
    }
}
