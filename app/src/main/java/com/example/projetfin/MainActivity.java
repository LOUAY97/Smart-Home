package com.example.projetfin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView homeView ;
    TextView controlView ;
    TextView aboutView ;
    DatabaseReference tempRef,humidRef,moistRef;
    private static final String TAG = "MyActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeView = findViewById(R.id.home_view);
        controlView = findViewById(R.id.control_view);
        aboutView = findViewById(R.id.about_view);
        homeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Stay In Home Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        aboutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Open About Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
        controlView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Open Control Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ControlActivity.class);
                startActivity(intent);
            }
        });
        tempRef =  FirebaseDatabase.getInstance().getReference("Sensor").child("temperature");
        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                int value =  dataSnapshot.getValue(int.class);
                displayTemperature(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value

                Log.w(TAG, "Failed to read value.", error.toException());

            }
        });
        humidRef =  FirebaseDatabase.getInstance().getReference("Sensor").child("humidity");
        humidRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                int value =  dataSnapshot.getValue(int.class);
                displayHumidity(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value

                Log.w(TAG, "Failed to read value.", error.toException());

            }
        });
        moistRef =  FirebaseDatabase.getInstance().getReference("Sensor").child("moisture");
        moistRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                int  value =  dataSnapshot.getValue(int.class);
                if (value <= 1300){
                    displayMoistureStatus("WET");
                    displayWaterPumpStatus("CLOSED");
                }
                else if (value <= 2600){
                    displayMoistureStatus("SEMI-DRY");
                    displayWaterPumpStatus("CLOSED");


                }
                else{
                    displayMoistureStatus("DRY");
                    displayWaterPumpStatus("OPENED");
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value

                Log.w(TAG, "Failed to read value.", error.toException());

            }
        });




    }
    public void displayTemperature(int data){
        TextView temperatureValue = (TextView) findViewById(R.id.temperature_value);
        temperatureValue.setText(data + "°C");


    }
    public void displayHumidity(int data){
        TextView humidityValue = (TextView) findViewById(R.id.humidity_value);
        humidityValue.setText(data + "%");


    }
    public void displayMoistureStatus(String data){
        TextView temperatureValue = (TextView) findViewById(R.id.moisture_value);
        temperatureValue.setText(data);


    }
    public void displayWaterPumpStatus(String data){
        TextView temperatureValue = (TextView) findViewById(R.id.water_pump_value);
        temperatureValue.setText(data);


    }
}
