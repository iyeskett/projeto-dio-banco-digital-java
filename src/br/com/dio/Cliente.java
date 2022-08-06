package br.com.dio;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Conta> contas = new LinkedList<>();

    public Cliente() {

    }

    public Cliente(String nome, Conta conta) {
        this.nome = nome;
        contas.add(conta);
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getContas() {
        String listaCliente = " ";
        for (Conta conta : contas) {
            listaCliente += conta + "\n";
        }
        return listaCliente;
    }

    public void setConta(Conta conta) {
        contas.add(conta);
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
