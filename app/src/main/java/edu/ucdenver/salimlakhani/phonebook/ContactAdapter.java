package edu.ucdenver.salimlakhani.phonebook;


import android.content.Context;
//import android.content.Intent;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
    Adapter class
    ContactAdapter.ListItemHolder means ContactAdapter is the class, ListItemHolder is an inner class
    It has to display all the contacts, use modal class
*/
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ListItemHolder>  {

// R
//public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ListItemHolder>  {

    private MainActivity mainActivity;
    private ArrayList<Contact> list; // bring in conctact modal as arraylist

    // D
//    private ContactInfoShowInterface interf;
    // end D

    //E
    Context context;

    // Constructor
    public ContactAdapter (MainActivity mainActivity, ArrayList<Contact> list) {

    // P
//    public ContactAdapter (MainActivity mainActivity, ArrayList<Contact> list, ContactInfoShowInterface interf) {

        this.mainActivity = mainActivity;
        this.list = list;
//        this.interf = interf;

    }

    // return the layout of the list
    public ContactAdapter.ListItemHolder onCreateViewHolder (ViewGroup parent, int viewType ){

    // Q
//    public ContactAdapter.ListItemHolder onCreateViewHolder (ViewGroup parent, int viewType, ContactInfoShowInterface interf){
        View listItem = LayoutInflater.from (parent.getContext())
                .inflate(R.layout.list_layout, parent, false);

        return new ListItemHolder(listItem);

        // H
//        return new ListItemHolder(listItem, interf);
    }

    // assigning values to the views we created in the recycler_view layout file
    // based on the position of the recycler view


    // K
//    @NonNull
//    @Override
//    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//       // String name = .getStringExtra("Name");
//        return null;
//    }

    // bind the contact list item layout with our modal class
    public void onBindViewHolder (ContactAdapter.ListItemHolder holder, int position) {
        Contact contact = list.get(position); // Contact is modal class

        holder.textViewName.setText(contact.getName()); // get name from modal class

        //  MY code - for phone number
        holder.textViewPhone.setText(contact.getPhone());
    }

    // recycler view wants to know how many items you want to display
    public int getItemCount () {
        return  list.size();
    }


    /*
    Inner class, works like onCreate method
    */
    public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewName;

        // My code for text view phone
        private TextView textViewPhone;
        // end my code

        // Constructor
        public ListItemHolder (View itemView) {

        // O - its doubtful check it again

//        public ListItemHolder (View itemView, ContactInfoShowInterface interf) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);  // retrieve nameView by Id
            textViewName.setClickable(true);
            textViewName.setOnClickListener(this);

            // my code for phone
            textViewPhone = itemView.findViewById(R.id.textViewPhone);  // retrieve phoneView by Id
            textViewPhone.setClickable(true);
            textViewPhone.setOnClickListener(this);
            // end my code

        }

        public void onClick (View view) {
            int pos = getAdapterPosition();
            mainActivity.onNameClick(pos);

           // Log.i("Info", "MSG: onClick ContactAdapter clicked here .........................");


        }
    }
}
