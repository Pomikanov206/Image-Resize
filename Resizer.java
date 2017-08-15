package resize;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Resizer {

    //Параметры сжатой картинки. Размеры.
    private final int SCALED_WIDTH = 86;
    private final int SCALED_HEIGHT = 86;

    //Сжатое изображение
    BufferedImage scaledImage;

    //Консктруктор открытия фотографии и создание пустой болванки для сжатой фотографии
    public Resizer(){
        //Создание болванки
        scaledImage = new BufferedImage(SCALED_WIDTH, SCALED_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    //Логика сжатия.
    public void compress(Image originalImage) {
        //Запись болванки
        Graphics2D g = scaledImage.createGraphics();

        //Наложение на болванку исходника
        g.drawImage(originalImage, 0, 0, SCALED_WIDTH, SCALED_HEIGHT, null);
        g.dispose();

    }

    //Получение сжатой картинки
    public BufferedImage getScaledImage(){
        return scaledImage;
    }

}
