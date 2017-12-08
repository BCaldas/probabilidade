package br.com.brunocaldas.blackjack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 07/12/2017.
 */

public class Jogador implements Serializable {

    private List<Carta> cartas = new ArrayList<>();

    public Jogador() {

    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Integer calcularSomaCartas() {

        Integer soma = 0;
        for (Carta c : cartas) {
            soma += c.getValor();
        }

        return soma;
    }

    public void receberCarta(Carta carta) {
        cartas.add(carta);
    }
}
