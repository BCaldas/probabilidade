package br.com.brunocaldas.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DerrotaActivity extends AppCompatActivity {

    ImageView cholaMais;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derrota);

        binding();

        Glide.with(DerrotaActivity.this)
                .load(R.drawable.cholamais)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(cholaMais);

        Toast.makeText(getApplicationContext(),"Errrroooouuuuu!!!",Toast.LENGTH_LONG).show();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }

    private void binding() {
        cholaMais = (ImageView) findViewById(R.id.cholaMais);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
    }
}
