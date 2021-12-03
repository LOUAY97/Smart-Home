package com.example.projetfin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ControlActivity extends AppCompatActivity {
    DatabaseReference myRef;
    Button onButtonLamp1;
    Button offButtonLamp1;
    Button onButtonLamp2;
    Button offButtonLamp2;
    Button onButtonLamp3;
    Button offButtonLamp3;
    Button onButtonLamp4;
    Button offButtonLamp4;
    Button openHomeDoor;
    Button closeHomeDoor;
    Button openGarageDoor;
    Button closeGarageDoor;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        onButtonLamp1 = findViewById(R.id.lamp1_on_button);
        offButtonLamp1 = findViewById(R.id.lamp1_off_button);
        onButtonLamp2= findViewById(R.id.lamp2_on_button);
        offButtonLamp2 = findViewById(R.id.lamp2_off_button);
        onButtonLamp3 = findViewById(R.id.lamp3_on_button);
        offButtonLamp3 = findViewById(R.id.lamp3_off_button);
        onButtonLamp4 = findViewById(R.id.lamp4_on_button);
        offButtonLamp4 = findViewById(R.id.lamp4_off_button);
        openHomeDoor = findViewById(R.id.home_door_open);
        closeHomeDoor = findViewById(R.id.home_door_close);
        openGarageDoor = findViewById(R.id.garage_door_open);
        closeGarageDoor = findViewById(R.id.garage_door_close);

        onButtonLamp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("leds");
                myRef.child("led1status").setValue("on");
                Toast.makeText(ControlActivity.this,"Light 1 is opened",Toast.LENGTH_SHORT).show();
            }
        });
        offButtonLamp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("leds");
                myRef.child("led1status").setValue("off");
                Toast.makeText(ControlActivity.this,"Light 1 is closed",Toast.LENGTH_SHORT).show();


            }
        });
        onButtonLamp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("leds");
                myRef.child("led2status").setValue("on");
                Toast.makeText(ControlActivity.this,"Light 2 is opened",Toast.LENGTH_SHORT).show();

            }
        });
        offButtonLamp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("leds");
                myRef.child("led2status").setValue("off");
                Toast.makeText(ControlActivity.this,"Light 2 is closed",Toast.LENGTH_SHORT).show();


            }
        });
        onButtonLamp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("leds");
                myRef.child("led3status").setValue("on");
                Toast.makeText(ControlActivity.this,"Light 3 is opened",Toast.LENGTH_SHORT).show();

            }
        });
        offButtonLamp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("leds");
                myRef.child("led3status").setValue("off");
                Toast.makeText(ControlActivity.this,"Light 3 is closed",Toast.LENGTH_SHORT).show();


            }
        });
        onButtonLamp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("leds");
                myRef.child("led4status").setValue("on");
                Toast.makeText(ControlActivity.this,"Light 4 is opened",Toast.LENGTH_SHORT).show();

            }
        });
        offButtonLamp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("leds");
                myRef.child("led4status").setValue("off");
                Toast.makeText(ControlActivity.this,"Light 4 is closed",Toast.LENGTH_SHORT).show();


            }
        });
        openGarageDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("doors");
                myRef.child("garagedoor").setValue("open");
                Toast.makeText(ControlActivity.this,"Garage Door is opened",Toast.LENGTH_SHORT).show();

            }
        });
        closeGarageDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("doors");
                myRef.child("garagedoor").setValue("close");
                Toast.makeText(ControlActivity.this,"Garage Door is closed",Toast.LENGTH_SHORT).show();


            }
        });
        openHomeDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("doors");
                myRef.child("door1").setValue("open");
                Toast.makeText(ControlActivity.this,"Home Door is opened",Toast.LENGTH_SHORT).show();

            }
        });
        closeHomeDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference("doors");
                myRef.child("door1").setValue("close");
                Toast.makeText(ControlActivity.this,"Home Door is closed",Toast.LENGTH_SHORT).show();


            }
        });


    }
}