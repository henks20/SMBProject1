package com.example.smbproject1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends Activity {

    private RecyclerView recyclerView;
    private Intent intent;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        myDb = new DatabaseHelper(this);
        intent = new Intent(this, EditActivity.class);
        recyclerView = (RecyclerView) findViewById(R.id.itemsList);

        LinearLayoutManager rlm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rlm);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getItems(), this);
        recyclerView.setAdapter(adapter);

    }

    private List<ItemActivity> getItems() {
        List<ItemActivity> il = new ArrayList<ItemActivity>();
        il = myDb.getAllItems();
//        List<ItemActivity> il = new ArrayList<ItemActivity>();

        System.out.println("ile? :" + il.size());
        return il;
    }

    public void dodajClick(View view) {
        startActivity(intent);
    }
}



