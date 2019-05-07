package com.example.fragmentrecyclerviewprodutos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class ProdutoListFragment extends Fragment {
    private List<Produto> produtos;
    private ArrayAdapter<Produto> adapter;
    View view;

    private RecyclerView myrecyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ProdutoListAdapter produtoListAdapter;

    private EditText buscraFiltro;


    private List<Produto> carregarHoteis() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Camisa Torcedor Infantil Flamengo I 2018/19 sem Número Adidas"

                , 5.0f, R.drawable.camisaflamego,"R$ 174,99"));
        produtos.add(new Produto("Camisa Torcedor Infantil Corinthians I 2017/18 Sem Número Nike"
                , 4.0f, R.drawable.camisacorinthias,"R$ 129,90"));

        produtos.add(new Produto("Camisa Vasco II 2018 s/n° - Torcedor Diadora Masculina - Branco"

                , 4.0f, R.drawable.camisavasco,"R$ 184,99"));
        produtos.add(new Produto("Camisa Torcedor Palmeiras I 2017/18 Adidas"
                , 3.5f, R.drawable.camisapalmeiras,"R$ 124,99"));




//...outros hotéis
        return produtos;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.lista_produtos,container,false);

        produtos = carregarHoteis();

        myrecyclerview = (RecyclerView) view.findViewById(R.id.my_recycler_view);
          produtoListAdapter = new ProdutoListAdapter(produtos,getContext());
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //myrecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));

        myrecyclerview.setAdapter(produtoListAdapter);



        return view;
    }


    public interface AoClicarNoProduto {
        void clicouNoProduto(Produto produto);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);



        inflater.inflate(R.menu.menu_principal,menu);


        //MenuItem buscaProduto = menu.findItem(R.id.action_search);



        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

        /*final MenuItem item = menu.add("Search");
        item.setIcon(R.drawable.ic_search);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        final SearchView searchView = new SearchView(getActivity());
        //searchView.setOnQueryTextListener(this);
        searchView.setIconifiedByDefault(true);
        item.setActionView(searchView);*/


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                produtoListAdapter.getFilter().filter(newText);
                return false;
            }
        });



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }
}