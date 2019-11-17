package com.example.smbproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editPrice, editQuantity;
    CheckBox editBought;
    Button btnConfirm, btnEdit, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.itemInputName);
        editPrice = (EditText) findViewById(R.id.itemInputPrice);
        editQuantity = (EditText) findViewById(R.id.itemInputQuantity);
        editBought = (CheckBox) findViewById(R.id.itemCheckboxBought);
        btnConfirm = (Button) findViewById(R.id.itemConfirmButton);
        btnEdit = (Button) findViewById(R.id.itemEditButton);
        btnDelete = (Button) findViewById(R.id.itemDeleteButton);
        AddData();
        UpdateData();
        DeleteData();
    }

    private List<ItemActivity> getItems() {
        List<ItemActivity> il = new ArrayList<ItemActivity>();
        il = myDb.getAllItems();

        return il;
    }

    public void AddData() {
        btnConfirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int value;
                        if(editBought.isChecked()){
                            value = 1;
                        } else value = 0;
                        System.out.println("DANE:" + editName.getText().toString() + Integer.parseInt(editPrice.getText().toString()) +
                                Integer.parseInt(editQuantity.getText().toString()) +
                                value );

                         myDb.insertData(editName.getText().toString(),
                                Integer.parseInt(editPrice.getText().toString()),
                                Integer.parseInt(editQuantity.getText().toString()),
                                value);
//                        if(isInserted == true) {
                            Toast.makeText(EditActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
//                            startActivity(seeListItems);
                            getItems();
//                        }
//                        else
//                            Toast.makeText(EditActivity.this, "Data NOT inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void UpdateData() {
        btnEdit.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        int value;
                        if(editBought.isChecked()){
                            value = 1;
                        } else value = 0;
                        boolean isUpdated = myDb.updateData("1", editName.getText().toString(),
                                Integer.parseInt(editPrice.getText().toString()),
                                Integer.parseInt(editQuantity.getText().toString()),
                                value);
                        if(isUpdated == true) {
                            Toast.makeText(EditActivity.this, "Data updated", Toast.LENGTH_LONG).show();
//                            startActivity(seeListItems);
                        }
                        else
                            Toast.makeText(EditActivity.this, "Data NOT updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = myDb.deleteData(editName.getText().toString());
                        if(deletedRows > 0) {
                            Toast.makeText(EditActivity.this, "Data deleted", Toast.LENGTH_LONG).show();
//                            startActivity(seeListItems);
                    }
                        else
                                Toast.makeText(EditActivity.this, "Data NOT deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
