package com.abhipatil.braintrainer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    TextView resultTextView;
    TextView pointsTextView;
    ArrayList<Integer> answers;
    int LocationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button PlayAgainButton;

    public void PlayAgain(View view){
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText( "30s" );
        pointsTextView.setText( "0/0" );
        resultTextView.setText( "" );
        PlayAgainButton.setVisibility( View.INVISIBLE );
        generateQuestion();

        new CountDownTimer( 30100, 1000 ) {
            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l / 1000) + "s ");
            }

            @Override
            public void onFinish() {
                PlayAgainButton.setVisibility(View.VISIBLE );
                timerTextView.setText( "0s" );
                resultTextView.setText( "your Score: " + Integer.toString( score ) + "/" + Integer.toString( numberOfQuestions  ));

            }
        }.start();

    }

    public void generateQuestion(){
        Random rand = new Random(  );
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        sumTextView.setText( Integer.toString( a ) + "+" + Integer.toString( b ) );
        LocationOfCorrectAnswer = rand.nextInt(4);
        answers.clear();
        int inCorrectAnswer;

        for(int i=0;i<4;i++){

            if(i == LocationOfCorrectAnswer){

                answers.add(a + b);
            }
            else
            {
                inCorrectAnswer = rand.nextInt(41);
                while(inCorrectAnswer == a + b){
                    inCorrectAnswer = rand.nextInt(41);
                }
                answers.add(inCorrectAnswer);
            }
        }
        button0.setText( Integer.toString( answers.get(0) ) );
        button1.setText( Integer.toString( answers.get(1) ) );
        button2.setText( Integer.toString( answers.get(2) ) );
        button3.setText( Integer.toString( answers.get(3) ) );
    }

    public void chooseAnswer(View view){

        if(view.getTag().toString().equals( Integer.toString( LocationOfCorrectAnswer ) )){
            score++;
            resultTextView.setText( "correct" );
        }
        else{
            resultTextView.setText( "wrong" );
        }
        numberOfQuestions++;
        pointsTextView.setText(Integer.toString( score ) + "/" + Integer.toString( numberOfQuestions ));
        generateQuestion();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
       // startButton = (Button)findViewById( R.id.button );
        answers = new ArrayList<Integer>(  );
         button0 = (Button)findViewById( R.id.button8 );
         button1 = (Button)findViewById( R.id.button9 );
         button2 = (Button)findViewById( R.id.button10 );
         button3 = (Button)findViewById( R.id.button11 );
        sumTextView = (TextView)findViewById( R.id.SumtextView );
        resultTextView = (TextView)findViewById( R.id.textView6 );
        pointsTextView = (TextView)findViewById( R.id.PointstextView );
        timerTextView = (TextView)findViewById( R.id.timerTextView );
        PlayAgainButton = (Button)findViewById( R.id.PlayAgain );
        PlayAgain( findViewById( R.id.PlayAgain ) );


        /*Random rand = new Random(  );
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        sumTextView.setText( Integer.toString( a ) + "+" + Integer.toString( b ) );
        LocationOfCorrectAnswer = rand.nextInt(4);
        int inCorrectAnswer;

        for(int i=0;i<4;i++){

            if(i == LocationOfCorrectAnswer){

                answers.add(a + b);
            }                                       // THIS CODE WAS INITIALLY WRITTEN HERE IN THE Oncreate method for testing
            else
            {
                inCorrectAnswer = rand.nextInt(41);
                while(inCorrectAnswer == a + b){
                    inCorrectAnswer = rand.nextInt(41);
                }
                answers.add(inCorrectAnswer);
            }
        }
        button0.setText( Integer.toString( answers.get(0) ) );
        button1.setText( Integer.toString( answers.get(1) ) );
        button2.setText( Integer.toString( answers.get(2) ) );
        button3.setText( Integer.toString( answers.get(3) ) );*/

}
}
