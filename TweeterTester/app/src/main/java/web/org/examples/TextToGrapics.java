package web.org.examples;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;

import java.io.File;
import java.io.FileOutputStream;


public class TextToGrapics {

    public static void main(String[] args) {
        String text="Hello World";
        TextPaint textPaint = new TextPaint() {
            {
                setColor(Color.WHITE);
                setTextAlign(Paint.Align.LEFT);
                setTextSize(20f);
                setAntiAlias(true);
            }
        };
        final Rect bounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), bounds);

        final Bitmap bmp = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.RGB_565); //use ARGB_8888 for better quality
        final Canvas canvas = new Canvas(bmp);
        canvas.drawText(text, 0, 20f, textPaint);
        FileOutputStream stream =null;
        File newfile = new File("/home/rami/arun/android/");
        try{
             stream = new FileOutputStream(newfile);
        }catch (Exception e) {

        }

        bmp.compress(Bitmap.CompressFormat.PNG, 85, stream);
        bmp.recycle();
        try{
            stream.close();
        }catch (Exception e) {

        }

    }

}
