package com.example.tatvasoftassignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class gridAdapter extends ArrayAdapter<ModelClass> {

    List<ModelClass> listofcyclecallback = new ArrayList<ModelClass>();
    int Resource;

    public gridAdapter(@NonNull Context context, int resource, List<ModelClass> obj) {
        super(context, resource, obj);
        listofcyclecallback = obj;
        Resource = resource;
    }

    @Override
    public int getCount() {
        return listofcyclecallback.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.gridview, null);
        }

        TextView tvStateGrid = v.findViewById(R.id.tvStateGrid);
        TextView tvTimeStampGrid = v.findViewById(R.id.tvTimeStampGrid);

        ModelClass item = listofcyclecallback.get(position);

        tvStateGrid.setText(item.getEvent());
        tvTimeStampGrid.setText(item.getTime());
        return v;
    }

}
