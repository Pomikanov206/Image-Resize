package resize;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;


public class Resizer {

    //Параметры сжатой картинки. Размеры.
    private final int SCALED_WIDTH = 86;
    private final int SCALED_HEIGHT = 86;

    private Image originalImage;

    private int width, height;

    //Сжатое изображение
    private BufferedImage scaledImage;

    private Graphics2D g;

    //Консктруктор открытия фотографии
    public Resizer(Image originalImage){

        this.originalImage = originalImage;

        ImageObserver img = (img1, infoflags, x, y, width1, height1) -> false;

        width = originalImage.getWidth(img);
        height = originalImage.getHeight(img);

    }

    //Логика сжатия.
    public void compress() {

        double ratio = scaledRatio(width,height);

        int ratioWidth = (int)(width/ratio);
        int ratioHeight = (int)(height/ratio);

        //Создание болванки
        scaledImage = new BufferedImage(ratioWidth, ratioHeight, BufferedImage.TYPE_INT_RGB);
        //Запись болванки
        g = scaledImage.createGraphics();

        //Наложение на болванку исходника
        g.drawImage(originalImage.getScaledInstance(ratioWidth,ratioHeight,Image.SCALE_AREA_AVERAGING), 0, 0, null);

//        for (int i = 2; i < ratio; i ++)
//            g.drawImage(originalImage, 0, 0, ratioWidth, ratioHeight, null);

        g.dispose();



    }

    private double scaledRatio(int width, int height)
    {
        if(width > height)
            return (double) height/SCALED_HEIGHT;
        else
            return (double) width/SCALED_WIDTH;
    }

    //Получение сжатой картинки
    public BufferedImage getScaledImage(){
        return scaledImage;
    }

}
