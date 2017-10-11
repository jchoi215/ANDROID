package jrim.testlearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class First extends AppCompatActivity {


    static final int PICK_CONTACT_REQUEST = 1;

    int count = 0;
    TextView text = null;
    Button LaunchNextIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        text = (TextView) findViewById(R.id.Message_1);
        LaunchNextIntent = (Button) findViewById(R.id.next_btn);

        LinkButton();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {



            }
        }
    }



    public void onResume(){
        super.onResume();

        if(count != 0){
            text.setText("ZERO");
            count = 1;
        }

    }


    void LinkButton(){

        LaunchNextIntent.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                if(count == 0){
                    text.setText("ZERO");
                }
                else if(count == 1){
                    text.setText("ONE");

                }
                else if(count == 2){

                    Intent intent = new Intent(First.this, Second.class);
                    startActivity(intent);

                    count = 0;
                }

                count++;
            }
        } );

    }
}
