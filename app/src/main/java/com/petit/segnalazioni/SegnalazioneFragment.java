package com.petit.segnalazioni;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.petit.R;
import com.petit.database.DbAdapter;

public class SegnalazioneFragment extends Fragment implements View.OnClickListener {

    EditText posizione;
    EditText colorePelo;
    Spinner tipoPelo;
    Spinner taglia;
    Spinner statoFisico;
    Spinner statoMentale;
    EditText noteAggiuntive;
    Button immettiSegnalazione;

    private DbAdapter dbHelper;
    private Cursor cursor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.petit_form_segnalazione, container, false);

        dbHelper = new DbAdapter(getActivity());
        dbHelper.open();
        cursor = dbHelper.fetchAllSegnalazioni();

        posizione = (EditText) myView.findViewById(R.id.posizione);
        colorePelo = (EditText) myView.findViewById(R.id.colorePelo);
        tipoPelo = (Spinner) myView.findViewById(R.id.tipoPelo);
        taglia = (Spinner) myView.findViewById(R.id.taglia);
        statoFisico = (Spinner) myView.findViewById(R.id.statoFisico);
        statoMentale = (Spinner) myView.findViewById(R.id.statoMentale);
        noteAggiuntive = (EditText) myView.findViewById(R.id.infoExtra);

        immettiSegnalazione = (Button) myView.findViewById(R.id.immettiSegnalazione);

        immettiSegnalazione.setOnClickListener(this);


        return myView;

    }

    @Override
    public void onClick(View v) {

        String posizioneInserita = posizione.getText().toString();
        String colorePeloInserito = colorePelo.getText().toString();
        String tipoPeloInserito = tipoPelo.getSelectedItem().toString();
        String statoFisicoInserito = statoFisico.getSelectedItem().toString();
        String statoMentaleInserito = statoMentale.getSelectedItem().toString();
        String noteAggiuntiveInserite = noteAggiuntive.getText().toString();
        String tagliaScelta = taglia.getSelectedItem().toString();

        //queste variabili memorizzano tutti i dati inseriti dall'utente
        //bisogna implementare la logica che le spedisca al DB

        switch (v.getId()) {
            case R.id.immettiSegnalazione:
                //implementare logica DB
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessaggioFineSegnalazione()).commit();
                long resId = dbHelper.creaSegnalazione(colorePeloInserito, tipoPeloInserito, tagliaScelta, statoFisicoInserito, statoMentaleInserito, noteAggiuntiveInserite);
                Log.d("SegnalazioneFragment", "ID = " + resId);
                break;
            default:
                break;
        }


        //logica per spedire i dati al db
    }
}
