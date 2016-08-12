package com.android.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the number picker
        final NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);
        // Set np's range
        np.setMinValue(1);
        np.setMaxValue(30);
        // Sets whether the selector wheel wraps when reaching the min/max value.
        np.setWrapSelectorWheel(true);

        // Get the result textViews
        final TextView tvOne = (TextView) findViewById(R.id.tvOne);
        final TextView tvTwo = (TextView) findViewById(R.id.tvTwo);
        final TextView tvThree = (TextView) findViewById(R.id.tvThree);
        final TextView tvFour = (TextView) findViewById(R.id.tvFour);
        final TextView tvFive = (TextView) findViewById(R.id.tvFive);
        final TextView tvSix = (TextView) findViewById(R.id.tvSix);


        // Get the Roll button
        final Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action on click
                // Show a Toast message
                Toast.makeText(MainActivity.this, "Rolling!!!", Toast.LENGTH_SHORT).show();
                // Get the value from np
                int numDice = np.getValue();
                // Make a list of Dices
                ArrayList<Dice> diceArrayList = new ArrayList<Dice>();
                for (int i = 0; i < numDice; i++) {
                    diceArrayList.add(new Dice());
                }
                // Get an array for checking the number of each dice value
                int[] stat = new int[6];
                for (int i = 0; i < numDice; i++) {
                    stat[diceArrayList.get(i).getValue()-1]++;
                }
                // Generating the result
                tvOne.setText(""+stat[0]);
                tvTwo.setText(""+stat[1]);
                tvThree.setText(""+stat[2]);
                tvFour.setText(""+stat[3]);
                tvFive.setText(""+stat[4]);
                tvSix.setText(""+stat[5]);
            }
        });
    }
}
