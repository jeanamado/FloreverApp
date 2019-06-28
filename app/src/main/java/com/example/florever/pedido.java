package com.example.florever;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class pedido extends AppCompatActivity {

    TextView precio;
    TextView envio;
    TextView total;
    ImageView imageView;
    @Override

    /*Codigo realizado por: Jeanfranco Amado Mayorga
    Con este codigo se espera recibir los datos de la actividad de productos y
    mostrarlos en la interfaz
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        recibirDatos();

    }

    //Aqui se reciben los datos ty se le asigna a una variable
    private void recibirDatos(){
        try{
            Bundle extras = getIntent().getExtras();
            Double pre = extras.getDouble("precio");
            Double env = extras.getDouble("envio");
            Double tot = extras.getDouble("total");
            Integer image = extras.getInt("img");


        precio = findViewById(R.id.precio);
        precio.setText("El precio del producto es de:S/."+pre);

        envio = findViewById(R.id.envio);
        envio.setText("El precio de envío es de: S/."+env);

        total = findViewById(R.id.total);
        total.setText("El monto total es de:  S/."+tot);

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(image);
        }
        catch(Exception e){}
    }

    // Con este boton se regresa a la actividad de productos
    public void onClickvolv(View view) {
        Intent a = new Intent( pedido.this, Productos.class);
        startActivity(a);
    }

    // Nos manda a la siguiente actividad la cual es completo
    public void onClickCompl(View view) {
        Intent a = new Intent( pedido.this, completo.class);
        startActivity(a);
    }
}


