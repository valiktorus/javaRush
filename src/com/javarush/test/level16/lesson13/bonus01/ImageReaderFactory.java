package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Torus on 16.11.2016.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes imageTypes){
        if (ImageTypes.BMP == imageTypes)
            return new BmpReader();
        else if (ImageTypes.JPG == imageTypes)
            return new JpgReader();
        else if (ImageTypes.PNG == imageTypes)
            return new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
