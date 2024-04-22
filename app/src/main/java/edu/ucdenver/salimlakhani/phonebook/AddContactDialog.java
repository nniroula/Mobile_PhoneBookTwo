package edu.ucdenver.salimlakhani.phonebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import edu.ucdenver.salimlakhani.phonebook.databinding.DialogAddContactBinding;

public class AddContactDialog extends DialogFragment {
    private DialogAddContactBinding binding;

    public Dialog onCreateDialog (Bundle savedInstanceState) { // this method creates alert dialog

        binding = DialogAddContactBinding.inflate(LayoutInflater.from(getContext()));

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());
        binding.addContact.inflateMenu(R.menu.menu_add_contact);

        binding.addContact.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();

                        if (id == R.id.action_save) {
                            String name = binding.textInputName.getText().toString();
                            String phone = binding.textInputPhone.getText().toString();
                            String email = binding.textInputEmail.getText().toString();
                            String street = binding.textInputStreet.getText().toString();
                            String city = binding.textInputCity.getText().toString();
                            String state = binding.textInputState.getText().toString();
                            String zip = binding.textInputZip.toString();

                            String contactType = "";

                            if (binding.radioButtonBusiness.isChecked())
                                contactType = "Business";
                            else if (binding.radioButtonFamily.isChecked())
                                contactType = "Family";
                            else if (binding.radioButtonFriend.isChecked())
                                contactType = "friend";


                            Contact contact = new Contact (name, phone, email, street, city, state, zip, contactType);

                            MainActivity mainActivity = (MainActivity) getActivity();
                            mainActivity.addContact (contact);

                            dismiss();

                        }
                        else if (id == R.id.action_clear) {

                            binding.textInputName.setText("");
                            binding.textInputPhone.setText("");
                            binding.textInputEmail.setText("");

                            binding.radioButtonBusiness.setChecked(true);
                            binding.textInputName.requestFocus();

                        }
                        else if (id == R.id.action_exit) {
                            dismiss();
                        }

                        return false;
                    }
                }
        );

        binding.buttonMainMenu.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick (View v) {
                        dismiss();
                    }
                }
        );

        binding.buttonClear.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick (View v) {
                        binding.textInputName.setText("");
                        binding.textInputPhone.setText("");
                        binding.textInputEmail.setText("");
                        // My additon
                        binding.textInputCity.setText("");
                        binding.textInputState.setText("");
                        binding.textInputStreet.setText("");
                        binding.textInputZip.setText("");
                        // end my addition

                        binding.radioButtonBusiness.setChecked(true);
                        binding.textInputName.requestFocus();

                    }
                }

        );

        binding.buttonSave.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick (View v) {

                        String name = binding.textInputName.getText().toString();
                        String phone = binding.textInputPhone.getText().toString();
                        String email = binding.textInputEmail.getText().toString();
                        String street = binding.textInputStreet.getText().toString();
                        String city = binding.textInputCity.getText().toString();
                        String state = binding.textInputState.getText().toString();
                        //String zip = binding.textInputZip.toString();
                        String zip = binding.textInputZip.getText().toString();

                        String contactType = "";

                        if (binding.radioButtonBusiness.isChecked())
                            contactType = "Business";
                        else if (binding.radioButtonFamily.isChecked())
                            contactType = "Family";
                        else if (binding.radioButtonFriend.isChecked())
                            contactType = "friend";


                        Contact contact = new Contact (name, phone, email, street, city, state, zip, contactType);

                        MainActivity mainActivity = (MainActivity) getActivity();
                        mainActivity.addContact (contact);

                        dismiss();


                    }
                }
        );


        return builder.create();

    }
}
