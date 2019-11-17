package com.example.smbproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Intent listIntent, optionsIntent;
    private String fontColour;
    private Integer fontSize, color;
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
        sp = getPreferences(Context.MODE_PRIVATE);
        fontSize = sp.getInt("fontSize", 10);
        fontColour = sp.getString("fontColour", "Black");
        color = convertColor(fontColour);
        Button btnList = findViewById(R.id.listButton);
        btnList.setTextColor(color);
        Button btnOptions = findViewById(R.id.optionsButton);
        btnOptions.setTextSize(fontSize);

    }

    public Integer convertColor (String color) {
        if(color.equals("Black")) return Color.BLACK;
        else if(color.equals("Red")) return Color.RED;
        else if(color.equals("Yellow")) return Color.YELLOW;
        return null; // musialem dac null bo krzyczal errorem
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
