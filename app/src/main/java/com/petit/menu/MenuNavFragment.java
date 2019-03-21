package com.petit.menu;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.petit.R;
import com.petit.database.DbAdapter;


public class MenuNavFragment extends Fragment implements View.OnClickListener {

    private DbAdapter dbHelper;
    private Cursor cursor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.petit_fragment_menupage, container, false);

        LinearLayout modificaImpostazioni = (LinearLayout) myView.findViewById(R.id.modifica_impostazioni);

        modificaImpostazioni.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.modifica_impostazioni:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ModificaImpostazioniFragment()).commit();
                break;


            //aggiungere logica per mandare scelta al DB
/*
                dbHelper = new DbAdapter(getContext());
                dbHelper.open();
                cursor = dbHelper.fetchAllSegnalazioni();

                cursor.moveToFirst();

                while (cursor.moveToNext()) {
                    Integer segnalazioneID = cursor.getInt(cursor.getColumnIndex((DbAdapter.KEY_ID)));
                    String taglia = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_TAGLIA));
                    Toast.makeText(getActivity(), taglia, Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "contact id = " + segnalazioneID);
                }

                cursor.close();
                dbHelper.close();

                */

        }
    }
}
