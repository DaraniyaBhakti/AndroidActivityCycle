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

public class listAdapter extends ArrayAdapter<ModelClass> {

    private int resource;
    private Context Con;

    public listAdapter(@NonNull Context context, int resource, List<ModelClass> object) {
        super(context, resource, object);
        this.resource = resource;
        this.Con = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.listview, null);
        }
        ModelClass text = getItem(position);


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
