package com.example.shijian_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Button button1 = (Button) findViewById( R.id.button_1 );

       button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "Hello SecondActivity";
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult( intent,1 );
                intent.putExtra( "extra_data",data ) ;
                startActivity(intent);
            }
        } );
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra( "data_return" );
                    TextView text1 = (TextView) findViewById( R.id.text1 );
                    text1.setText( returnedData );
                }
                break;
            default:
        }
    }
}
