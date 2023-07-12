package com.example.fitnessfuel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;
    Toolbar toolbar;

    ImageView arrow1,arrow2,arrow3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        toolbar=findViewById(R.id.toolBar);
         setSupportActionBar(toolbar);

        button1=findViewById(R.id.startyoga1);
        button2=findViewById(R.id.startyoga2);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity2.class);
                startActivity(intent);
            }
        });

        arrow1=findViewById(R.id.arrow1);

        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        arrow2=findViewById(R.id.arrow2);

        arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity2.class);
                startActivity(intent);
            }
        });


        arrow3=findViewById(R.id.arrow3);

       arrow3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,FoodActivity.class);
               startActivity(intent);

           }
       });


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

    public void beforeage18(View view)
    {
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    public void afterage18(View view)
    {
        Intent intent=new Intent(MainActivity.this,SecondActivity2.class);
        startActivity(intent);

    }

    public void food(View view)
    {
        Intent intent=new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);

    }



}


