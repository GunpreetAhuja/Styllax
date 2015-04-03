package com.example.geenu.styllax.app;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends Activity {

    Button button, button1;
    ImageView image, image1;

    Bitmap bitmap;
    int lastImageRef;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSetWallpaper = (Button)findViewById(R.id.setWallpaper);
        ImageView imagePreview = (ImageView)findViewById(R.id.imageView1);
        imagePreview.setImageResource(R.drawable.image1);

        buttonSetWallpaper.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                WallpaperManager myWallpaperManager
                        = WallpaperManager.getInstance(getApplicationContext());
                try {
                    myWallpaperManager.setResource(+R.drawable.image1);
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }});
        image = (ImageView) findViewById(R.id.imageView1);

        button = (Button) findViewById(R.id.btnNext);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                image.setImageResource(R.drawable.image2);
            }
        });
        image1 = (ImageView) findViewById(R.id.imageView1);

        button1 = (Button) findViewById(R.id.btnPrevious);
        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                image.setImageResource(R.drawable.image5);
            }
        });
    }

}