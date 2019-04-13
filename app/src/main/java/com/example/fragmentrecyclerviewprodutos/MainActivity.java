package com.example.fragmentrecyclerviewprodutos;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Produto> hoteis;

    private RecyclerView recyclerView;
    //private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /*recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);




        hoteis = carregarHoteis();

        recyclerView.setAdapter(new ProdutoListAdapter(hoteis,this));*/
    }



    /*private List<Produto> carregarHoteis() {
        List<Produto> hoteis = new ArrayList<>();
        hoteis.add(new Produto("New Beach hotel"

                , 4.5f, R.drawable.perfil));
        hoteis.add(new Produto("Paris Produto"
                , 4.0f, R.drawable.perfil));
        hoteis.add(new Produto("New Beach hotel"

                , 3.5f, R.drawable.perfil));

//...outros hotéis
        return hoteis;
    }*/
}
