package com.example.smbproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionsActivity extends AppCompatActivity {

    private RadioGroup rb_group;
    private RadioButton rb_button;
    private EditText sizeValue;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private Integer fontSize;
    private String fontColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        sp = getPreferences(Context.MODE_PRIVATE);
        editor = sp.edit();
        addListenerOnForm();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fontSize = sp.getInt("fontSize", 10);
        fontColour = sp.getString("fontColour", "black");

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
            }
        });
    }
}
