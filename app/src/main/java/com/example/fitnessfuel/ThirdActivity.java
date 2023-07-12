package com.example.fitnessfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftinmills;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent=getIntent();
        buttonvalue=intent.getStringExtra("value");


        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue){

            case 1:
                setContentView(R.layout.mountain_climber);
                break;

            case 2:
                setContentView(R.layout.basic_crunches);
                break;

            case 3:
                setContentView(R.layout.bench_dips);
                break;
            case 4:
                setContentView(R.layout.bicycle_crunches);
                break;

            case 5:
                setContentView(R.layout.leg_raise);
                break;

            case 6:
                setContentView(R.layout.alternative_heel_touch);
                break;

            case 7:
                setContentView(R.layout.leg_up_crunches);
                break;

            case 8:
                setContentView(R.layout.sit_ups);
                break;

            case 9:
                setContentView(R.layout.alternative_v_ups);
                break;

            case 10:
                setContentView(R.layout.plank_rotation);
                break;

            case 11:
                setContentView(R.layout.plank_with_leg_left);
                break;

            case 12:
                setContentView(R.layout.russian_twist);
                break;

            case 13:
                setContentView(R.layout.bridge);
                break;

            case 14:
                setContentView(R.layout.vertica_leg_crunches);
                break;



        }


        startBtn=findViewById(R.id.startbutton);
        mtextview=findViewById(R.id.time);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MTimeRunning)
                {
                        stoptimer();
                }

                else
                {
                        startTimer();
                }
            }
        });


    }


    private void stoptimer()
    {
        countDownTimer.cancel();
        MTimeRunning=false;
        startBtn.setText("START");
    }


    private void startTimer()
    {
        final CharSequence value1 = mtextview.getText();
        String num1 = value1.toString();
        String num2 =num1.substring(0,2);
        String num3 = num1.substring(3,5);



        final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);
        /*calculates the total number of seconds based on num2 (representing minutes)
         and num3 (representing seconds). It multiplies num2 by 60 to convert minutes to seconds
          and then adds num3 to get the total number of seconds.
          The result is stored in an integer variable named number.  */
        MTimeLeftinmills = number*1000;// converting the total number of seconds into milliseconds.


        /*The first argument specifies the total time in milliseconds for the countdown,
        and the second argument specifies the interval in milliseconds between each tick.  */

        countDownTimer = new CountDownTimer(MTimeLeftinmills,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                MTimeLeftinmills = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                    int newvalue =  Integer.valueOf(buttonvalue) + 1;
                    if(newvalue<=7)
                    {
                        Intent intent =new Intent(ThirdActivity.this,ThirdActivity.class);
                       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra("value",String.valueOf(newvalue));

                        startActivity(intent);
                    }

                    else
                    {

                        newvalue = 1;
                        Intent intent =new Intent(ThirdActivity.this,ThirdActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra("value",String.valueOf(newvalue));
                        startActivity(intent);
                    }
            }
        }.start();

        startBtn.setText("PAUSE");

        MTimeRunning=true;
    }



    private void updateTimer()
    {
        int minutes = (int) MTimeLeftinmills / 60000;
        int seconds = (int) MTimeLeftinmills % 60000 / 1000;



        String timeLeftText="";
        if(minutes < 10)
            timeLeftText="0";
        timeLeftText = timeLeftText + minutes + ":";

        if(seconds < 10)
            timeLeftText +="0";
        timeLeftText += seconds;

        mtextview.setText(timeLeftText);
    }

    /**
     * Called when the activity has detected the user's press of the back
     * key. The {@link #getOnBackPressedDispatcher() OnBackPressedDispatcher} will be given a
     * chance to handle the back button before the default behavior of
     * {@link Activity#onBackPressed()} is invoked.
     *
     * @see #getOnBackPressedDispatcher()
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}