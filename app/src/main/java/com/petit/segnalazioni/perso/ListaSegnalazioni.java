package com.petit.segnalazioni.perso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.petit.R;

import java.util.ArrayList;

public class ListaSegnalazioni extends AppCompatActivity {


    private ListView listView;
    private ArrayList<String> lista;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView=findViewById(R.id.listView);
        lista=new ArrayList<>();
        inizializzaLista(50);

        adapter= new ArrayAdapter<>(ListaSegnalazioni.this,android.R.layout.simple_list_item_1,lista);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaSegnalazioni.this, "Posizione:"+position+" nome "+lista.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void inizializzaLista(int numero){

        for (int i=0; i<numero; i++){

            lista.add("Persona"+ String.valueOf(i));
        }

    }
}
