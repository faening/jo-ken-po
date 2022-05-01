package com.course.android.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 0 - Pedra
    // 1 - Papel
    // 2 - Tesoura
    public void playGame(View v) {
        Integer userChoise; // Armazenar a escolha do usuário

        if (Objects.equals(v.getId(), R.id.option_stone)) {
            userChoise = 0;
        } else if (Objects.equals(v.getId(), R.id.option_paper)) {
            userChoise = 1;
        } else {
            userChoise = 2;
        }

        Integer IAChoise = new Random().nextInt(3); // Armazenar a escolha da IA
        ImageView iv = findViewById(R.id.option_machine); // Alterar a imagem da jogada da IA

        switch (IAChoise) {
            case 0:
                iv.setImageResource(R.drawable.pedra);
                break;
            case 1:
                iv.setImageResource(R.drawable.papel);
                break;
            case 2:
                iv.setImageResource(R.drawable.tesoura);
                break;
            default:
                iv.setImageResource(R.drawable.padrao);
        }

        // Verificar quem é o ganhador
        TextView res = findViewById(R.id.text_result);

        if (userChoise == 0 && IAChoise == 2 ||
            userChoise == 1 && IAChoise == 0 ||
            userChoise == 2 && IAChoise == 1) {
            res.setText("Parabéns! você ganhou!");
        } else if (userChoise == IAChoise) {
            res.setText("Empate!");
        } else {
            res.setText("Vish! não foi dessa vez...");
        }
    }
}