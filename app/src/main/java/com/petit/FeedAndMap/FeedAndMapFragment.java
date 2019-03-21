package com.petit.FeedAndMap;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.petit.R;


public class FeedAndMapFragment extends Fragment {

    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.petit_tabview_feed_and_map, container, false);

        tabLayout = (TabLayout) rootView.findViewById(R.id.TabLayout);

        // Begin the transaction
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.containerFragment, new MapFragment());
        ft.commit();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment;
                int position = tab.getPosition();
                //requests = Map - 0
                //invitations = Feed - 1
                switch (position) {
                    case 0:
                        getFragmentManager().beginTransaction().replace(R.id.containerFragment, new MapFragment()).commit();
                        break;
                    case 1:
                        getFragmentManager().beginTransaction().replace(R.id.containerFragment, new FeedFragment()).commit();
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }


}
