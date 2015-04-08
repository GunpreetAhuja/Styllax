package com.example.geenu.styllax.app;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import static com.example.geenu.styllax.app.MainActivity.ImageAdapter.wallpaperThumbIntegers;

/**
 * Created by geenu on 5/4/15.
 */
public class DetailActivity extends ActionBarActivity {

    int i;
    private ProgressDialog simpleWaitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        //for (i = 0; i < 8; i++) {
        final Bitmap bitmap = getIntent().getParcelableExtra("image");

        final ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(bitmap);
        //  imageView.setTag(i);

        Button button = (Button) findViewById(R.id.button);
        //Button button1 = (Button) findViewById(R.id.download);

        //imageView.setId(i);

        ImageView img = (ImageView) findViewById(R.id.image);

        int imgid = getIntent().getIntExtra("IMAGE", 0);//imageView.getId());
        img.setImageResource(wallpaperThumbIntegers[imgid]);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                try {
                    WallpaperManager myWallpaperManager
                            = WallpaperManager.getInstance(getApplicationContext());
                    myWallpaperManager.setResource(+R.drawable.thumb1);//wallpaperThumbIntegers[v.getId()]);

                    Toast.makeText(DetailActivity.this, "Wallpaper set",
                            Toast.LENGTH_SHORT).show();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        });
    }
}
       /* button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                    new ImageDownloader().execute(downloadUrl);
                }
        });
        }
    //}

    public void setWallpaper(int j) {

    }

    /*private class ImageDownloader extends AsyncTask {

        @Override
        protected Bitmap doInBackground(String... param) {
            // TODO Auto-generated method stub
            return downloadBitmap(param[0]);
        }

        @Override
        protected void onPreExecute() {
            Log.i("Async-Example", "onPreExecute Called");
            simpleWaitDialog = ProgressDialog.show(DetailActivity.this,
                    "Wait", "Downloading Image");

        }

        @Override
        protected void onPostExecute(Bitmap result) {
            Log.i("Async-Example", "onPostExecute Called");
            downloadedImg.setImageBitmap(result);
            simpleWaitDialog.dismiss();

        }

        private Bitmap downloadBitmap(String url) {
            // initilize the default HTTP client object
            final DefaultHttpClient client = new DefaultHttpClient();

            //forming a HttoGet request
            final HttpGet getRequest = new HttpGet(url);
            try {

                HttpResponse response = client.execute(getRequest);

                //check 200 OK for success
                final int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode != HttpStatus.SC_OK) {
                    Log.w("ImageDownloader", "Error " + statusCode +
                            " while retrieving bitmap from " + url);
                    return null;

                }

                final HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream inputStream = null;
                    try {
                        // getting contents from the stream
                        inputStream = entity.getContent();

                        // decoding stream data back into image Bitmap that android understands
                        final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                        return bitmap;
                    } finally {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        entity.consumeContent();
                    }
                }
            } catch (Exception e) {
                // You Could provide a more explicit error message for IOException
                getRequest.abort();
                Log.e("ImageDownloader", "Something went wrong while" +
                        " retrieving bitmap from " + url + e.toString());
            }

            return null;
        }
    }

}



    /*Button buttonSetWallpaper = (Button)findViewById(R.id.button);
    imagePreview = (ImageView)findViewById(R.id.imageView);
    imagePreview.setImageResource(R.drawable.thumb1);

    buttonSetWallpaper.setOnClickListener(new Button.OnClickListener(){
        @Override
        public void onClick(View arg0) {
            WallpaperManager myWallpaperManager
                    = WallpaperManager.getInstance(getApplicationContext());
            try {
                myWallpaperManager.setResource(+R.drawable.thumb1);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }});*/