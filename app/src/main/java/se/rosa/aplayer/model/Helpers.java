package se.rosa.aplayer.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Robert on 21/09/18.
 */

public class Helpers {
    public static Bitmap bitmapCreatorFromFilePath(String filePath) {
        return BitmapFactory.decodeFile(filePath);

    }
}
