package com.mycompany.gerenciabanco;

import java.util.Scanner;

public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();

        System.out.println("Bem Vindo");
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.println("Digite seu CPF");
        String cpf = scanner.nextLine();

        conta.setNome(nome);
        conta.setSobrenome(sobrenome);
        conta.setCpf(cpf);

        int opcao = 0;

        do {
            System.out.println("\n Escolha uma opção: ");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Realizar Deposito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Encerrar");
            System.out.print("Opção escolhida: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n Saldo Atual é R$" + conta.getSaldo());
                    break;
                case 2:
                    System.out.println("\n Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("\n Depósito realizado com sucesso.");
                    break;
                case 3:
                    System.out.print("\n Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("\n Saque efetuado com sucesso.");
                    } else {
                        System.out.println("\n Saldo insuficiente.");
                    }
                    break;
                case 4:
                    System.out.println("\n Obrigado por utilizar o serviço");
                    break;
                default:
                    System.out.println("\n Opção inválida ! Digite novamente.");
            }
        } while (opcao != 4);
    }
}

class ContaBancaria {

    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void depositar(double valor){
        saldo += valor;
    }
    
    public boolean sacar (double valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }
}
