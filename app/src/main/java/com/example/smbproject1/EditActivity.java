package com.example.smbproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editPrice, editQuantity;
    CheckBox editBought;
    Button btnConfirm, btnEdit, btnDelete;
    private Intent seeListItems;

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
//        seeListItems = new Intent(this, ListActivity.class);
        AddData();
        UpdateData();
        DeleteData();
    }

    public void AddData() {
        btnConfirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                Integer.parseInt(editPrice.getText().toString()),
                                Integer.parseInt(editQuantity.getText().toString()),
                                Integer.parseInt(editQuantity.getText().toString()));
                        if(isInserted == true) {
                            Toast.makeText(EditActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
//                            startActivity(seeListItems);
                        }
                        else
                            Toast.makeText(EditActivity.this, "Data NOT inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void UpdateData() {
        btnEdit.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        boolean isUpdated = myDb.updateData("1", editName.getText().toString(),
                                Integer.parseInt(editPrice.getText().toString()),
                                Integer.parseInt(editQuantity.getText().toString()),
                                Integer.parseInt(editQuantity.getText().toString()));
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
                        Integer deletedRows = myDb.deleteData("1");
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
