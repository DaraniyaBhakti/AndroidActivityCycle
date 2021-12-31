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

public class GridAdapter extends ArrayAdapter<LifeCycleClass> {

    List<LifeCycleClass> lifeCycleCallback = new ArrayList<LifeCycleClass>();
    int Resource;

    public GridAdapter(@NonNull Context context, int resource, List<LifeCycleClass> obj) {
        super(context, resource, obj);
        lifeCycleCallback = obj;
        Resource = resource;
    }

    @Override
    public int getCount() {
        return lifeCycleCallback.size();
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

        LifeCycleClass item = lifeCycleCallback.get(position);

        tvStateGrid.setText(item.getEvent());
        tvTimeStampGrid.setText(item.getTime());
        return v;
    }

}
