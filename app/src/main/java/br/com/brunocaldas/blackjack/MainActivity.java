package br.com.brunocaldas.blackjack;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.brunocaldas.blackjack.enums.ECartas;
import br.com.brunocaldas.blackjack.model.Baralho;
import br.com.brunocaldas.blackjack.model.Carta;
import br.com.brunocaldas.blackjack.model.Jogador;

public class MainActivity extends AppCompatActivity {

    Button btnNovoJogo;
    ImageButton btnBaralho, btnMao;
    ListView cartasNaMao;
    TextView probabilidadeVitoria, total, parcial;
    Baralho baralho;
    Jogador jogador;
    private boolean doublePressCheat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binding();
        btnBaralho.setEnabled(false);

        btnNovoJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comecarJogo();
            }
        });
        btnBaralho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                darCartas(1);
            }
        });

        btnMao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doublePressCheat) {
                    finish();
                    Intent i = new Intent(getApplicationContext(),VitoriaActivity.class);
                    startActivity(i);
                    return;
                }
                doublePressCheat = true;
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doublePressCheat=false;
                    }
                }, 2000);
            }
        });
    }

    private void binding() {
        btnBaralho = (ImageButton) findViewById(R.id.btnBaralho);
        btnNovoJogo = (Button) findViewById(R.id.btnNovoJogo);
        cartasNaMao = (ListView) findViewById(R.id.lstCartasNaMao);
        probabilidadeVitoria = (TextView) findViewById(R.id.txtProbabilidade);
        total = (TextView) findViewById(R.id.txtTotal);
        parcial = (TextView)findViewById(R.id.txtParcial);
        btnMao = (ImageButton) findViewById(R.id.btnMao);
    }

    private void comecarJogo() {
        baralho = new Baralho();
        jogador = new Jogador();
        btnBaralho.setEnabled(true);
        preencherBaralho();
        darCartas(2);
        parcial.setVisibility(View.INVISIBLE);
    }

    private void darCartas(Integer numeroCartas) {
        for (int i = 0; i < numeroCartas; i++) {
            jogador.receberCarta(baralho.darCarta());
        }
        atualizarCartasNaMao();
        verificarVitoria();
        ExibirSoma();
    }

    private void ExibirSoma() {
        Integer soma = jogador.calcularSomaCartas();

        total.setText(soma.toString());
        for (Carta c : jogador.getCartas()) {
            if (c.getNome().equals("Ás")) {
                soma+= 10;
                parcial.setText(soma.toString());
                parcial.setVisibility(View.VISIBLE);
            }
        }
    }

    private void preencherBaralho() {
        List<Carta> cartas = new ArrayList<>();
        List<String> naipes = new ArrayList<String>() {
            {
                add("Copas");
                add("Paus");
                add("Ouros");
                add("Espadas");
            }
        };

        for (String naipe : naipes) {
            for (ECartas e : ECartas.values()) {
                cartas.add(new Carta(e.getValor(), naipe, e.getNome()));
            }
        }

        baralho.setCartas(cartas);
    }

    private void atualizarCartasNaMao() {

        if (jogador.getCartas() != null && !jogador.getCartas().isEmpty()) {

            List<Map<String, String>> data = new ArrayList<Map<String, String>>();
            for (Carta c : jogador.getCartas()) {
                Map<String, String> datum = new HashMap<String, String>(2);
                datum.put("nome", c.getNome() + " de " + c.getNaipe());
                datum.put("valor", "Valor: " + c.getValor().toString());
                data.add(datum);
            }

            SimpleAdapter adapter = new SimpleAdapter(this, data,
                    android.R.layout.simple_list_item_2,
                    new String[]{"nome", "valor"},
                    new int[]{android.R.id.text1,
                            android.R.id.text2});

            cartasNaMao.setAdapter(adapter);
        }

    }

    private void verificarVitoria() {
        Integer soma = jogador.calcularSomaCartas();
        Integer somaAux = 0;

        for (Carta c : jogador.getCartas()) {
            somaAux = soma;
            if (c.getNome().equals("Ás")) {
                somaAux += 10;
            }
        }

        if (soma == 21 || somaAux == 21) {
            exibirMsg("Ganhou!!!!");
            btnBaralho.setEnabled(false);
            finish();
            Intent i = new Intent(getApplicationContext(),VitoriaActivity.class);
            startActivity(i);

        } else if (soma > 21) {
            exibirMsg("Errroooouuuuu!!!");
            btnBaralho.setEnabled(false);
        }
    }

    private void exibirMsg(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }

    private void calculaProbabilidade(){
        double casosVitoria = 0;
        probabilidadeVitoria.setText("");
    }
}
