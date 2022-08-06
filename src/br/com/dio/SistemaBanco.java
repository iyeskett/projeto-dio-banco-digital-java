package br.com.dio;

import javax.swing.*;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class SistemaBanco {
    private static Banco banco = new Banco("Santander");
    private static Cliente clientePoupanca = new Cliente();
    private static Conta contaPoupanca = new ContaPoupanca();
    private static Cliente clienteCorrente = new Cliente();
    private static Conta contaCorrente = new ContaPoupanca();
    private static char tipoConta;


    public static void boasVindas() {
        JOptionPane.showMessageDialog(null,"Olá, bem vindo ao banco " + banco.getNome());
    }

    private static int menuOpcoes() {
        String opcaoDesejada = JOptionPane.showInputDialog("Digite a opção desejada: "
                + "\n1 - Cadastrar novo cliente "
                + "\n2 - Acessar a área do cliente"
                + "\n3 - Consultar dados do cliente"
                + "\n4 - Consultar listas de clientes");
        if (opcaoDesejada == null){
            System.exit(0);
        }

        return Integer.parseInt(opcaoDesejada);
    }

    public static void iniciar() {
        switch (menuOpcoes()) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                acessarAreaCliente();
                break;
            case 3:
                consultarDadosClientes();
                break;
            case 4:
                consultarClientes();
                break;


        }

    }

    private static void cadastrarCliente() {
        String[] dadosCliente =
                JOptionPane.showInputDialog("Digite o nome do cliente e o tipo de conta: " +
                        "(Exemplo: Felipe, poupanca/corrente)").split(", ");
        switch (dadosCliente[1]) {
            case "poupanca":
                Cliente cliente = new Cliente(dadosCliente[0]);
                clientePoupanca = cliente;
                Conta conta = new ContaPoupanca(cliente);
                contaPoupanca = conta;
                contaPoupanca.setCliente(clientePoupanca);
                clientePoupanca.setConta(contaPoupanca);
                tipoConta = contaPoupanca.getTipoConta();
                banco.adicionarCliente(clientePoupanca);
                banco.adicionarConta(contaPoupanca);
                break;
            case "corrente":
                Cliente cliente1 = new Cliente(dadosCliente[0]);
                clienteCorrente = cliente1;
                Conta conta1 = new ContaPoupanca(cliente1);
                contaCorrente = conta1;
                contaCorrente.setCliente(clienteCorrente);
                clienteCorrente.setConta(contaCorrente);
                tipoConta = contaCorrente.getTipoConta();
                banco.adicionarCliente(clienteCorrente);
                banco.adicionarConta(contaCorrente);
                break;
        }
    }

    private static void acessarAreaCliente() {
        int valor;
        int opcaoDesejada = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "
                + "\n1 - Sacar "
                + "\n2 - Depositar"
                + "\n3 - Transferir"
                + "\n4 - Consultar dados"));
        if (tipoConta == 'c') {
            switch (opcaoDesejada) {
                case 1:
                    valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor"));
                    contaCorrente.sacar(valor);
                    break;
                case 2:
                    valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor"));
                    contaCorrente.depositar(valor);
                    break;
                case 3:
                    String[] dadosTransferencia = JOptionPane.showInputDialog(
                            "Digite o valor e a numero da conta para transferir: (exemplo: 500 1)").split(" ");
                    for (Conta conta : banco.contas) {
                        if (Integer.parseInt(dadosTransferencia[1]) == contaCorrente.numero ||
                                Integer.parseInt(dadosTransferencia[1]) == contaPoupanca.numero) {
                            contaCorrente.transferir(Integer.parseInt(dadosTransferencia[0]),
                                    conta);
                        } else {
                            JOptionPane.showMessageDialog(null, "Conta não encontrada");
                        }
                    }
                    break;
                case 4:
                    contaCorrente.imprimirInfos();

            }

        } else {
            switch (opcaoDesejada) {
                case 1:
                    valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor"));
                    contaPoupanca.sacar(valor);
                    break;
                case 2:
                    valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor"));
                    contaPoupanca.depositar(valor);
                    break;
                case 3:
                    String[] dadosTransferencia = JOptionPane.showInputDialog(
                            "Digite o valor e a numero da conta para transferir: (exemplo: 500 1)").split(" ");
                    for (Conta conta : banco.contas) {
                        if (Integer.parseInt(dadosTransferencia[1]) == contaCorrente.numero ||
                                Integer.parseInt(dadosTransferencia[1]) == contaPoupanca.numero) {
                            contaPoupanca.transferir(Integer.parseInt(dadosTransferencia[0]),
                                    conta);
                        } else {
                            JOptionPane.showMessageDialog(null, "Conta não encontrada");
                        }
                    }
                    break;
                case 4:
                    contaPoupanca.imprimirInfos();

            }
        }
    }

    public static void consultarDadosClientes() {
        banco.listarDadosClientes();
    }

    public static void consultarClientes() {
        banco.listarClientes();
    }
}
