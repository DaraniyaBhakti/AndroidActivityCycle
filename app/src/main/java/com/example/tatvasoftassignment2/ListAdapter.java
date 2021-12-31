package com.example.tatvasoftassignment2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<LifeCycleClass> {

    private int resource;
    private Context context;

    public ListAdapter(@NonNull Context context, int resource, List<LifeCycleClass> object) {
        super(context, resource, object);
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.listview, null);
        }
        LifeCycleClass text = getItem(position);


        if (text != null){
            TextView tvState = (TextView)view.findViewById(R.id.tvState);
            TextView tvTimeStamp = (TextView)view.findViewById(R.id.tvTimeStamp);
            TextView tvDescription = (TextView)view.findViewById(R.id.tvDescription);
            tvState.setText(text.getEvent());
            tvTimeStamp.setText(text.getTime());
            tvDescription.setText(text.getDescription());

        }
        return view;
    }
}
