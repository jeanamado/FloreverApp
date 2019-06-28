package com.example.florever;

/* Codigo realizado por Jeanfranco Amado Mayorga
En esta clase definimos los campos que se almacenaran en firebase
 */
public class Persona {
    private String cod_cli;
    private String nom_cli;
    private String ape_cli;
    private String dir_cli;
    private String password;
    private String telefono;
    private String Correo;

    public Persona() {
    }

    public String getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(String cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public String getApe_cli() {
        return ape_cli;
    }

    public void setApe_cli(String ape_cli) {
        this.ape_cli = ape_cli;
    }

    public String getDir_cli() {
        return dir_cli;
    }

    public void setDir_cli(String dir_cli) {
        this.dir_cli = dir_cli;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "cod_cli='" + cod_cli + '\'' +
                ", nom_cli='" + nom_cli + '\'' +
                ", ape_cli='" + ape_cli + '\'' +
                ", dir_cli='" + dir_cli + '\'' +
                ", password='" + password + '\'' +
                ", telefono='" + telefono + '\'' +
                ", Correo='" + Correo + '\'' +
                '}';
    }
}
