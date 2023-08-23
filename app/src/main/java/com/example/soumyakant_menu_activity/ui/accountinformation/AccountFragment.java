package com.example.soumyakant_menu_activity.ui.accountinformation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.soumyakant_menu_activity.DatabaseHelper;
import com.example.soumyakant_menu_activity.R;
import com.example.soumyakant_menu_activity.User;

public class AccountFragment extends Fragment {
    private DatabaseHelper databaseHelper;

    private int userId =1 ; // Replace with the actual user ID

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        TextView usernameTextView = rootView.findViewById(R.id.username);
        TextView emailTextView = rootView.findViewById(R.id.mailuser);
        Button button = rootView.findViewById(R.id.userbutton);

         DatabaseHelper databaseHelper = new DatabaseHelper (requireContext ());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_home);
            }
        });

        String username = retrieveUsernameFromDatabase(databaseHelper,userId);
        String email = retrieveEmailFromDatabase(databaseHelper,userId);

        usernameTextView.setText(username);
        emailTextView.setText(email);

        return rootView;
    }

    private String retrieveEmailFromDatabase(DatabaseHelper databaseHelper ,int userId) {
        User user = databaseHelper.getUserDetails(userId);
        return user.getEmail();
    }

    private String retrieveUsernameFromDatabase(DatabaseHelper databaseHelper,int userId) {
        User user = databaseHelper.getUserDetails(userId);
        return user.getName();
    }

}
