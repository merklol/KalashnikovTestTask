package com.maximapps.kalashnikovtesttask;

import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class HostActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        navController = getNavHostFragment().getNavController();
        setupActionBarWithNavController(this, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

    private NavHostFragment getNavHostFragment() {
        return (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
    }
}