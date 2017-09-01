import attributeAD.ImageAD;
import attributeAD.InfoAD;
import resize.FileSearchFolder;
import resize.ImgCreate;
import resize.ImgOpen;
import resize.Resizer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Программа для сжатия фотографий.
 */
public class Project {

    private final static String PATH_IMAGE = "src\\images\\agro100.jpg";
    private final static String PATH_DATA_FILE = "mail.csv";
    private final static String PATH_FOLDER = ".";
    private final static String PATH_FOLDER_IMG = "scaled\\";

    //Параметры сжатой картинки. Размеры.
    private static final int SCALED_WIDTH = 86;
    private static final int SCALED_HEIGHT = 86;

    public Project(){

    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello Andry!");
        //compos(url);
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.println("Resize files: 1\n" +
                    "add Image attribute: 2\n" +
                    "add other fields: 3\n" +
                    "exit: exit");

            line = reader.readLine();

            switch (line)
            {
                case "1": multuCompos(PATH_FOLDER);break;
                case "2": setImage(PATH_FOLDER_IMG);break;
                case "3": setAttributs(PATH_DATA_FILE);break;
                case "exit": ;break;
                default:
                    System.out.println("Error"); break;
            }

           // compos(PATH_IMAGE);
            //multuCompos(PATH_FOLDER);
        } while (!line.equals("exit"));
        System.out.println("Finish!");
    }

    // Создание пользователя и вызов медода сжатия его фотографии.
    private static void compos(String path) {

        ImgOpen open = new ImgOpen(path);
        Image imageBasic = open.loadImage();

        //Уменьшение размера
        try {
            Resizer resizeImg = new Resizer(imageBasic);
            resizeImg.compress();

            ImgCreate scaledImg = new ImgCreate(path);
            scaledImg.create(resizeImg.getScaledImage());
        }
        catch (NullPointerException e)
        {
            System.out.println("Folder.");
        }
    }

    private static void multuCompos(String path) {

        FileSearchFolder fileSearchFolder = new FileSearchFolder(path);
        String[] arrayPathFiles = fileSearchFolder.getFiles();

        for (int i = 0; i < arrayPathFiles.length; i++) {
            compos(arrayPathFiles[i]);
        }
    }

    private static void setImage(String path){
        FileSearchFolder fileSearchFolder = new FileSearchFolder(path);
        String[] names = fileSearchFolder.getFilesNames();
        for(String user: names) {
            ImageAD.setImage(user);
            System.out.println(user);
        }
    }

    private static void setAttributs(String path){
        InfoAD load = new InfoAD();
        load.setAttribute(path);
    }

}
