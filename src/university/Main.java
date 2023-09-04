package university;

import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Fachada fachada = new Fachada();
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        while (escolha != 6) {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar Aluno");
            System.out.println("2 - Deletar Aluno");
            System.out.println("3 - Recuperar Aluno por E-mail");
            System.out.println("4 - Recuperar Alunos com Número de Créditos Pagos");
            System.out.println("5 - Recuperar Aluno por Matrícula e Adicionar Créditos");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Matrícula do aluno: ");
                    String matricula = scanner.nextLine();
                    System.out.print("E-mail do aluno: ");
                    String email = scanner.nextLine();
                    fachada.adicionarAluno(nome, matricula, email);
                    System.out.println("Aluno adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Matrícula do aluno a ser deletado: ");
                    matricula = scanner.nextLine();
                    fachada.deletarAluno(matricula);
                    System.out.println("Aluno deletado com sucesso!");
                    break;
                case 3:
                    System.out.print("E-mail do aluno a ser recuperado: ");
                    email = scanner.nextLine();
                    AlunoUniversidade alunoPorEmail = fachada.recuperarAlunoPorEmail(email);
                    if (alunoPorEmail != null) {
                        System.out.println("Aluno encontrado:\n" + alunoPorEmail);
                    } else {
                        System.out.println("Nenhum aluno encontrado com esse e-mail.");
                    }
                    break;
                case 4:
                    System.out.print("Número de créditos mínimos: ");
                    int creditos = scanner.nextInt();
                    List<AlunoUniversidade> alunosComCreditos = fachada.recuperarAlunosComCreditosPagos(creditos);
                    if (!alunosComCreditos.isEmpty()) {
                        System.out.println("Alunos com pelo menos " + creditos + " créditos pagos:");
                        for (AlunoUniversidade aluno : alunosComCreditos) {
                            System.out.println(aluno.getNome() + " - Créditos Pagos: " + aluno.getCreditosPagos());
                        }
                    } else {
                        System.out.println("Nenhum aluno encontrado com essa quantidade de créditos.");
                    }
                    break;
                case 5:
                    System.out.print("Matrícula do aluno a ser recuperado e ter créditos adicionados: ");
                    scanner.nextLine(); // Limpar o buffer
                    matricula = scanner.nextLine();
                    System.out.print("Quantidade de créditos a serem adicionados (2, 4 ou 6): ");
                    int quantidade = scanner.nextInt();
                    fachada.adicionarCreditos(matricula, quantidade);
                    AlunoUniversidade alunoPorMatricula = fachada.recuperarAlunoPorMatricula(matricula);
                    if (alunoPorMatricula != null) {
                        System.out.println("Créditos adicionados ao aluno:\n" + alunoPorMatricula);
                    } else {
                        System.out.println("Nenhum aluno encontrado com essa matrícula.");
                    }
                    break;
                case 6:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
        }

        scanner.close();
    }
}




