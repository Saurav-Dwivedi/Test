package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    Button b1;
    EditText e1;

    String quotes = "";
    LiveData<String> name1;
    MutableLiveData<String> name = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // name1 = name;


        t1 = (TextView) findViewById(R.id.tv_text);
        e1 = (EditText) findViewById(R.id.et_text);
        b1 = (Button) findViewById(R.id.bt_button1);


        t1.setText(name.getValue());


        name.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                t1.setText(s);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quotes = e1.getText().toString();
                name.setValue(quotes);
                // t1.setText(quotes);
            }
        });

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("MyString", quotes);
        // etc.
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        // t1.setText(savedInstanceState.getString("MyString"));

    }
}