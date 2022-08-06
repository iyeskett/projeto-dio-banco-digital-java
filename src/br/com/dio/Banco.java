package br.com.dio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Banco {
    private String nome;
    protected List<Cliente> clientes = new LinkedList<>();
    protected List<Conta> contas = new LinkedList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public void listarDadosClientes() {

        String listaCliente = "Lista de dados dos clientes: \n";
        for (Cliente cliente : clientes) {
            listaCliente += cliente.getNome() + ": ";
            listaCliente += cliente.getContas() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaCliente);

    }

    public void listarClientes() {

        String listaCliente = "Lista de clientes: \n";
        for (Cliente cliente : clientes) {
            listaCliente += cliente.getNome() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaCliente);
    }

    public String getNome() {
        return nome;
    }
}
