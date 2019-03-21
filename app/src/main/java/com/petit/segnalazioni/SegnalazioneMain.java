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
import com.petit.segnalazioni.perso.SegnalazionePersoFragment;
import com.petit.segnalazioni.trovato.SegnalazioneTrovatoFragment;

public class SegnalazioneMain extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.petit_segnalazione_selezione, container, false);
        Button personButton = (Button) myView.findViewById(R.id.perso);
        Button persoButton = (Button) myView.findViewById(R.id.trovato);

        personButton.setOnClickListener(this);
        persoButton.setOnClickListener(this);
        return myView;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.perso:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazionePersoFragment()).commit();
                //aggiungere logica per mandare scelta al DB
                break;
            case R.id.trovato:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneTrovatoFragment()).commit();

                break;
            default:
                break;
        }

    }



}
