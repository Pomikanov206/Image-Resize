package resize;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Класс открытия изображений

public class ImgOpen {

    //private static final String FORMAT_IMG_MASK = "^.*\\.[a-zA-Z]{3,4}";
    private static final String FORMAT_IMG_MASK = "^.*\\.[(jpg)(jpeg)]{3,4}";
    private String path;

    public ImgOpen(String path)
    {
        this.path = path.toLowerCase();
    }

    //Создание файла и загрузка в него изображения
    public Image loadImage(){
        //Новое изображение

        if(!isImage(path))
        {
            System.out.println("Error! It is not Image");
            return null;
        }

        Image image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    //Создание файлов и загрузка в них изображений
//    public Image[] loadArrayImages(String pathFolder)
//    {
//        //Определение папки
//        File folder = new File(pathFolder);
//        //Получение списка имен файлов в папке
//        String[] arrayFilesNames = folder.list();
//
//        //Получение списка имен изображений в папке
//        ArrayList<String> arrayImageNames = new ArrayList<>();
//
//        for(int i = 0; i < arrayFilesNames.length; i++)
//        {
//            if(isImage(arrayFilesNames[i]))
//                arrayImageNames.add(arrayFilesNames[i]);
//        }
//
//        //Массив новых пустых файлов
//        Image[] arrayImage = new Image[arrayImageNames.size()];
//
//        //Заполняшка
//        for(int i = 0; i < arrayImageNames.size(); i++){
//
//            StringBuffer path = new StringBuffer();
//
//            path.append(pathFolder);
//            path.append(arrayImageNames.get(i));
//
//            if(!isImage(path.toString()))
//            {
//                System.out.println("Error Image");
//                continue;
//            }
//
//            arrayImage[i] = loadImage(path.toString());
//        }
//
//        return arrayImage;
//    }

    private static boolean isImage(String name){
        Pattern pattern = Pattern.compile(FORMAT_IMG_MASK);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
