package com.example.fragmentrecyclerviewprodutos;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private String preco;
    private float estrela;
    private String url_img;

    public Produto(){

    }

    public Produto(String nome, float estrela, String img, String preco) {
        this.nome = nome;
        this.estrela = estrela;
        this.url_img = img;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.nome;
    }
//Getters e setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public float getEstrela() {
        return estrela;
    }

    public void setEstrela(float estrela) {
        this.estrela = estrela;
    }

    public String getImg() {
        return url_img;
    }

    public void setImg(String img) {
        this.url_img = img;
    }
}
