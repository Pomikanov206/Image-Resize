package resize;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgCreate {

    //Адрес и имя ноовй картинки
    private String path;
    private String[] arrayPath;

    public ImgCreate(String path){
        //Поиск конца строки и Изменение имени изображения
//        int index = path.lastIndexOf(".jpg");
        int index = path.lastIndexOf("\\");
        String newPathScaled = path.substring(0,index+1) + "scaled\\";
        this.path = newPathScaled + path.substring(index,path.length());
    }

    public ImgCreate(String[] path){
        //Поиск конца строки и Изменение имени изображения
        arrayPath = new String[path.length];
        for (int i = 0; i < arrayPath.length; i++) {
            int index = path[i].lastIndexOf(".jpg");
            this.path = path[i].substring(0,index) + "new.jpg";
        }

    }

    public void create(BufferedImage scaledImage){
        try {
            //Создания нового изображения в дирректории
            ImageIO.write(scaledImage,"JPEG",new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Создание нескольких изображений
    public void create(BufferedImage[] arrayScaledImage){
        for (int i = 0; i < arrayScaledImage.length; i++) {
            create(arrayScaledImage[i]);
        }
    }

}
