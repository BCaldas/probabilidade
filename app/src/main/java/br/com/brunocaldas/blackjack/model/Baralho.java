package br.com.brunocaldas.blackjack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bruno on 07/12/2017.
 */

public class Baralho implements Serializable {

    private List<Carta> cartas = new ArrayList<>();

    public Baralho() {
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Integer contarCartas() {
        return this.cartas.size();
    }

    public Carta darCarta() {
        Integer indiceCarta = new Random().nextInt(cartas.size());
        Carta carta = cartas.get(indiceCarta);
        cartas.remove(carta);

        return carta;

    }

}
