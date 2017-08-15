package resize;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

//Класс открытия изображений

public class ImgOpen {

    private final String FORMAT_JPG = ".jpg";
    private final String FORMAT_BMP = ".bmp";
    private final String FORMAT_GIF = ".gif";

    //Адрес одиночной картинки
    private String path;
    //Массив адресов картинок
    private String[] arrayPath;

    private Image image;
    private Image[] arrayImage;

    //Конструктор для одной картинки
    public ImgOpen(String path)
    {
        this.path = path.toLowerCase();
        boolean imgAvailability = path.toLowerCase().contains(FORMAT_JPG);
        if(path.contains(".jpg"))
            image = load(path);
        else
        {
            File folder = new File(path);
            File[] files = folder.listFiles();

        }
    }

    //Конструктор для нескольких картинок
    public ImgOpen(String[] arrayPath)
    {
        this.arrayPath = arrayPath;
        arrayImage = load(arrayPath);
    }

    //Создание файла и загрузка в него изображения
    private Image load(String path){
        //Новое изображение
        Image image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    //Создание файлов и загрузка в них изображений
    private Image[] load(String[] arrayPath)
    {
        //Массив новых пустых файлов
        Image[] arrayImage = new Image[arrayPath.length];

        //Заполняшка
        for(int i = 0; i < arrayPath.length; i++){
            arrayImage[i] = load(arrayPath[i]);
        }

        return arrayImage;
    }

    //Получение картинки
    public Image getImage(){
        return image;
    }

    //Получение картинок
    public Image[] getArrayImage(){
        return arrayImage;
    }

    //Адрес картинки
    public String getPath() {
        return path;
    }

    //Адреса картинок
    public String[] getArrayPath() {
        return arrayPath;
    }
}
