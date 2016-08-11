package com.android.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

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

        // Get the result textView
        final TextView textViewResult = (TextView) findViewById(R.id.textViewResult);

        // Get the Roll button
        final Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action on click
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
                // Generating the result string
                String result = "";
                for (int i = 1; i <= 6; i++) {
                    result += (i + ": " + stat[i-1] + "\n");
                }
                textViewResult.setText(result);
            }
        });
    }
}
