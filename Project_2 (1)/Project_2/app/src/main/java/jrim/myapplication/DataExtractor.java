package jrim.myapplication;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by user on 10/5/2017.
 */

public class DataExtractor {

    private String[] car_info;

    public DataExtractor(){
        String data = "";
        StringBuffer buffer = new StringBuffer();
        InputStream in = MainActivity.window.getContext().getResources().openRawResource(R.raw.inventory);

        BufferedReader reader = new BufferedReader( new InputStreamReader(in));

        if(in != null){
            try{
                while ((data = reader.readLine()) != null){
                    buffer.append(data + "\n");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        car_info = buffer.toString().split("\n");
    }

    public String[] extract(){
        return car_info;
    }
}
