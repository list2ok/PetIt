package com.petit.segnalazioni;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.petit.R;
import com.petit.menu.MenuNavFragment;

public class MessaggioFineSegnalazione extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.petit_messaggio_fine_segnalazione, container, false);

        Button button = (Button) myView.findViewById(R.id.ritorna_menu);

        button.setOnClickListener(this);

        return myView;

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ritorna_menu:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuNavFragment()).commit();
                break;
            default:
                break;
        }

    }
}
