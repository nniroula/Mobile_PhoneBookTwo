
/*
package edu.ucdenver.salimlakhani.phonebook;

import static com.google.android.material.internal.ContextUtils.getActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;
import androidx.fragment.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import edu.ucdenver.salimlakhani.phonebook.databinding.ActivityMainBinding;

public class ShowContactInfoActivity extends AppCompatActivity {
//public class ShowContactInfoDialog extends DialogFragment {
    // private ActivityMainBinding binding;
    private TextView textViewName;
    private TextView textViewPhone;
    private TextView textViewEmail;
    private TextView textViewStreet;
    private TextView textViewCity;
    private TextView textViewState;
    private TextView textViewZip;
    private TextView textViewType;

    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact_info);

        // receive data from intent
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

        // get values using intent
        String name = intent.getStringExtra("NAME");
        //Log.d("Get String method in SHow", "MSG: SHOWContactActivity intent ..." + name);
        String phone = intent.getStringExtra("PHONE");
        String email = intent.getStringExtra("EMAIL");
        String street = intent.getStringExtra("STREET");
        String city = intent.getStringExtra("CITY");
        String state = intent.getStringExtra("STATE");
        String zip = intent.getStringExtra("ZIP");
        String contactType = intent.getStringExtra("CONTACTTYPE");

       // set values using intent
        textViewName.setText(name);
        textViewPhone.setText(phone);
        textViewEmail.setText(email);
        textViewStreet.setText(street);
        textViewCity.setText(city);
        textViewState.setText(state);
        textViewZip.setText(zip);
        textViewType.setText(contactType);

        // delete button
        // get delete button - findviewbyId
        // use list method delete to delete a contact, and dismiss()

        /*
       // Contact contact;
         TextView deleteBtn = findViewById(R.id.buttonDelete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // contact = getAdapterPositon
                // create a delete method in main activity and use it here

                int pos = intent.getIntExtra("POSITION", -1);
                Log.d("info", "MSG: POSITION is " + pos);
               // MainActivity ma = new MainActivity();
              //  ma.removeContact(pos);
                (new MainActivity()).removeContact(pos);
            }
        });
    }
}

 */

/*
    Goes in MainActivity.java file

       public void onNameClick(int position) {
        if (position != RecyclerView.NO_POSITION) {
            Contact contact = list.get(position);
            ContactViewDialog cvDialog = new ContactViewDialog(contact, position);
            cvDialog.show(getSupportFragmentManager(), "");
        }

        // NOTE: code below is left intentionally commented for future reference
        works with ShowContactInfoActivity.class activity file

       // Intent intent = new Intent(this, AddContactDialog.class);
        Intent intent = new Intent(this, ShowContactInfoActivity.class);

        intent.putExtra("NAME", list.get(position).getName());
       // Log.d("Get String method", intent.getStringExtra("NAME"));
        intent.putExtra("PHONE", list.get(position).getPhone());
        intent.putExtra("EMAIL", list.get(position).getEmail());
        intent.putExtra("STREET", list.get(position).getAddress());
        intent.putExtra("CITY", list.get(position).getCity());
        intent.putExtra("STATE", list.get(position).getState());
        intent.putExtra("ZIP", list.get(position).getZip()); // number type
        intent.putExtra("CONTACTTYPE", list.get(position).getContacttype());

        // pass the position and in ShowContactInfoActitivity, remove it.
        position = position;
        intent.putExtra("POSITION", position);
        startActivity(intent);

    }
 */



