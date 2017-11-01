package com.johnduran.practica6_sqlite;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {
    private Button bConsulta;
    private LibrosSQLiteHelper libros;
    private SQLiteDatabase dbLibros;
    private String libro="mundo";
    private ArrayList<Libros> lista_datos;
    private RecyclerView recyclerView;
    private MyAdapt adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_lista, container, false);
        bConsulta=(Button)v.findViewById(R.id.bConsulta);

        libros = new LibrosSQLiteHelper(getContext(), "LibrosDB", null,1);
        dbLibros=libros.getWritableDatabase();
        recyclerView=(RecyclerView)v.findViewById(R.id.contentRecycler);
        bConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista_datos = new ArrayList<Libros>();
                Cursor c = dbLibros.rawQuery("select * from Libros",null);
                while(c.moveToNext()){
                    Libros temp = new Libros();
                    temp.setId(c.getInt(0));
                    temp.setLibro(c.getString(1));
                    temp.setAutor(c.getString(2));
                    temp.setPersona(c.getString(3));
                    temp.setTelefono(c.getString(4));
                    lista_datos.add(temp);
                }


                adapter=new MyAdapt(getContext(),lista_datos);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        });

        return v;
    }


}
