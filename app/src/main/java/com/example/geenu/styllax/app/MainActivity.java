package com.example.geenu.styllax.app;

import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {



    ImageView imagePreview;
    Button button, button1;
    ImageView image, image1;

    Bitmap bitmap;
   int lastImageRef;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                      TaskStackBuilder.create(this).addNextIntentWithParentStack(upIntent).startActivities();
                }
                else {
                      NavUtils.navigateUpTo(this, upIntent);
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("image", position);
                startActivity(intent);
            }
        });
    }

    public void openSearch()
    {

    }

    public void openSettings(){

    }

   /*   Button buttonSetWallpaper = (Button)findViewById(R.id.button);
        imagePreview = (ImageView)findViewById(R.id.imageView);
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
        image = (ImageView) findViewById(R.id.imageView);


        /*button = (Button) findViewById(R.id.btnNext);
        button.setOnClickListener(new DialogInterface.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                image.setImageResource(R.drawable.image2);
            }
        });*/
        /*image1 = (ImageView) findViewById(R.id.imageView1);

        button1 = (Button) findViewById(R.id.btnPrevious);
        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                image.setImageResource(R.drawable.image5);
            }
        });*/

    public static class ImageAdapter extends BaseAdapter
    {
        public static Integer[] wallpaperThumbIntegers = {
                R.drawable.thumb1, R.drawable.thumb2,
                R.drawable.thumb3, R.drawable.thumb4,
                R.drawable.thumb5, R.drawable.thumb6,
                R.drawable.thumb7, R.drawable.thumb8
        };

        Context context;

        public ImageAdapter(Context c)
        {
            super();
            context = c;
        }

        public int getCount() {
            return wallpaperThumbIntegers.length;
        }


        public Object getItem(int position) {
            return wallpaperThumbIntegers[position];
        }

        public long getItemId(int position) {
            return position;
        }


        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView imageView;
            if (convertView == null) { // if it's not recycled, initialize some attributes
                imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new GridView.LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(wallpaperThumbIntegers[position]);
            return imageView;
        }
    }
}


/*public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new MyAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("image", position);
                intent.putExtra("title", getTitle());
                startActivity(intent);
            }
        });
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

}*/