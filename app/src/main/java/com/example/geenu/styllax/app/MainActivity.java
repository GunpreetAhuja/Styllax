package com.example.geenu.styllax.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new MyAdapter(this));
    }

    private class MyAdapter extends BaseAdapter
    {
        private List<Item> items = new ArrayList<Item>();
        private LayoutInflater inflater;

        public MyAdapter(Context context)
        {
            inflater = LayoutInflater.from(context);

            items.add(new Item("Image 1", R.drawable.thumb1));
            items.add(new Item("Image 2", R.drawable.thumb2));
            items.add(new Item("Image 3", R.drawable.thumb3));
            items.add(new Item("Image 4", R.drawable.thumb4));
            items.add(new Item("Image 5", R.drawable.thumb5));
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i)
        {
            return items.get(i);
        }

        @Override
        public long getItemId(int i)
        {
            return items.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            View v = view;
            ImageView picture;
            TextView name;

            if(v == null)
            {
                v = inflater.inflate(R.layout.gridview_item, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
            }

            picture = (ImageView)v.getTag(R.id.picture);
            name = (TextView)v.getTag(R.id.text);

            Item item = (Item)getItem(i);

            picture.setImageResource(item.drawableId);
            name.setText(item.name);

            return v;
        }

        private class Item
        {
            final String name;
            final int drawableId;

            Item(String name, int drawableId)
            {
                this.name = name;
                this.drawableId = drawableId;
            }
        }
    }

}
/*
import android.app.Activity;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private Integer[] wallpaperThumbIntegers = {
            R.drawable.image1, R.drawable.image2,
            R.drawable.image3, R.drawable.image4,
            R.drawable.image5, R.drawable.image6,
            R.drawable.image7, R.drawable.image8
    };

    ImageView imagePreview;
    //Button button, button1;
    //ImageView image, image1;

//    Bitmap bitmap;
  //  int lastImageRef;

    /** Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        GridView gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new ImageAdapter(this));

        /*Button buttonSetWallpaper = (Button)findViewById(R.id.setWallpaper);
        imagePreview = (ImageView)findViewById(R.id.imageView1);
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
            }});*/
      /*  image = (ImageView) findViewById(R.id.imageView1);

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
    public class ImageAdapter extends BaseAdapter
    {
        private Context context;

        public ImageAdapter(Context c)
        {
            context = c;
        }

        //---returns the number of images---
        public int getCount() {
            return wallpaperThumbIntegers.length;
        }

        //---returns the ID of an item---
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        //---returns an ImageView view---
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(5, 5, 5, 5);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(wallpaperThumbIntegers[position]);
            return imageView;
        }
    }
}
        */