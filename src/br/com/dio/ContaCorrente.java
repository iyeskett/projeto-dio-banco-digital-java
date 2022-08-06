package br.com.dio;

import javax.swing.*;

public class ContaCorrente extends Conta {

    public ContaCorrente(){

    }
    public ContaCorrente(Cliente cliente){
        super(cliente);
        tipoConta = 'c';
    }

}
