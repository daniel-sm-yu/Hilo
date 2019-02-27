package com.dsyu.hilo;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private TextView questionTextView;
    private ImageView firstDiceImageView;
    private ImageView secondDiceImageView;
    private TextView totalTextView;
    private Button highButton;
    private Button lowButton;
    private Dice dice = new Dice();
    private TotalValue totalValue = new TotalValue();
    private  Score score = new Score();

    private void rollAndDisplay() {
        // Rolls first dice, sets the first dice image and adds value to total
        dice.rollDice();
        Drawable diceImage = ContextCompat.getDrawable(MainActivity.this, dice.getDiceImage());
        firstDiceImageView.setImageDrawable(diceImage);
        totalValue.addToTotalValue(dice.getDiceValue());

        // Rolls second dice, sets the second dice image and adds value to total
        dice.rollDice();
        diceImage = ContextCompat.getDrawable(MainActivity.this, dice.getDiceImage());
        secondDiceImageView.setImageDrawable(diceImage);
        totalValue.addToTotalValue(dice.getDiceValue());

        // Updates total value displayed on screen
        totalTextView.setText(totalValue.getTotalValue());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.scoreTextView);
        questionTextView = findViewById(R.id.questionTextView);
        firstDiceImageView = findViewById(R.id.firstDiceImageView);
        secondDiceImageView = findViewById(R.id.secondDiceImageView);
        totalTextView = findViewById(R.id.totalTextView);
        highButton = findViewById(R.id.highButton);
        lowButton = findViewById(R.id.lowButton);

        rollAndDisplay();

        highButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                questionTextView.setText("Will the next roll be higher or lower?");

                // Saves the previous for comparison before clearing it
                int previousValue = Integer.parseInt(totalValue.getTotalValue());
                totalValue.resetTotalValue();

                rollAndDisplay();

                // Updates score and displays on screen
                if (Integer.valueOf(totalValue.getTotalValue()) >= previousValue) {
                    score.addToScore();
                }
                else {
                    score.resetScore();
                    questionTextView.setText("Game Over, Try Again!");
                }
                scoreTextView.setText(score.getScore());
            }
        });

        lowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                questionTextView.setText("Will the next roll be higher or lower?");

                // Saves the previous for comparison before clearing it
                int previousValue = Integer.parseInt(totalValue.getTotalValue());
                totalValue.resetTotalValue();

                rollAndDisplay();

                // Updates score and displays on screen
                if (Integer.valueOf(totalValue.getTotalValue()) <= previousValue) {
                    score.addToScore();
                }
                else {
                    score.resetScore();
                    questionTextView.setText("Game Over, Try Again!");
                }
                scoreTextView.setText(score.getScore());
            }
        });
    }
}
