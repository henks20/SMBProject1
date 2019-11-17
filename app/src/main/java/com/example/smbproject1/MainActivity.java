package com.example.smbproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Intent listIntent, optionsIntent;
    private String fontColour;
    private Integer fontSize;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private Button btnList, btnOptions;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listIntent = new Intent(this, ListActivity.class);
        optionsIntent = new Intent(this, OptionsActivity.class);
        myDb = new DatabaseHelper(this);
        sp = getSharedPreferences("project", Context.MODE_PRIVATE);
        fontSize = sp.getInt("fontSize", 15);
        fontColour = sp.getString("fontColour", "Czarny");
        int color = convertColor(fontColour);
        Button btnList = findViewById(R.id.listButton);
        btnList.setTextColor(color);
        btnOptions = findViewById(R.id.optionsButton);
        btnOptions.setTextSize(fontSize);

        List<ItemActivity> list = myDb.getAllItems();

        System.out.println("ile? :" + list.size());

    }

    public int convertColor (String color) {
        if(color.equals("Czarny")) return Color.BLACK;
        else if(color.equals("Czerwony")) return Color.RED;
        else if(color.equals("Zolty")) return Color.YELLOW;
        return -1; // musialem dac null bo krzyczal errorem
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void clickListButton(View view) {
        startActivity(listIntent);
    }

    public void clickOptionsButton(View view) {
        startActivity(optionsIntent);
    }






}
