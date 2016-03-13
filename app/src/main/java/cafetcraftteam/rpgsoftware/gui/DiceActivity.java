package cafetcraftteam.rpgsoftware.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import cafetcraftteam.rpgsoftware.Dice;
import cafetcraftteam.rpgsoftware.R;

public class DiceActivity extends AppCompatActivity {

    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        mTextViewResult = (TextView)findViewById(R.id.textView_Result);
        Button buttonThrow = (Button)findViewById(R.id.button_throw);
        final NumberPicker numberPickerMin = (NumberPicker)findViewById(R.id.numberPickerMin);
        final NumberPicker numberPickerMax = (NumberPicker)findViewById(R.id.numberPickerMax);
        numberPickerMin.setMinValue(1);
        numberPickerMin.setMaxValue(100);
        numberPickerMax.setMinValue(1);
        numberPickerMax.setMaxValue(100);
        numberPickerMax.setValue(6);

        buttonThrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dice d = new Dice(numberPickerMin.getValue(),numberPickerMax.getValue());
                int result = d.diceGenerator();
                mTextViewResult.setText("Result : " + result);
            }
        });
    }
}
