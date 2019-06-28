package com.example.florever;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Registro extends AppCompatActivity{

    EditText nom_cli, ape_cli, dir_cli, password, telefono, correo;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    /*Codigo realizado por Roberto Cruz Mormontoy
    Con el siguiente codigo se almacenará los datos en firebase
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nom_cli = findViewById(R.id.nombre);
        ape_cli = findViewById(R.id.apellidos);
        dir_cli = findViewById(R.id.direccion);
        password = findViewById(R.id.password);
        telefono = findViewById(R.id.telefono);
        correo = findViewById(R.id.correo);
        iniciarFirebase();



    }
// Se inicia firebase
    private void iniciarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

// Se ejecuta al momento de presionar registrar para registrar datos y comprobarlos que no esten vacios
    public void onClickRegistrar(View view) {
        String nombre = nom_cli.getText().toString();
        String apellidos = ape_cli.getText().toString();
        String direccion = dir_cli.getText().toString();
        String pass = password.getText().toString();
        String telf = telefono.getText().toString();
        String email = correo.getText().toString();

        if (nombre.equals("")||apellidos.equals("")||direccion.equals("")||pass.equals("")||
        telf.equals("")||email.equals("")){
            validación();
        }
        else{
            Persona p = new Persona();
            p.setCod_cli(UUID.randomUUID().toString());
            p.setNom_cli(nombre);
            p.setApe_cli(apellidos);
            p.setDir_cli(direccion);
            p.setPassword(pass);
            p.setTelefono(telf);
            p.setCorreo(email);
            databaseReference.child("Persona").child(p.getCod_cli()).setValue(p);
            Toast.makeText(this,"Registrado Correctamente", Toast.LENGTH_LONG).show();
            limpiar();
            Intent a = new Intent( Registro.this, Productos.class);
            startActivity(a);
        }

    }
// Una vez culminado el registro se limpian los campos
    private void limpiar() {
        nom_cli.setText("");
        ape_cli.setText("");
        dir_cli.setText("");
        password.setText("");
        telefono.setText("");
        correo.setText("");
    }

    //Esta porción de codigo valida que ningun campo se encuentre vacío
    private void validación() {
        String nombre = nom_cli.getText().toString();
        String apellidos = ape_cli.getText().toString();
        String direccion = dir_cli.getText().toString();
        String pass = password.getText().toString();
        String telf = telefono.getText().toString();
        String email = correo.getText().toString();

        if(nombre.equals("")){
            nom_cli.setError("Required");
        }
        else if (apellidos.equals("")){
            ape_cli.setError("Required");
        }
        else if (direccion.equals("")){
            dir_cli.setError("Required");
        }
        else if (pass.equals("")){
            password.setError("Required");
        }
        else if (telf.equals("")){
            telefono.setError("Required");
        }
        else if (email.equals("")){
            correo.setError("Required");
        }

    }
}
