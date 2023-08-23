package com.example.soumyakant_menu_activity.ui.signout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.soumyakant_menu_activity.R;
import com.example.soumyakant_menu_activity.loginpage_avtivity;

public class SignoutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signout, container, false);

        Button signOutButton = rootView.findViewById(R.id.signouot);
           signOutButton.setOnClickListener (new View.OnClickListener ( ) {
               @Override
               public void onClick(View view) {
                 performesignout();
               }

               private void performesignout() {
                   clearusertime();
                   navigateToLoginPage();
               }

               private void navigateToLoginPage() {
                   Intent intent = new Intent(getActivity(), loginpage_avtivity.class);
                   startActivity(intent);

                   getActivity().finish();
               }

               private void clearusertime() {
               }
           });

        return rootView;
    }
}
