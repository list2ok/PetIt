package com.petit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.petit.FeedAndMap.FeedAndMapFragment;
import com.petit.menu.MenuNavFragment;
import com.petit.segnalazioni.SegnalazioneMain;

public class NavActivityTEST extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petit_activity_nav);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuNavFragment()).commit();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_add:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneMain()).commit();
                        break;
                    case R.id.action_mappa:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeedAndMapFragment()).commit();
                        break;
                    case R.id.action_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuNavFragment()).commit();
                        break;
                }
                return true;
            }
        });


    }
}
