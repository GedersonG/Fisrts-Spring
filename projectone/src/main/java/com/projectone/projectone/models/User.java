package com.projectone.projectone.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    //@GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Getter @Setter @Column(name = "id")
        private int id;
        @Getter @Setter @Column(name = "nombre")
        private String nombre;
        @Getter @Setter @Column(name = "apellido")
        private String apellido;
        @Getter @Setter @Column(name = "email")
        private String email;
        @Getter @Setter @Column(name = "documento")
        private String documento;
        @Getter @Setter @Column(name = "password")
        private String password;

    public User() {
    }



    public User(int id, String nombre, String apellido, String email, String documento, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.documento = documento;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }
}
