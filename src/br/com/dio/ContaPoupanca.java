package br.com.dio;

import javax.swing.*;

public class ContaPoupanca extends Conta {

    public  ContaPoupanca(){

    }
    public ContaPoupanca(Cliente cliente){
        super(cliente);
        tipoConta = 'p';
    }
}
