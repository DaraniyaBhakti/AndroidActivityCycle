package com.example.tatvasoftassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    ArrayList<LifeCycleClass> list = new ArrayList<>();
    private Button btnSend,btnGrid;
    private final String time = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mListView =(ListView) findViewById(R.id.listView);
            btnSend =(Button)findViewById(R.id.btnSend);
            btnGrid=(Button)findViewById(R.id.btnGrid);


        setItem("onCreate",getCurrentTime(),"Activity first Created.");

            btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String sendString = new String();
                    for(LifeCycleClass i : list)
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

            setItem("onStart",getCurrentTime(),"Activity start becoming visible to user.");
        }

        @Override
        protected void onRestart() {
            super.onRestart();

            setItem("onRestart",getCurrentTime(),"User resumes the activity which was stopped.");
        }

        @Override
        protected void onResume() {
            super.onResume();

            setItem("OnResume",getCurrentTime(),"Activity is visible and user can interact with it.");
        }

        @Override
        protected void onPause() {
            super.onPause();

            setItem("OnPause",getCurrentTime(),"Activity not visible, it is in background.");

        }

        @Override
        protected void onStop() {
            super.onStop();

            setItem("OnStop",getCurrentTime(),"Activity not visible, some other activity takes place of it.");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();

            setItem("onDestroy",getCurrentTime(),"Activity is not in background.");
        }

        public void setItem(String state,String time,String description)
        {

            list.add(new LifeCycleClass(state,time,description));
            android.widget.ListAdapter adapter = new ListAdapter(this,R.layout.listview, list);
            mListView.setAdapter(adapter);
        }
        public String getCurrentTime()
        {
            Calendar cal = Calendar.getInstance();
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm:ss");
            return date.format(currentLocalTime);
        }
    }
