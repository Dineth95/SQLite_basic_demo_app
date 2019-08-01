package com.example.sqlite_basic_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    DatabaseHelper databasehelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        editText=(EditText)findViewById(R.id.editTaskText);
        databasehelper=new DatabaseHelper(this,null,null,1);
        printdb();
    }

    public void addButtonClicked(View view){
        Tasks tasks=new Tasks(editText.getText().toString());

        databasehelper.addTask(tasks);
        printdb();
    }

    public void removeButtonClicked(View view){
        String removetask=editText.getText().toString();
        databasehelper.removeTask(removetask);
        printdb();
    }

    public void printdb(){
        String dbstring=databasehelper.databasetostring();
        textView.setText(dbstring);
    }
}
