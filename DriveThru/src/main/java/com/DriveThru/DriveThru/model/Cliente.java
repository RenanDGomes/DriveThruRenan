package com.DriveThru.DriveThru.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente {

    @NotNull(message = "O campo nome não pode ser nulo.")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "Campo CPF não pode ser nulo.") //O CPF não pode ser nulo
    @Column(nullable = false, unique = true) // O banco de dados não deve permitir valores nulos na coluna correspondente, não tera cpf duplicado
    @Size(min = 11, max = 14) // Tamnho do cpf deve estar entre 11 a 14 caarcteres
    private String cpf;

    @NotNull(message = "O saldo não pode ser nulo.")
    @Column(nullable = false)
    private float saldo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Cliente() {
    }
    public Cliente(String nome, String cpf, float saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
