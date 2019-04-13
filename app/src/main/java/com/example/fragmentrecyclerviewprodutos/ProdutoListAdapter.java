package com.example.fragmentrecyclerviewprodutos;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class ProdutoListAdapter extends RecyclerView.Adapter<ProdutoListAdapter.ListViewHolder> {

    private List<Produto> produtos;
    private Context context;

    public ProdutoListAdapter(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        context = viewGroup.getContext();
        LayoutInflater inflater =  LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_list_produto,viewGroup,false);
        ListViewHolder listViewHolder = new ListViewHolder(view);


        return listViewHolder;
    }





    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, final int position) {

       //Captura os clicks nos cardViews
        listViewHolder.itemView.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Produto produto = produtos.get(position);


                       if ((v.findViewById(R.id.detalhe) != null) || (v.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)){

                           ProdutoDetalheFragment fragment = ProdutoDetalheFragment.instanciaFragment(produto);
                           FragmentManager fm =   ((AppCompatActivity) context).getSupportFragmentManager();

                           FragmentTransaction ft = fm.beginTransaction();
                           ft.replace(R.id.detalhe, fragment, ProdutoDetalheFragment.TAG_DETALHE);
                           ft.commit();

                       }else {


                           Intent intent = new Intent(v.getContext(), ProdutoDetalheActivity.class);
                           intent.putExtra("produto", produto);
                           v.getContext().startActivity(intent);

                       }

                   }
               }
       );

        Produto produto = produtos.get(position);

        TextView nome_produto =  listViewHolder.nomeProduto;
        nome_produto.setText(String.valueOf(produto.getNome()));

        RatingBar estrelas_produto =  listViewHolder.estrelasProduto;
        estrelas_produto.setRating(produto.getEstrela());


        ImageView imagem = listViewHolder.imgProduto;
        //Resources res = context.getResources();
        //imagem.setImageResource(produtos.get(position).getImg());
        imagem.setImageResource(produtos.get(position).getImg());

    }



    public class ListViewHolder extends  RecyclerView.ViewHolder {

        public ImageView imgProduto;
        public TextView nomeProduto;
        public RatingBar estrelasProduto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduto = (ImageView) itemView.findViewById(R.id.img_produto);
            nomeProduto = (TextView) itemView.findViewById(R.id.nome_produto);
            estrelasProduto = (RatingBar) itemView.findViewById(R.id.estrela_produto);
        }
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }


}
