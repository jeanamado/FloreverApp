package com.example.florever;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class completo extends AppCompatActivity {
    ImageView img;

    /*Codigo realizado por: Jeanfranco Amado Mayorga
    con el siguiente codigo se descargará una imagen de internet
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completo);
    }

    //Al presionar el boton regresaríamos a la actividad de productos
    public void onClickvolve(View view) {
        Intent a = new Intent( completo.this, Productos.class);
        startActivity(a);
    }

    //Al momento de presionar el boton de descargar nos descargará la imagen del siguiente url
    public void onClickDesc(View view) {
       new DownloadImageTask().execute
               ("https://www.floreverperu.com/wp-content/uploads/2019/05/como-comprar-florever-peru.jpg");
    }

    //genereamos las excepciones y la conexion para la descarga de imagen
    private InputStream OpenHttpConnection(String urlString) throws IOException{

        InputStream in = null;
        int response = -1;
        URL url = new URL (urlString);
        URLConnection conn = url.openConnection();
        if (!(conn instanceof HttpURLConnection))throw new IOException("Not an HTTP connection");
        try{
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK){in = httpConn.getInputStream();
            }
        }
        catch (Exception ex){
            Log.d("Networking", ex.getLocalizedMessage());
            throw new IOException("Error Connecting");
        }
        return in;
    }

    //obtiene la dirección url para la descarga de la imagen
    private Bitmap DownloadImage(String URL){
        Bitmap bitmap = null;
        InputStream in = null;
        try{
            in = OpenHttpConnection(URL);
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        }
        catch (IOException e1){
            Log.d("NetworkingActivity", e1.getLocalizedMessage());
        }
        return bitmap;
    }

    //utiliza el metodo de descarga de imagen para devolver la imagen
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{
        protected Bitmap doInBackground(String... urls){
            return DownloadImage(urls[0]);
        }

        //Se modifica la imagen de la actividad por la imagen descargada
        protected void onPostExecute(Bitmap result){
            ImageView img = findViewById(R.id.img);
            img.setImageBitmap(result);
        }
    }
}
