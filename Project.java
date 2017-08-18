import resize.FileSearchFolder;
import resize.ImgCreate;
import resize.ImgOpen;
import resize.Resizer;

import java.awt.*;
import java.io.IOException;
/*
Программа для сжатия фотографий.
 */
public class Project {

    private final static String PATH_IMAGE = "src\\images\\agro100.jpg";
    private final static String PATH_FOLDER = "src\\images\\";

    public static void main(String[] args) throws IOException {
        System.out.println("Hello Andry!");
        //compos(url);

        //compos(PATH_IMAGE);
        multuCompos(PATH_FOLDER);
        // multuCompos(ImgOpen.loadArrayImages(url1));
        System.out.println("Finish!");
    }

    // Создание пользователя и вызов медода сжатия его фотографии.
    private static void compos(String path) {

        ImgOpen open = new ImgOpen(path);
        Image imageBasic = open.loadImage();

        //Уменьшение размера
        Resizer resizeImg = new Resizer();
        resizeImg.compress(imageBasic);

        ImgCreate scaledImg = new ImgCreate(path);
        scaledImg.create(resizeImg.getScaledImage());
    }

    private static void multuCompos(String path) {

        FileSearchFolder fileSearchFolder = new FileSearchFolder(path);
        String[] arrayPathFiles = fileSearchFolder.getFiles();

        for (int i = 0; i < arrayPathFiles.length; i++) {
            compos(arrayPathFiles[i]);
        }
    }
}
