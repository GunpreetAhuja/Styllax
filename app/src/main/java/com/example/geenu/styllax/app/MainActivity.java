package com.example.geenu.styllax.app;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    Button button, button1;
    ImageView image, image1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

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