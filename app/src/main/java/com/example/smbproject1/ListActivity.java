package com.example.smbproject1;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends Activity {

    private RecyclerView recyclerView;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        myDb = new DatabaseHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.itemsList);

        LinearLayoutManager rlm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rlm);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getItems(), this);
        recyclerView.setAdapter(adapter);

    }

    private List<ItemActivity> getItems() {
        List<ItemActivity> il = new ArrayList<ItemActivity>();
        return il;
    }
}



