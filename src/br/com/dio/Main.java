package br.com.dio;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        boolean continueLooping = true;
        SistemaBanco.boasVindas();

        do {
            try {

                SistemaBanco.iniciar();


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (continueLooping);


    }
}
