package com.example.florever;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {
    ImageButton play_pause;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_pause = findViewById(R.id.btnmusic);
        mp = MediaPlayer.create(this,R.raw.cancion);

    }

    /*Código realizado por: Lucia Lazo Portugal
    Esta porción de codigo nos muestra como ejecutar una canción cuando se pesione el boton play_pause
     */
    public void onClickMusic(View view) {
        if(mp.isPlaying()){
            mp.pause();
            play_pause.setImageResource(R.mipmap.iconplay);
            Toast.makeText(MainActivity.this,"Pausa",Toast.LENGTH_SHORT).show();
        }else{
            mp.start();
            play_pause.setImageResource(R.mipmap.iconpause);
            Toast.makeText(MainActivity.this,"Play",Toast.LENGTH_SHORT).show();
        }
    }

    //Inicia la actividad donde se encuentra el video
    public void onClickVideo(View view) {
        Intent a = new Intent( MainActivity.this, video.class);
        startActivity(a); }

    //Inicia la actividad del login
    public void onClickLogin(View view) {
        Intent a = new Intent( MainActivity.this, Login.class);
        startActivity(a); }

    //Inicia la actividad de registros
    public void onClick_Reg(View view) {
        Intent a = new Intent( MainActivity.this, Registro.class);
        startActivity(a);    }

    /* Codigo realizado por: Brunella Rodriguez Ugaz
        El siguiente código nos muestra como realizar llamadas a un número
        telefónico y como dirigirnos a las redes sociales de la empresa
     */
    // Este codigo es para la realización de llamadas
    public void onClick(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.CALL_PHONE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para realizar llamadas telefónicas.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 225);
        } else {
            Log.i("Mensaje", "Se tiene permiso para realizar llamadas!");
        }
        Uri number = Uri.parse("tel:974309668");
        Intent llama = new Intent(Intent.ACTION_CALL, number);
        startActivity(llama);
    }

    //Este código nos redirecciona a la pagina oficial de facebook de Florever
    public void onClickFace(View view) {
        Intent a = new Intent(Intent.ACTION_VIEW,Uri.parse
                ("https://www.facebook.com/floreverperu/"));
        startActivity(a);
    }

    //Este código nos redirecciona a la pagina oficial de Instagram de Florever
    public void onClickInst(View view) {
        Intent a = new Intent(Intent.ACTION_VIEW,Uri.parse
                ("https://www.instagram.com/floreverperu/"));
        startActivity(a);
    }

    //Este código nos redirecciona a la pagina oficial de Florever
    public void onClickWhat(View view) {
        Intent a = new Intent(Intent.ACTION_VIEW,Uri.parse
                ("https://www.floreverperu.com/"));
        startActivity(a);
    }
}


