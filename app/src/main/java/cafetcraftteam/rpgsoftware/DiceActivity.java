package cafetcraftteam.rpgsoftware;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class DiceActivity extends AppCompatActivity {

    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        mTextViewResult = (TextView)findViewById(R.id.textView_Result);
        Button buttonThrow = (Button)findViewById(R.id.button_throw);
        final NumberPicker numberPicker = (NumberPicker)findViewById(R.id.numberPicker_Range);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(100);
        buttonThrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dice d = new Dice(numberPicker.getValue());
                int result = d.diceGenerator();

                mTextViewResult.setText("Result : " + result);
            }
        });
    }
}
