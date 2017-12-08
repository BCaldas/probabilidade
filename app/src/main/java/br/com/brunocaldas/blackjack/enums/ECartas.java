package br.com.brunocaldas.blackjack.enums;

/**
 * Created by bruno on 07/12/2017.
 */

public enum ECartas {

    AS("Ás",1),DOIS("Dois",2),TRES("Três",3),QUATRO("Quatro",4),CINCO("Cinco",5),SEIS("Seis",6),SETE("Sete",7),OITO("Oito",8),
    NOVE("Nove",9),DEZ("Dez",10),J("Valete",10),Q("Dama",10),K("Rei",10);

    public Integer valor;
    public String nome;

    ECartas(String nome, Integer valor){
        this.valor = valor;
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

}
