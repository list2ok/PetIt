package com.petit.segnalazioni;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.petit.R;
import com.petit.database.DbAdapter;


public class AggiungiSegnalazione extends AppCompatActivity {

    private String colorePelo;
    private String tipoPelo;
    private String taglia;
    private String statoFisico;
    private String statoMentale;
    private String note;


    private DbAdapter dbHelper;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petit_form_segnalazione);

        dbHelper = new DbAdapter(this);
        dbHelper.open();
        cursor = dbHelper.fetchAllSegnalazioni();

        final EditText colorePeloET = (EditText) findViewById(R.id.colorePelo);
        final Spinner tipoPeloET = (Spinner) findViewById(R.id.tipoPelo);
        final Spinner tagliaSP = (Spinner) findViewById(R.id.taglia);
        final Spinner statoFisicoET = (Spinner) findViewById(R.id.statoFisico);
        final Spinner statoMentaleET = (Spinner) findViewById(R.id.statoMentale);
        final EditText noteET = (EditText) findViewById(R.id.infoExtra);
        //  ImageButton posizione = (ImageButton) findViewById(R.id.bottone_posizione);
        Button inviaSegnalazione = (Button) findViewById(R.id.immettiSegnalazione);


        inviaSegnalazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorePelo = colorePeloET.getText().toString();
                tipoPelo = tipoPeloET.getSelectedItem().toString();
                taglia = tagliaSP.getSelectedItem().toString();
                statoFisico = statoFisicoET.getSelectedItem().toString();
                statoMentale = statoMentaleET.getSelectedItem().toString();
                note = noteET.getText().toString();


                dbHelper.creaSegnalazione(colorePelo, tipoPelo, taglia, statoFisico, statoMentale, note);


                Toast.makeText(AggiungiSegnalazione.this, taglia, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
