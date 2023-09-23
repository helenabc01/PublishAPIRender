package com.example.praticad2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cargo;
    private Date data_admissao;
    private double salario;
    private String departamento;

    public Funcionario(int id, String nome, String cargo, Date data_admissao, double salario, String departamento) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.data_admissao = data_admissao;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Funcionario(String nome, String cargo, Date data_admissao, double salario, String departamento) {
        this.nome = nome;
        this.cargo = cargo;
        this.data_admissao = data_admissao;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Funcionario(){

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", data_admissao=" + data_admissao +
                ", salario=" + salario +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
