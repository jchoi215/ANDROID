package jrim.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.net.URL;

/**
 * Created by Xen-J on 10/6/2017.
 */

public class CustomGrid extends BaseAdapter{

    String[] cars;

    AppCompatActivity mApp;

    public CustomGrid(AppCompatActivity mApp){
        this.mApp = mApp;

        DataExtractor infoExtractor = new DataExtractor();
        cars = infoExtractor.extract();
    }

    @Override
    public int getCount() {
        return cars.length / 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View cView, ViewGroup parent){
        ImageView iView;

        if(cView == null){
            iView = new ImageView(mApp);
            iView.setLayoutParams(new GridView.LayoutParams(
                    MainActivity.window.getWidth() /3,
                    MainActivity.window.getHeight()/3));

            iView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            iView.setPadding(5, 5, 5, 5);
        }else{
            iView = (ImageView) cView;
        }

        new DownloadImageTask(iView).execute(cars[position * 5]);

        return iView;
    }



    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            Bitmap icon = null;

            try {
                URL url = new URL(urls[0]);
                icon = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (Exception e) {
                icon = BitmapFactory.decodeResource(MainActivity.window.getContext().getResources(), R.drawable.error);
            }
            return icon;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    public String getURL(int pos){
        return cars[pos * 5];
    }
}
