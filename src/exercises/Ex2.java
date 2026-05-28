package exercises;

import entities.ex2.*;
import utils.ConsoleUtils;
import java.util.Scanner;

/* 
Exercício 2:
Cadastro de Usuários da Biblioteca
Relato da Cliente
Olá novamente!
Aqui é a Marina Silva, bibliotecária responsável pela Biblioteca Municipal da
Cidade. Primeiro, gostaria de agradecer o sistema de gerenciamento do acervo de
livros. Ele tem nos ajudado muito na organização!
Agora, temos outro desafio: queremos um sistema para cadastrar e gerenciar os
usuários da biblioteca. Atualmente, fazemos esse controle manualmente, o que
torna difícil acompanhar quais leitores estão registrados e quais livros cada um
pode pegar emprestado.
Nossa ideia é criar um cadastro eficiente de alunos e professores que utilizam a
biblioteca, garantindo que possamos armazenar todas as informações necessárias
e acessar os dados de forma rápida e segura.
Vou explicar como nossa biblioteca funciona para que vocês desenvolvam uma
solução adequada.
Sobre os Usuários da Biblioteca
Os usuários da biblioteca podem ser classificados em dois tipos principais:
1. Alunos
oSão estudantes que utilizam a biblioteca para empréstimos e
consultas de livros.
oCada aluno possui um código único de identificação.
oInformações essenciais:
Código único
Nome completo
Idade
Curso matriculado
Número da matrícula
2. Professores
oProfessores também utilizam a biblioteca, geralmente para
pesquisas ou indicação de materiais para os alunos.
oCada professor tem um código único de identificação.
oInformações essenciais:
Código único
Nome completo
Área de atuação
Departamento
E-mail institucional
Funcionalidades Necessárias
Nosso sistema deve permitir que os funcionários realizem as seguintes operações:
1. Cadastro de usuários
oO sistema deve possibilitar o registro de alunos e professores,
armazenando todas as informações relevantes.
oCada usuário deve ter um código único, gerado automaticamente ou
inserido manualmente.
2. Remoção de usuários
oPara remover um usuário do sistema, o código único deve ser
informado.
oA remoção não pode ser feita apenas pelo nome, pois podem existir
usuários com o mesmo nome.
3. Listagem de usuários cadastrados
o
O sistema deve exibir todos os usuários registrados, separando
alunos e professores de maneira clara.
4. Destaque das informações
oO sistema deve exibir os usuários corretamente, mostrando os
atributos específicos de cada tipo.
oPor exemplo, alunos devem ter seu curso e número de matrícula
destacados, enquanto professores devem exibir sua área de atuação
e e-mail institucional.
*/

public class Ex2 implements Exercise {

    private CadastroUsuarios cadastro = new CadastroUsuarios();

    @Override
    public void run(Scanner sc) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.print("""
            ================================================
                     CADASTRO DE USUÁRIOS (EX 2)
            ================================================
            1 - Cadastrar Usuário
            2 - Remover Usuário
            3 - Listar Usuários Cadastrados
            0 - Voltar ao Menu Principal
            ================================================
            Escolha uma opção:\s""");

            try {
                opcao = sc.nextInt();
                sc.nextLine();
                ConsoleUtils.clear();

                switch (opcao) {
                    case 1 -> cadastrarUsuario(sc);
                    case 2 -> removerUsuario(sc);
                    case 3 -> listarUsuarios();
                    case 0 -> System.out.println("Retornando...\n");
                    default -> System.out.println("Opção inválida!\n");
                }
            } catch (Exception e) {
                System.out.println("Erro na entrada de dados. Tente novamente.\n");
                sc.nextLine();
            }
        }
    }

    private void cadastrarUsuario(Scanner sc) {
        System.out.print("""
        Selecione o tipo de usuário:
        1 - Aluno
        2 - Professor
        Escolha:\s""");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Código Único: ");
        String codigo = sc.nextLine();

        if (cadastro.idExiste(codigo)) {
            System.out.println("\n[ERRO] Já existe um usuário cadastrado com este código!\n");
            return;
        }

        System.out.print("Nome Completo: ");
        String nome = sc.nextLine();

        switch (tipo) {
            case 1 -> {
                System.out.print("Idade: ");
                int idade = sc.nextInt();
                sc.nextLine();
                System.out.print("Curso Matriculado: ");
                String curso = sc.nextLine();
                System.out.print("Número da Matrícula: ");
                String matricula = sc.nextLine();

                cadastro.addUsuario(new Aluno(codigo, nome, idade, curso, matricula));
                System.out.println("\nAluno cadastrado com sucesso!\n");
            }
            case 2 -> {
                System.out.print("Área de Atuação: ");
                String area = sc.nextLine();
                System.out.print("Departamento: ");
                String depto = sc.nextLine();
                System.out.print("E-mail Institucional: ");
                String email = sc.nextLine();

                cadastro.addUsuario(new Professor(codigo, nome, area, depto, email));
                System.out.println("\nProfessor cadastrado com sucesso!\n");
            }
            default -> System.out.println("\n[ERRO] Tipo de usuário inválido. Cadastro cancelado.\n");
        }
    }

    private void removerUsuario(Scanner sc) {
        System.out.print("Digite o Código Único do usuário que deseja remover: ");
        String codigo = sc.nextLine();

        if (cadastro.removeUsuario(codigo)) {
            System.out.println("\nUsuário removido com sucesso!\n");
        } else {
            System.out.println("\n[ERRO] Usuário não encontrado com o código fornecido.\n");
        }
    }

    private void listarUsuarios() {
        if (cadastro.getUsuarios().isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.\n");
            return;
        }

        System.out.println("================================================");
        System.out.println("              USUÁRIOS CADASTRADOS              ");
        System.out.println("================================================");

        System.out.println("--- ALUNOS ---");
        boolean temAluno = false;
        for (Usuario u : cadastro.getUsuarios()) {
            if (u instanceof Aluno aluno) {
                System.out.printf("ID: %s | Nome: %s\n", aluno.getCodigo_unico(), aluno.getNome_completo());
                System.out.printf("   Idade: %d | Curso: %s | Matrícula: %s\n", aluno.getIdade(), aluno.getCurso_matriculado(), aluno.getNumero_matricula());
                System.out.println("------------------------------------------------");
                temAluno = true;
            }
        }
        if (!temAluno) System.out.println("Nenhum aluno cadastrado.\n------------------------------------------------");

        System.out.println("\n--- PROFESSORES ---");
        boolean temProfessor = false;
        for (Usuario u : cadastro.getUsuarios()) {
            if (u instanceof Professor prof) {
                System.out.printf("ID: %s | Nome: %s\n", prof.getCodigo_unico(), prof.getNome_completo());
                System.out.printf("   Área: %s | Depto: %s | E-mail: %s\n", prof.getArea_atuacao(), prof.getDepartamento(), prof.getEmail_institucional());
                System.out.println("------------------------------------------------");
                temProfessor = true;
            }
        }
        if (!temProfessor) System.out.println("Nenhum professor cadastrado.\n------------------------------------------------");
        System.out.println();
    }
}