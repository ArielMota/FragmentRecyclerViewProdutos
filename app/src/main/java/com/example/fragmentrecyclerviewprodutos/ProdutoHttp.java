package com.example.fragmentrecyclerviewprodutos;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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

public class ProdutoHttp {

    String urllocal = "/prod/";
    String URLprodutos = APIconfig.URL;
    List<Produto> listaprodutos;
    private RecyclerView myrecyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

     ProdutoListAdapter produtoListAdapter;


   /* private List<Produto> getProdutos(String jsonString) {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            JSONArray produtosJson = new JSONArray(jsonString);
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
            Log.e("Erro", "Erro no parsing do JSON", e);
        }
        return produtos;
    }*/


    public void getProdutos(final Context context, final Activity activity, final View view) {


        RequestQueue queue = Volley.newRequestQueue(context);


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLprodutos+urllocal,
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

                                System.out.println(produtos.get(i).getNome());
                            }

                             myrecyclerview = (RecyclerView) view.findViewById(R.id.my_recycler_view);
                            produtoListAdapter = new ProdutoListAdapter(produtos,context);
                            myrecyclerview.setLayoutManager(new LinearLayoutManager(activity));
                            //myrecyclerview.setLayoutManager(new GridLayoutManager(activity(),2));

                            myrecyclerview.setAdapter(produtoListAdapter);

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








}
