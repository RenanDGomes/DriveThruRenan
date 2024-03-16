package com.DriveThru.DriveThru.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente {

    @NotNull(message = "O campo nome não pode ser nulo.")
    @Column(nullable = false)
    private String nomeCliente;

    @NotNull(message = "Campo CPF não pode ser nulo.") //O CPF não pode ser nulo
    @Column(nullable = false, unique = true) // O banco de dados não deve permitir valores nulos na coluna correspondente, não tera cpf duplicado
    @Pattern(regexp = "[0-9]+", message = "Deve conter apenas números")
    @Size(min = 11, max = 14) // Tamnho do cpf deve estar entre 11 a 14 caarcteres
    private String cpfCliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    public Cliente() {
    }
    public Cliente(String nomeCliente, String cpfCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }
}
