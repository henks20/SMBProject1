package com.example.smbproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ItemActivity extends AppCompatActivity {

    private String name;
    private int price, quantity;
    private  boolean checked;

    ItemActivity(String name, int price, int quantity, boolean checked) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.checked = checked;
    }

    public ItemActivity() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isChecked() {
        return  checked;
    }

}
