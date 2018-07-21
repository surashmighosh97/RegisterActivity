package com.example.surashmi.register;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.graphics.Color;


import static com.example.surashmi.register.R.id.text_input_name;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout textPersonName;
    private TextInputLayout textinputcollegeName;
    private TextInputLayout numberphonenumber;
    private TextInputLayout textInputEmailaddress;
    TextView textViewCategory;
    TextView textViewEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCategory=findViewById(R.id.textViewCategorySpinner);
         textViewEvent=findViewById(R.id.textViewEventSpinner);
         Spinner spinner=findViewById(R.id.categorySpinner);
         Spinner spinner1=findViewById(R.id.eventSpinner);
         ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.events_category_array,android.R.layout.simple_spinner_item);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.event_array,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);



        textPersonName=findViewById (R.id.text_input_name);
        textinputcollegeName=findViewById(R.id.text_input_collegename);
        numberphonenumber= findViewById(R.id.number_phonenumber);
        textInputEmailaddress= findViewById(R.id.text_input_emailaddress);
    }

    private boolean validateEmail() {
        String emailInput = textInputEmailaddress.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmailaddress.setError("Field can't be empty");
            return false;
        } else {
            textInputEmailaddress.setError(null);
            textInputEmailaddress.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUsername() {
        String usernameInput = textPersonName.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            textPersonName.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 25) {
            textPersonName.setError("Username too long");
            return false;
        } else {
            textPersonName.setError(null);
            return true;
        }
    }

    private boolean validateCollegeName() {
        String collegenameInput = textinputcollegeName.getEditText().getText().toString().trim();

        if (collegenameInput.isEmpty()) {
            textinputcollegeName.setError("Field can't be empty");
            return false;
        } else if (collegenameInput.length() > 20) {
            textinputcollegeName.setError("collegename too long");
            return false;
        } else {
            textinputcollegeName.setError(null);
            return true;
        }
    }

















    public void RegisterInput(View v) {
        if (!validateEmail() | !validateUsername() | !validateCollegeName()) {
            return;
        }

        String input = "Email: " + textInputEmailaddress.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + textPersonName.getEditText().getText().toString();
        input += "\n";
        input += "College's Name: " + textinputcollegeName.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}
