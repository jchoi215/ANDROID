package jrim.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    public static WindowInfo window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        window = new WindowInfo(this);

        GridView grid = (GridView) findViewById(R.id.grid);
        grid.setColumnWidth(window.getWidth()/3);

        final CustomGrid gridAdaptor = new CustomGrid(this);
        grid.setAdapter(gridAdaptor);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                viewImage(gridAdaptor.getURL(position));
            }
        });

    }

    public void viewImage(String URL){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
        startActivity(browserIntent);
    }
 }
