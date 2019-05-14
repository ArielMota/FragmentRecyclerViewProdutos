package com.example.fragmentrecyclerviewprodutos;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
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

    public void getProdutos() {


        RequestQueue queue = Volley.newRequestQueue(this);


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, APIconfig.URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        List<Produto> produtos = new ArrayList<Produto>();


                        try {
                            JSONArray produtosJson = new JSONArray(response);
                            JSONObject produto;

                            for (int i = 0; i < produtosJson.length(); i++) {
                                produto = new JSONObject(produtosJson.getString(i));
                                // Log.i("PESSOA ENCONTRADA: ", "id=" + produto.getString("id"));

                                Produto objetoProduto = new Produto();
                                objetoProduto.setNome(produto.getString("nome"));
                                objetoProduto.setPreco(produto.getString("preco"));
                                objetoProduto.setEstrela(produto.getLong("estrela"));
                                objetoProduto.setImg(produto.getString("url_img"));
                                produtos.add(objetoProduto);
                            }




                        } catch (JSONException e) {
                            Log.e("Erro", "kkkkkkkkkkkkkkkkkkkkkkkkkkkkk", e);
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

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
