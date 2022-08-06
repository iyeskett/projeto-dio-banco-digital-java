package br.com.dio;

import javax.swing.*;

public abstract class Conta {

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected   Cliente cliente;

    private static final int AGENCIA_PADRAO = 1;

    private static int SEQUENCIAL = 1;
    protected char tipoConta;
    public Conta(){

    }

    public Conta(Cliente cliente) {
        agencia = AGENCIA_PADRAO;
        numero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public char getTipoConta(){
        return tipoConta;
    }


    public void imprimirInfos() {
        if (this.tipoConta == 'c') {
            JOptionPane.showMessageDialog(null, "=== Dados Conta Corrente === "
                    + "\nConta: "
                    + String.format("Cliente: %s", this.cliente.getNome())
                    + String.format(", Agencia: %d", this.agencia)
                    + String.format(", Número: %d", this.numero)
                    + String.format(", Saldo: %.2f", this.saldo)) ;
        }
        else {
            JOptionPane.showMessageDialog(null, "=== Dados Conta Poupança === "
                    + "\nConta: "
                    + String.format("Cliente: %s", this.cliente.getNome())
                    + String.format(", Agencia: %d", this.agencia)
                    + String.format(", Número: %d", this.numero)
                    + String.format(", Saldo: %.2f", this.saldo)) ;
        }

    }

    @Override
    public String toString() {
        return "Conta: " +
                "agencia= " + agencia +
                ", numero= " + numero +
                ", saldo= " + saldo;
    }
}
