package com.example.morpions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Tableau a deux dimensions
    //plateau[colonne][ligne]
    //0 : case vide
    //1 : X
    //2 : O
    private int plateau[][] = new int[3][3];

    //1 : X
    //2 : O

    private int joueurEnCours = 1;
    private TextView tvJoueur;
    ArrayList<Button> all_buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvJoueur = (TextView) findViewById(R.id.joueur);
        Button bt1 = (Button) findViewById(R.id.bt1);
        Button bt2 = (Button) findViewById(R.id.bt2);
        Button bt3 = (Button) findViewById(R.id.bt3);
        Button bt4 = (Button) findViewById(R.id.bt4);
        Button bt5 = (Button) findViewById(R.id.bt5);
        Button bt6 = (Button) findViewById(R.id.bt6);
        Button bt7 = (Button) findViewById(R.id.bt7);
        Button bt8 = (Button) findViewById(R.id.bt8);
        Button bt9 = (Button) findViewById(R.id.bt9);

        all_buttons.add(bt1);
        all_buttons.add(bt2);
        all_buttons.add(bt3);
        all_buttons.add(bt4);
        all_buttons.add(bt5);
        all_buttons.add(bt6);
        all_buttons.add(bt7);
        all_buttons.add(bt8);
        all_buttons.add(bt9);

        for (Button bt: all_buttons){
            bt.setBackground(null);
            bt.setOnClickListener(this);
        }
    }
    public void onClick(View view) {
        if(view.getBackground() != null)
            return;
        switch (view.getId()){
            case R.id.bt1:
                plateau[0][0] = joueurEnCours;
                break;
            case R.id.bt2:
                plateau[1][0] = joueurEnCours;
                break;
            case R.id.bt3:
                plateau[2][0] = joueurEnCours;
                break;
            case R.id.bt4:
                plateau[0][1] = joueurEnCours;
                break;
            case R.id.bt5:
                plateau[1][1] = joueurEnCours;
                break;
            case R.id.bt6:
                plateau[2][1] = joueurEnCours;
                break;
            case R.id.bt7:
                plateau[0][2] = joueurEnCours;
                break;
            case R.id.bt8:
                plateau[1][2] = joueurEnCours;
                break;
            case R.id.bt9:
                plateau[2][2] = joueurEnCours;
                break;
            default:
                return;
        }
        Drawable drawableJoueur;
        if(joueurEnCours == 1)
            drawableJoueur = ContextCompat.getDrawable(this,R.drawable.x);
        else
            drawableJoueur = ContextCompat.getDrawable(this,R.drawable.o);
        view.setBackground(drawableJoueur);
        if(joueurEnCours == 1){
            joueurEnCours = 2;
            tvJoueur.setText("O");
        }
        else{
            joueurEnCours = 1;
            tvJoueur.setText("X");
        }
    }
}