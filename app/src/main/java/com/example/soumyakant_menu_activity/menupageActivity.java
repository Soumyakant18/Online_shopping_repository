package com.example.soumyakant_menu_activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.soumyakant_menu_activity.databinding.ActivityMenupageBinding;
import com.google.android.material.navigation.NavigationView;

public class menupageActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMenupageBinding binding;
    private TextView nameTextView, emailTextView;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenupageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMenupage.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        View headerView = navigationView.getHeaderView(0);
        nameTextView = headerView.findViewById(R.id.name);
        emailTextView = headerView.findViewById(R.id.mailid);

        currentUser = getCurrentUser();
        if (currentUser != null) {
            String username = currentUser.getName();
            String email = currentUser.getEmail();

            nameTextView.setText(username);
            emailTextView.setText(email);
        } else {
            nameTextView.setText("Guest");
            emailTextView.setText("");
        }

        mAppBarConfiguration = new AppBarConfiguration.Builder (
                R.id.nav_home, R.id.nav_account_information, R.id.nav_signout, R.id.nav_cart)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menupage);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menupage, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menupage);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private User getCurrentUser() {

        DatabaseHelper dbHelper = new DatabaseHelper (this);
        int userId = 1; // Replace with the actual user ID
        User user = dbHelper.getUserDetails (userId);
        return user;
    }

}
