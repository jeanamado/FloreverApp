package com.example.florever;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Productos extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private AdView mAdView;

/*Codigo realizado por Jeanfranco Amado Mayorga
con el siguiente codigo se definen valores para cada boton que sera enviado hacia otra actividad para mostrarla
segun sea seleccionado el producto
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

            mAdView = findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
    }

    //Definimos los valores de los productos y los enviamos a la actividad pedido
    public void onClickPed(View view) {
        Intent a = new Intent( Productos.this, pedido.class);
        switch(view.getId())
        {
            case R.id.imageButton:
                a.putExtra("precio",99.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",105.00);
                a.putExtra("img",R.mipmap.baby);
                break;
            case R.id.imageButton2:
                a.putExtra("precio",149.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",155.00);
                a.putExtra("img",R.mipmap.bossa);
                break;
            case R.id.imageButton3:
                a.putExtra("precio",169.00);
                a.putExtra("envio",5.50);
                a.putExtra("total",174.50);
                a.putExtra("img",R.mipmap.bouquet);
                break;
            case R.id.imageButton4:
                a.putExtra("precio",139.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",145.00);
                a.putExtra("img",R.mipmap.cone);
                break;
            case R.id.imageButton5:
                a.putExtra("precio",179.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",185.00);
                a.putExtra("img",R.mipmap.cristal);
                break;
            case R.id.imageButton6:
                a.putExtra("precio",149.00);
                a.putExtra("envio",5.50);
                a.putExtra("total",154.50);
                a.putExtra("img",R.mipmap.deluxe);
                break;
            case R.id.imageButton7:
                a.putExtra("precio",229.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",235.00);
                a.putExtra("img",R.mipmap.garden);
                break;
            case R.id.imageButton8:
                a.putExtra("precio",229.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",235.00);
                a.putExtra("img",R.mipmap.giant);
                break;
            case R.id.imageButton9:
                a.putExtra("precio",79.00);
                a.putExtra("envio",5.50);
                a.putExtra("total",84.50);
                a.putExtra("img",R.mipmap.girasoles);
                break;
            case R.id.imageButton10:
                a.putExtra("precio",109.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",115.00);
                a.putExtra("img",R.mipmap.girasolesmix);
                break;
            case R.id.imageButton11:
                a.putExtra("precio",159.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",165.00);
                a.putExtra("img",R.mipmap.medium);
                break;
            case R.id.imageButton12:
                a.putExtra("precio",59.00);
                a.putExtra("envio",5.50);
                a.putExtra("total",64.50);
                a.putExtra("img",R.mipmap.mini);
                break;
            case R.id.imageButton13:
                a.putExtra("precio",79.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",85.00);
                a.putExtra("img",R.mipmap.minichoco);
                break;
            case R.id.imageButton14:
                a.putExtra("precio",129.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",135.00);
                a.putExtra("img",R.mipmap.minisquare);
                break;
            case R.id.imageButton15:
                a.putExtra("precio",159.00);
                a.putExtra("envio",5.50);
                a.putExtra("total",164.50);
                a.putExtra("img",R.mipmap.minitulip);
                break;
            case R.id.imageButton16:
                a.putExtra("precio",179.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",185.00);
                a.putExtra("img",R.mipmap.moyen);
                break;
            case R.id.imageButton17:
                a.putExtra("precio",139.00);
                a.putExtra("envio",6.00);
                a.putExtra("total",145.00);
                a.putExtra("img",R.mipmap.surprise);
                break;
            case R.id.imageButton18:
                a.putExtra("precio",19.00);
                a.putExtra("envio",5.50);
                a.putExtra("total",24.50);
                a.putExtra("img",R.mipmap.unit);
                break;

        }
        startActivity(a);    }
}

