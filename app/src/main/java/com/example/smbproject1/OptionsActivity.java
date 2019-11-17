package com.example.smbproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

    private RadioGroup rb_group;
    private RadioButton rb_button;
    private EditText sizeValue;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private Integer fontSize, fontColourIndex;
    private String fontColour;
    private EditText et;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        sp = getSharedPreferences("project", Context.MODE_PRIVATE);
        intent = new Intent(this, MainActivity.class);
        editor = sp.edit();
        addListenerOnForm();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fontSize = sp.getInt("fontSize", 15);
        fontColour = sp.getString("fontColour", "Czarny");
        et = findViewById(R.id.editText);
        et.setText(String.valueOf(fontSize));
        RadioGroup rg = (RadioGroup) findViewById(R.id.colourRadioGroup);
        fontColourIndex = convertColor(fontColour);
        ((RadioButton)rg.getChildAt(fontColourIndex)).setChecked(true);
    }

    public Integer convertColor (String color) {
        if(color.equals("Czarny")) return 0;
        else if(color.equals("Czerwony")) return 1;
        else if(color.equals("Zolty")) return 2;
        return -1; // musialem dac null bo krzyczal errorem
    }

    public void addListenerOnForm() {
        rb_group = findViewById(R.id.colourRadioGroup);
        sizeValue = findViewById(R.id.editText);
        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                int value = Integer.parseInt(sizeValue.getText().toString());
                editor.putInt("fontSize", value);
                int selectedColourId = rb_group.getCheckedRadioButtonId();
                rb_button = findViewById(selectedColourId);
                editor.putString("fontColour", rb_button.getText().toString());
                editor.apply();
                Toast.makeText(OptionsActivity.this, "Data updated", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }

}
