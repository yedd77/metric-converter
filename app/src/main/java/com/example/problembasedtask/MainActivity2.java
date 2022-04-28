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

public class MainActivity2 extends AppCompatActivity{

    boolean isNewCalc = true;
    boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner lenghtdropdown1 = (Spinner) findViewById(R.id.lengthDrop1);
        Spinner lenghtdropdown2 = (Spinner) findViewById(R.id.lengthDrop2);
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
        TextView lenghtVar = (TextView) findViewById(R.id.lengthVar);
        TextView ConvLengthVar = (TextView) findViewById(R.id.convLengthVar);
        TextView convertFrom = (TextView) findViewById(R.id.convertTo);
        TextView convertTo = (TextView) findViewById(R.id.convertFrom);

        //back button function
        backButton.setOnClickListener(view -> {
            Intent mainPage = new Intent(getBaseContext(), MainActivity.class);
            startActivity(mainPage);
        });

        //create a new pattern for decimal places
        //https://developer.android.com/reference/java/text/DecimalFormat
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);

        //This ArrayAdapter returning array list onto Spinner
        //https://developer.android.com/reference/android/widget/ArrayAdapter
        //Adapter for lengthDropDown1
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(
                this,
                R.array.lengthDropdown1,
                R.layout.dropdowncolor
        );
        adapter.setDropDownViewResource(R.layout.dropdowncolor_list);
        lenghtdropdown1.setAdapter(adapter);

        //AdapterView is used to handle user selection for spinner
        //https://developer.android.com/guide/topics/ui/binding
        lenghtdropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertFrom.setText(adapterView.getSelectedItem().toString());

                //get spinner item values
                String from = lenghtdropdown1.getSelectedItem().toString();
                String to = lenghtdropdown2.getSelectedItem().toString();

                //declare new double var to temporary store the calculated value
                double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

                //send value into converted textview
                ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        //This ArrayAdapter returning array list onto Spinner
        //https://developer.android.com/reference/android/widget/ArrayAdapter
        //Adapter for lengthDropDown1
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(
                this,
                R.array.lengthDropdown2,
                R.layout.dropdowncolor
        );
        adapter2.setDropDownViewResource(R.layout.dropdowncolor_list);
        lenghtdropdown2.setAdapter(adapter2);
        //AdapterView is used to handle user selection for spinner
        //https://developer.android.com/guide/topics/ui/binding
        lenghtdropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertTo.setText(adapterView.getSelectedItem().toString());

                //get spinner item values
                String from = lenghtdropdown1.getSelectedItem().toString();
                String to = lenghtdropdown2.getSelectedItem().toString();

                //declare new double var to temporary store the calculated value
                double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

                //send value into converted textview
                ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        buttonZero.setOnClickListener(view -> {
            //differentiate predefined string and value 0
            if (!isNewCalc){
                lenghtVar.setText(String.format("%s0", lenghtVar.getText()));
            }
            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonOne.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || lenghtVar.getText().toString().equals("0")){
                lenghtVar.setText("");
                isNewCalc = false;
            }
            lenghtVar.setText(String.format("%s1", lenghtVar.getText()));

            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());


            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonTwo.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || lenghtVar.getText().toString().equals("0")){
                lenghtVar.setText("");
                isNewCalc = false;
            }
            lenghtVar.setText(String.format("%s2", lenghtVar.getText()));

            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonThree.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || lenghtVar.getText().toString().equals("0")){
                lenghtVar.setText("");
                isNewCalc = false;
            }
            lenghtVar.setText(String.format("%s3", lenghtVar.getText()));

            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonFour.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || lenghtVar.getText().toString().equals("0")){
                lenghtVar.setText("");
                isNewCalc = false;
            }
            lenghtVar.setText(String.format("%s4", lenghtVar.getText()));

            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonFive.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || lenghtVar.getText().toString().equals("0")){
                lenghtVar.setText("");
                isNewCalc = false;
            }
            lenghtVar.setText(String.format("%s5", lenghtVar.getText()));

            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonSix.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || lenghtVar.getText().toString().equals("0")){
                lenghtVar.setText("");
                isNewCalc = false;
            }
            lenghtVar.setText(String.format("%s6", lenghtVar.getText()));

            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonSeven.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || lenghtVar.getText().toString().equals("0")){
                lenghtVar.setText("");
                isNewCalc = false;
            }
            lenghtVar.setText(String.format("%s7", lenghtVar.getText()));

            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonEight.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || lenghtVar.getText().toString().equals("0")){
                lenghtVar.setText("");
                isNewCalc = false;
            }
            lenghtVar.setText(String.format("%s8", lenghtVar.getText()));

            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonNine.setOnClickListener(view -> {
            //remove predefined string when isNewCalc equals to true
            //new calculation contain predefined string ("0")
            if (isNewCalc || lenghtVar.getText().toString().equals("0")){
                lenghtVar.setText("");
                isNewCalc = false;
            }
            lenghtVar.setText(String.format("%s9", lenghtVar.getText()));

            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonDot.setOnClickListener(view -> {
            if (!isClicked){
                lenghtVar.setText(String.format("%s.", lenghtVar.getText()));
                isClicked = true;
                isNewCalc = false;
            }
            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });

        buttonClear.setOnClickListener(view -> {
            //reset all item into default state
            lenghtVar.setText("0");
            ConvLengthVar.setText("0");
            isNewCalc = true;
            isClicked = false;
        });

        buttonDel.setOnClickListener(view -> {
            String text = lenghtVar.getText().toString();

            //making sure that the value not equal to null
            if (text.length() == 1){
                text = "0";
            } else {
                text = text.substring(0, text.length() - 1 );
            }

            //reset isClicked logic if deleted value contain "."
            isClicked = text.contains(".");
            lenghtVar.setText(text);

            //get spinner item values
            String from = lenghtdropdown1.getSelectedItem().toString();
            String to = lenghtdropdown2.getSelectedItem().toString();

            //declare new double var to temporary store the calculated value
            double calculatedNo = Double.parseDouble(lenghtVar.getText().toString());

            //send value into converted textview
            ConvLengthVar.setText(df.format(calculateValue(calculatedNo, from, to)));
        });
    }

    //function to convert value of the item
    public double calculateValue(double value, String from, String to){

        if (from.equals("centimeters") && to.equals("meters")){
            value = value/100;
        } else if (from.equals("centimeters") && to.equals("feet")){
            value = value/30.48;
        } else if (from.equals("centimeters") && to.equals("inches")){
            value = value/ 2.54;
        } else if (from.equals("meters") && to.equals("centimeters")){
            value = value*100;
        } else if (from.equals("meters") && to.equals("feet")){
            value = value*3.28084;
        } else if (from.equals("meters") && to.equals("inches")){
            value = value*39.37;
        } else if (from.equals("feet") && to.equals("centimeters")){
            value = value*30.48;
        } else if (from.equals("feet") && to.equals("meters")){
            value = value/3.281;
        } else if (from.equals("feet") && to.equals("inches")){
            value = value*12;
        } else if (from.equals("inches") && to.equals("centimeters")){
            value = value*2.54;
        } else if (from.equals("inches") && to.equals("meters")){
            value = value/39.37;
        } else if (from.equals("inches") && to.equals("feet")){
            value = value/12;
        }
        return value;
    }
}