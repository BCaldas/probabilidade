package br.com.brunocaldas.blackjack;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class VitoriaActivity extends AppCompatActivity {

    ImageView foguinhos, parabens;
    Button btnVoltar;
    MediaPlayer mPlayer;
    MediaPlayer aplausos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitoria);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        binding();

        mPlayer.start();
        aplausos.start();

        Glide.with(VitoriaActivity.this)
                .load(R.drawable.vitoria)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(foguinhos);

        Glide.with(VitoriaActivity.this)
                .load(R.drawable.parabens)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(parabens);

        Toast.makeText(getApplicationContext(),"Ganhhooouuuuu!!!",Toast.LENGTH_LONG).show();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                aplausos.stop();
                finish();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }

    private void binding() {
        foguinhos = (ImageView) findViewById(R.id.foguinhos);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        parabens = (ImageView) findViewById(R.id.parabens);
        mPlayer = MediaPlayer.create(VitoriaActivity.this, R.raw.fogos);
        aplausos = MediaPlayer.create(VitoriaActivity.this, R.raw.aplausos);
    }
}
