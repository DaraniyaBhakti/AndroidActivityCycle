package com.example.tatvasoftassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        Intent intent = getIntent();
        Bundle Bundle = intent.getBundleExtra("data");
        ArrayList<ModelClass> callback;
        callback = (ArrayList<ModelClass>) Bundle.getSerializable("callback");


        GridView grid = findViewById(R.id.gridView);
        ListAdapter adapter = new gridAdapter(this, R.layout.gridview,callback);
        grid.setAdapter(adapter);
    }
}