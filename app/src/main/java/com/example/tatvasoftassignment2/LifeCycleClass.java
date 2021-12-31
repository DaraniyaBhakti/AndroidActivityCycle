package com.example.tatvasoftassignment2;


import android.os.Parcel;

import java.io.Serializable;

public class LifeCycleClass implements Serializable {
        private String Callback;
        private String Timestamp;
        private String Description;


        public String getEvent() {
            return Callback;
        }

        public void setEvent(String callback) {
            Callback = callback;
        }
        public String getTime() {
            return Timestamp;
        }
        public void setTime(String time) {
            Timestamp = time;
        }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LifeCycleClass() {
        }

    public LifeCycleClass(String callback, String timestamp, String description) {
        Callback = callback;
        Timestamp = timestamp;
        Description = description;
    }
}
