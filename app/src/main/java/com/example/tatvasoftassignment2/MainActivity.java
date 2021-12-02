package com.example.tatvasoftassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    ArrayList<ModelClass> list = new ArrayList<>();
    Button btnSend,btnGrid;
    String time = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mListView =(ListView) findViewById(R.id.listView);
            btnSend =(Button)findViewById(R.id.btnSend);
            btnGrid=(Button)findViewById(R.id.btnGrid);


        time = getCurrentTime();
        setItem("onCreate",time,"Activity first Created.");

            btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String sendString = new String();
                    for(ModelClass i : list)
                    {
                        sendString += "[ "+i.getEvent()+" invoke at "+i.getTime()+".]";

                    }

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT,sendString);
                    intent.setType("text/plain");
                    startActivity(intent);
                }
            });

            btnGrid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getApplicationContext(),GridViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("callback",list);
                    intent.putExtra("data",bundle);
                    startActivity(intent);
                }
            });

        }
        @Override
        protected void onStart() {
            super.onStart();

            time = getCurrentTime();
            setItem("onStart",time,"Activity start becoming visible to user.");
        }

        @Override
        protected void onRestart() {
            super.onRestart();

            time = getCurrentTime();
            setItem("onRestart",time,"User resumes the activity which was stopped.");
        }

        @Override
        protected void onResume() {
            super.onResume();

            time = getCurrentTime();
            setItem("OnResume",time,"Activity is visible and user can interact with it.");
        }

        @Override
        protected void onPause() {
            super.onPause();

            time = getCurrentTime();
            setItem("OnPause",time,"Activity not visible, it is in background.");

        }

        @Override
        protected void onStop() {
            super.onStop();

            time = getCurrentTime();
            setItem("OnStop",time,"Activity not visible, some other activity takes place of it.");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();

            time = getCurrentTime();
            setItem("onDestroy",time,"Activity is not in background.");
        }

        public void setItem(String state,String time,String description)
        {

            list.add(new ModelClass(state,time,description));
            ListAdapter adapter = new listAdapter(this,R.layout.listview, list);
            mListView.setAdapter(adapter);
        }
        public String getCurrentTime()
        {
            Calendar cal = Calendar.getInstance();
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm:ss");
            String currentTime = date.format(currentLocalTime);
            return currentTime;
        }
    }
