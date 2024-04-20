package edu.ucdenver.salimlakhani.phonebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import edu.ucdenver.salimlakhani.phonebook.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

// B
//public class MainActivity extends AppCompatActivity implements ContactInfoShowInterface{

    private ActivityMainBinding binding;
    private ArrayList<Contact> list;                // modal to be stored in arraylist

    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        list = new ArrayList<Contact>();                    // contact modal
        contactAdapter = new ContactAdapter(this, list);

        // I  - make 3 args
//        contactAdapter = new ContactAdapter(this, list, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.content.recyclerView.setLayoutManager(layoutManager);
        binding.content.recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        binding.content.recyclerView.setAdapter(contactAdapter);




        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                AddContactDialog addContactDialog = new AddContactDialog();
                addContactDialog.show(getSupportFragmentManager(), "");
            }
        }

        );
    } // End of onCreate method

    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater().inflate(R.menu.menu_activity_main, menu);

        return true;

    }

    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add) {
            AddContactDialog addContactDialog = new AddContactDialog();
            addContactDialog.show(getSupportFragmentManager(), "");
        }


        return true;
    }

    public void addContact (Contact contact) {
        list.add(contact);
        contactAdapter.notifyDataSetChanged();

        //Log.i ("info", "Number of Contacts" + list.size());
    }

    // C
//    @Override
    public void onNameClick(int position) {
        // J
//        Intent intent = new Intent(this, AddContactDialog.class);
        Intent intent = new Intent(this, ShowContactInfoActivity.class);

        Log.i("info", "MSG: I am in MainActivity.java *************** ");

        //Log.d("Debug", "MSG: position is " + position);
        // Log.d("Debug", "MSG: get Name " + list.get(position).getName());

        intent.putExtra("NAME", list.get(position).getName());
       // Log.d("Get String method", intent.getStringExtra("NAME"));
        intent.putExtra("PHONE", list.get(position).getPhone());
        intent.putExtra("EMAIL", list.get(position).getEmail());
        intent.putExtra("STREET", list.get(position).getAddress());
        intent.putExtra("CITY", list.get(position).getCity());
        intent.putExtra("STATE", list.get(position).getState());
        intent.putExtra("ZIP", list.get(position).getZip());
//        intent.putExtra("ZIP", Integer.parseInt(list.get(position).getZip()));
//        intent.putExtra("ZIP", Integer.parseInt(list.get(position).getZip()));
        intent.putExtra("CONTACTTYPE", list.get(position).getContacttype());


        Log.d("info", "MSG: " + list.get(position).getZip());


//        ShowContactInfoActivity sc = new ShowContactInfoActivity();
        //sc.displayContact();


        startActivity(intent);

    }


} //End of class