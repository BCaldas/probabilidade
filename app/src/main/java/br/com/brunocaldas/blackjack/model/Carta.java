package br.com.brunocaldas.blackjack.model;

import java.io.Serializable;

/**
 * Created by bruno on 07/12/2017.
 */

public class Carta implements Serializable {

    private Integer valor;
    private String naipe;
    private String nome;

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carta() {

    }

    public Carta(Integer valor, String naipe, String nome) {

        this.valor = valor;
        this.naipe = naipe;
        this.nome = nome;
    }
}
