package com.petit.segnalazioni.trovato;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.petit.R;

public class SegnalazioneTrovatoFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.petit_segnalazione_animale, container, false);
        Button gattoButton = (Button) myView.findViewById(R.id.gatto);
        Button caneButton = (Button) myView.findViewById(R.id.cane);
        TextView sottoText = (TextView) myView.findViewById(R.id.sottoText);

        sottoText.setText("Dell'animale trovato");

        gattoButton.setOnClickListener(this);
        caneButton.setOnClickListener(this);
        return myView;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cane:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneCaneTrovato()).commit();
                //aggiungere logica per mandare scelta al DB
                break;
            case R.id.gatto:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneGattoTrovato()).commit();
                //aggiungere logica per mandare scelta al DB
                break;
            default:
                break;
        }

    }


}
