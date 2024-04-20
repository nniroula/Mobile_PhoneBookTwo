package edu.ucdenver.salimlakhani.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.ucdenver.salimlakhani.phonebook.databinding.ActivityMainBinding;

public class ShowContactInfoActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TextView textViewName;
    private TextView textViewPhone;
    private TextView textViewEmail;
    private TextView textViewStreet;
    private TextView textViewCity;
    private TextView textViewState;
    private TextView textViewZip;
    private TextView textViewType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact_info);


        // data from intent
        textViewName = findViewById(R.id.textViewName);
        textViewPhone = findViewById(R.id.textViewPhone);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewStreet = findViewById(R.id.textViewStreet);
        textViewCity = findViewById(R.id.textViewCity);
        textViewState = findViewById(R.id.textViewState);
        textViewZip = findViewById(R.id.textViewZip);
        textViewType = findViewById(R.id.textViewType);

        // get the intent using getIntent() method
        Intent intent = getIntent();

        // get values
        String name = intent.getStringExtra("NAME");
        Log.d("Get String method in SHow", "MSG: SHOWContactActivity intent ..." + name);
        String phone = intent.getStringExtra("PHONE");
        String email = intent.getStringExtra("EMAIL");
        String street = intent.getStringExtra("STREET");
        String city = intent.getStringExtra("CITY");
        String state = intent.getStringExtra("STATE");
        String zip = intent.getStringExtra("ZIP");
        //String zip = String.valueOf(Integer.parseInt(intent.getStringExtra("ZIP")));
        //int zip = intent.getIntExtra("ZIP", 00000);
        String contactType = intent.getStringExtra("CONTACTTYPE");

        Log.d("info", "MSG: Zip value " + zip);
        textViewName.setText(name);
        textViewPhone.setText(phone);
        textViewEmail.setText(email);
        textViewStreet.setText(street);
        textViewCity.setText(city);
        textViewState.setText(state);
//        if(zip >= 0) textViewZip.setText(zip);
        textViewZip.setText(zip);
        textViewType.setText(contactType);

    }


//    public void displayContact(View view){
//    public void displayContact(View view){
//        textViewName = findViewById(R.id.textViewName);
//        MainActivity ma;
////        ma.getIntExtra(position)
//        // get the intent using getIntent() method
//        Intent intent = getIntent();
//
//        // get values
//        String name = intent.getStringExtra("NAME");
//        Log.d("Get String method in SHow", "MSG: SHOWContactActivity intent ..." + name);
//
//        textViewName.setText(name);
//    }



}