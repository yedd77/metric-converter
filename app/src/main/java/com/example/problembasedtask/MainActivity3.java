package com.example.problembasedtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity3 extends AppCompatActivity {

    boolean isNewCalc = true;
    boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Spinner weightdropdown1 = (Spinner) findViewById(R.id.weightDrop1);
        Spinner weightdropdown2 = (Spinner) findViewById(R.id.weightDrop2);
        Button buttonZero = (Button) findViewById(R.id.buttonZero);
        Button buttonOne = (Button) findViewById(R.id.buttonOne);
        Button buttonTwo = (Button) findViewById(R.id.buttonTwo);
        Button buttonThree = (Button) findViewById(R.id.buttonThree);
        Button buttonFour = (Button) findViewById(R.id.buttonFour);
        Button buttonFive = (Button) findViewById(R.id.buttonFive);
        Button buttonSix = (Button) findViewById(R.id.buttonSix);
        Button buttonSeven = (Button) findViewById(R.id.buttonSeven);
        Button buttonEight = (Button) findViewById(R.id.buttonEight);
        Button buttonNine = (Button) findViewById(R.id.buttonNine);
        Button buttonClear = (Button) findViewById(R.id.Clear);
        Button buttonDot = (Button) findViewById(R.id.buttonDot);
        LinearLayout buttonDel = (LinearLayout) findViewById(R.id.deleteButton);
        LinearLayout backButton = (LinearLayout) findViewById(R.id.backbutton1);
        TextView weightVar = (TextView) findViewById(R.id.weightVar);
        TextView ConvWeightVar = (TextView) findViewById(R.id.convWeightVar);
        TextView convertFrom = (TextView) findViewById(R.id.convertToW);
        TextView convertTo = (TextView) findViewById(R.id.convertFromW);

        //back button function
        backButton.setOnClickListener(view -> {
            Intent mainPage = new Intent(getBaseContext(), MainActivity.class);
            startActivity(mainPage);
        });

        //create a new pattern for decimal places
        //https://developer.android.com/reference/java/text/DecimalFormat
        DecimalFormat df = new DecimalFormat("#.######");
        df.setRoundingMode(RoundingMode.CEILING);

        //This ArrayAdapter returning array list onto Spinner
        //https://developer.android.com/reference/android/widget/ArrayAdapter
        //Adapter for weightDropDown1
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.weightDropdown1,
                R.layout.dropdowncolor
        );
        adapter.setDropDownViewResource(R.layout.dropdowncolor_list);
        weightdropdown1.setAdapter(adapter);

        //AdapterView is used to handle user selection for spinner
        //https://developer.android.com/guide/topics/ui/binding
        weightdropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertFrom.setText(adapterView.getSelectedItem().toString());

                //get spinner item values
                String from = weightdropdown1.getSelectedItem().toString();
                String to = weightdropdown2.getSelectedItem().toString();

                //declare new double var to temporary store the calculated value
                double calculatedNo = Double.parseDouble(weightVar.getText().toString());

                //send value into converted textview
                ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //This ArrayAdapter returning array list onto Spinner
        //https://developer.android.com/reference/android/widget/ArrayAdapter
        //Adapter for WeightDropDown1
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.weightDropdown2,
                R.layout.dropdowncolor
        );
        adapter2.setDropDownViewResource(R.layout.dropdowncolor_list);
        weightdropdown2.setAdapter(adapter2);
        //AdapterView is used to handle user selection for spinner
        //https://developer.android.com/guide/topics/ui/binding
        weightdropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertTo.setText(adapterView.getSelectedItem().toString());

                //get spinner item values
                String from = weightdropdown1.getSelectedItem().toString();
                String to = weightdropdown2.getSelectedItem().toString();

                //declare new double var to temporary store the calculated value
                double calculatedNo = Double.parseDouble(weightVar.getText().toString());

                //send value into converted textview
                ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        buttonZero.setOnClickListener(view -> {
            //differentiate predefined string and value 0
            if (!isNewCalc) {
                weightVar.setText(String.format("%s0", weightVar.getText()));
            }
            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonOne.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || weightVar.getText().toString().equals("0")) {
                weightVar.setText("");
                isNewCalc = false;
            }
            weightVar.setText(String.format("%s1", weightVar.getText()));

            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());


            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonTwo.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || weightVar.getText().toString().equals("0")) {
                weightVar.setText("");
                isNewCalc = false;
            }
            weightVar.setText(String.format("%s2", weightVar.getText()));

            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonThree.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || weightVar.getText().toString().equals("0")) {
                weightVar.setText("");
                isNewCalc = false;
            }
            weightVar.setText(String.format("%s3", weightVar.getText()));

            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonFour.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || weightVar.getText().toString().equals("0")) {
                weightVar.setText("");
                isNewCalc = false;
            }
            weightVar.setText(String.format("%s4", weightVar.getText()));

            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonFive.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || weightVar.getText().toString().equals("0")) {
                weightVar.setText("");
                isNewCalc = false;
            }
            weightVar.setText(String.format("%s5", weightVar.getText()));

            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonSix.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || weightVar.getText().toString().equals("0")) {
                weightVar.setText("");
                isNewCalc = false;
            }
            weightVar.setText(String.format("%s6", weightVar.getText()));

            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonSeven.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || weightVar.getText().toString().equals("0")) {
                weightVar.setText("");
                isNewCalc = false;
            }
            weightVar.setText(String.format("%s7", weightVar.getText()));

            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonEight.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || weightVar.getText().toString().equals("0")) {
                weightVar.setText("");
                isNewCalc = false;
            }
            weightVar.setText(String.format("%s8", weightVar.getText()));

            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonNine.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || weightVar.getText().toString().equals("0")) {
                weightVar.setText("");
                isNewCalc = false;
            }
            weightVar.setText(String.format("%s9", weightVar.getText()));

            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonDot.setOnClickListener(view -> {
            if (!isClicked) {
                weightVar.setText(String.format("%s.", weightVar.getText()));
                isClicked = true;
                isNewCalc = false;
            }
            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

        buttonClear.setOnClickListener(view -> {
            //reset all item into default state
            weightVar.setText("0");
            ConvWeightVar.setText("0");
            isNewCalc = true;
            isClicked = false;
        });

        buttonDel.setOnClickListener(view -> {
            String text = weightVar.getText().toString();

            //making sure that the value not equal to null
            if (text.length() == 1) {
                text = "0";
            } else {
                text = text.substring(0, text.length() - 1);
            }

            //reset isClicked logic if deleted value contain "."
            isClicked = text.contains(".");
            weightVar.setText(text);

            //get spinner item values
            String from = weightdropdown1.getSelectedItem().toString();
            String to = weightdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(weightVar.getText().toString());

            //send value into converted textview
            ConvWeightVar.setText(df.format(calculateWValue(calculatedNo, from, to)));
        });

    }
    //function to convert value of the item
    public double calculateWValue(double value, String from, String to){

        if (from.equals("kilogram") && to.equals("pound")){
            value = value*2.20462262185;
        } else if (from.equals("kilogram") && to.equals("gram")){
            value = value*1000;
        } else if (from.equals("kilogram") && to.equals("ounce")){
            value = value*35.27396195;
        } else if (from.equals("pound") && to.equals("kilogram")){
            value = value/2.20462262185;
        } else if (from.equals("pound") && to.equals("gram")){
            value = value*453.59237;
        } else if (from.equals("pound") && to.equals("ounce")){
            value = value*16;
        } else if (from.equals("gram") && to.equals("pound")){
            value = value/453.59237;
        } else if (from.equals("gram") && to.equals("ounce")){
            value = value/28.34952;
        } else if (from.equals("gram") && to.equals("kilogram")){
            value = value/1000;
        } else if (from.equals("ounce") && to.equals("pound")){
            value = value/16;
        } else if (from.equals("ounce") && to.equals("gram")){
            value = value*28.3495231;
        } else if (from.equals("ounce") && to.equals("kilogram")){
            value = value/35.27396195;
        }
        return value;
    }
}