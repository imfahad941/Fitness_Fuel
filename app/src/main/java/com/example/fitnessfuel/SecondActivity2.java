package com.example.fitnessfuel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SecondActivity2 extends AppCompatActivity {

    int[] newArray;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        newArray=new int[]{
                R.id.mountain_climber,R.id.basic_crunches,R.id.bench_dips,R.id.bicycle_crunches,
                R.id.leg_raise,R.id.alternative_heel_touch,R.id.leg_up_crunches,R.id.sit_ups,
                R.id.alternative_v_ups,R.id.plank_rotation,R.id.plank_with_leg_left,R.id.russian_twist,
                R.id.bridge,R.id.vertica_leg_crunches
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.privacy)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fitnessplusgym.co.uk/privacy-policy"));
            startActivity(intent);
            return true;
        }
        if(id == R.id.terms)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://gymplanapp.com/terms/"));
            startActivity(intent);

            return true;
        }
        if(id == R.id.rate)
        {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=" + getPackageName())));
            }
            catch(Exception  e)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
            }

            return true;
        }
        if(id == R.id.more)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/developer?id=Leap+Fitness+Group&hl=en-IN"));
            startActivity(intent);


            return true;
        }
        if(id == R.id.share)
        {

            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody = "This is the Application for Fitness\n Get Yourself Geared Up!! \n Download Now\n" + "https://play.google.com/store/apps/details?id=com.example.fitnessfuel&hl=en";
            String sharehub = "Fitness Fuel";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            myIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myIntent,"share using"));
            return true;
        }

        return true;
    }



    public void Imagebuttonclicked(View view)
    {

        for(int i=0;i<newArray.length;i++)
        {
            if(view.getId()==newArray[i])
            {
                int value=i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent=new Intent(SecondActivity2.this,ThirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }
    }
}