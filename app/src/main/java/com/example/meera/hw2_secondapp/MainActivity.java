package com.example.meera.hw2_secondapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ArrayList<String> userList;
    private ArrayAdapter<String> adapter;
    private String wordToAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // connect the ListView to an ArrayList of to do items
        ListView todoList = (ListView) findViewById(R.id.todo_list);

        todoList.setOnItemClickListener(this);
        userList = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                userList
        );
        todoList.setAdapter(adapter);

    }
    public void addActivity(View view){
            EditText the_word = (EditText) findViewById(R.id.the_word);
            wordToAdd = the_word.getText().toString();
            userList.add(wordToAdd);
            if (userList == null) {
                userList = new ArrayList<String>();
            }
           adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
        ListView todoList = (ListView) findViewById(R.id.todo_list);
        String text = todoList.getItemAtPosition(index).toString();
        userList.remove(index);
        adapter.notifyDataSetChanged();
        String removed = "Activity removed.";
        Toast.makeText(this, removed, Toast.LENGTH_SHORT).show();
    }


}
