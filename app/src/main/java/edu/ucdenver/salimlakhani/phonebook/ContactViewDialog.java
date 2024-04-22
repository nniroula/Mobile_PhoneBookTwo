package edu.ucdenver.salimlakhani.phonebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import edu.ucdenver.salimlakhani.phonebook.databinding.DialogViewContactBinding;

public class ContactViewDialog extends DialogFragment {
    private DialogViewContactBinding binding;
    private Contact contact;
    private int position;

    //
    private TextView textViewName;
    private TextView textViewPhone;
    private TextView textViewEmail;
    private TextView textViewStreet;
    private TextView textViewCity;
    private TextView textViewState;
    private TextView textViewZip;
    private TextView textViewType;

    public ContactViewDialog( Contact contact, int position) {
        this.contact = contact;
        this.position = position;
    }
    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState){
        binding = DialogViewContactBinding.inflate(LayoutInflater.from(getContext()));

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());

        // grab the fields
        textViewName = binding.textViewName;
        textViewPhone = binding.textViewPhone;
        textViewEmail = binding.textViewEmail;
        textViewStreet = binding.textViewStreet;
        textViewCity = binding.textViewCity;
        textViewState = binding.textViewState;
        textViewZip = binding.textViewZip;
        textViewType = binding.textViewType;

        // get the data values for the fields
        String name = contact.getName();
        String phone = contact.getPhone();
        String email = contact.getEmail();
        String street = contact.getAddress();
        String city = contact.getCity();
        String state = contact.getState();
        String zip = contact.getZip();
        String contactType = contact.getContacttype();

        // set the values for fields
        textViewName.setText(name);
        textViewPhone.setText(phone);
        textViewEmail.setText(email);
        textViewStreet.setText(street);
        textViewCity.setText(city);
        textViewState.setText(state);
        textViewZip.setText(zip);
        textViewType.setText(contactType);

        binding.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // implement delete functionality
                MainActivity mainActivity = (MainActivity) getActivity();
                assert mainActivity != null;
                mainActivity.removeContact(position);

                dismiss();
            }
        });
        return builder.create();
    }
}