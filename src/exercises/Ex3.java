package exercises;

import entities.ex1.*;
import entities.ex2.*;
import entities.ex3.*;
import utils.ConsoleUtils;
import java.util.Scanner;

/* 
Exercício 3:
Olá novamente!
Aqui é a Marina Silva, bibliotecária responsável pela Biblioteca Municipal da
Cidade. Estou muito satisfeita com os sistemas que vocês desenvolveram para o
gerenciamento do nosso acervo e do cadastro de usuários. Isso tem facilitado
bastante a nossa rotina!
Agora, temos mais um desafio: queremos um sistema para controlar os
empréstimos de livros. Atualmente, anotamos os empréstimos em fichas de papel,
o que torna difícil acompanhar quais livros foram retirados, por quem e quando
devem ser devolvidos. Além disso, sem um sistema adequado, corremos o risco de
emprestar o mesmo livro para várias pessoas ao mesmo tempo ou perder o controle
de devoluções atrasadas.
Queremos que vocês desenvolvam um sistema eficiente para o controle de
empréstimos, garantindo que possamos registrar corretamente quem pegou cada
livro, quando deve devolvê-lo e se há pendências.
Vou explicar exatamente como o processo funciona para que vocês possam
implementar a melhor solução.
Regras de Empréstimo de Livros
Na biblioteca, um usuário pode pegar emprestado apenas livros físicos, pois os e-
books e audiobooks já estão disponíveis digitalmente. O sistema precisa controlar
o status dos livros físicos para evitar que o mesmo exemplar seja emprestado a
mais de uma pessoa ao mesmo tempo.
Critérios para realizar um empréstimo:
✔Apenas alunos e professores cadastrados podem pegar livros emprestados.
✔Cada livro físico pode ser emprestado para apenas um usuário por vez.
✔O
usuário
pode
retirar
no
máximo
3
livros
ao
mesmo
tempo.
✔ O prazo de devolução varia conforme o tipo de usuário:
Alunos: até 7 dias para devolver.
Professores:
até
15
dias
para
devolver.
✔ Caso o usuário tenha um livro em atraso, ele não pode pegar outro até
regularizar a devolução.
Funcionamento do Sistema de Empréstimo
Nosso sistema precisa permitir que os funcionários da biblioteca realizem as
seguintes operações:
1. Realizar um empréstimo
o
o
Para emprestar um livro, o sistema deve verificar:
Se o usuário está cadastrado.
Se o usuário não tem empréstimos atrasados.
Se o usuário não ultrapassou o limite de 3 livros emprestados.
Se o livro está disponível (ou seja, não foi emprestado para
outra pessoa).
Caso todas as condições sejam atendidas, o sistema deve registrar:
Código único do livro emprestado.
Código único do usuário que pegou o livro.
Data do empréstimo.
Data prevista para devolução (7 dias para alunos, 15 dias para
professores).
Status do empréstimo (ativo ou finalizado).
2. Registrar a devolução de um livro
o
Para registrar a devolução, o sistema deve receber:

Código único do livro que está sendo devolvido.
oO sistema deve atualizar o status do empréstimo para finalizado e
tornar o livro disponível para novos empréstimos.
oSe o livro for devolvido após o prazo, o sistema deve indicar que houve
atraso na devolução.
3. Listar os empréstimos ativos
o
O sistema deve permitir que os funcionários vejam todos os
empréstimos que ainda não foram finalizados, incluindo:
Código do livro emprestado
Título do livro
Nome do usuário que pegou o livro
Data do empréstimo
Data prevista para devolução
Indicação se está dentro do prazo ou em atraso
4. Consultar o histórico de empréstimos de um usuário
o
O sistema deve permitir a consulta de todos os livros que um
determinado usuário já pegou emprestado, mostrando se ele tem
pendências ou se sempre devolveu dentro do prazo.
Regras Importantes
Cada livro deve estar disponível para novos empréstimos apenas após sua
devolução registrada no sistema.
Se um usuário atrasar a devolução de um livro, ele não poderá pegar outro
até regularizar a situação.
O sistema não pode permitir empréstimos acima do limite permitido por
usuário (3 livros simultâneos).
*/

public class Ex3 implements Exercise {

    private Acervo acervo = new Acervo();
    private CadastroUsuarios cadastro = new CadastroUsuarios();
    private ControleEmprestimos controle = new ControleEmprestimos();

    public Ex3() {
        acervo.addLivro(new LivroFisico("101", "Clean Code", "Robert C. Martin", 464, 3));
        acervo.addLivro(new LivroFisico("102", "Rust in Action", "Tim McNamara", 450, 5));
        acervo.addLivro(new Ebook("201", "Digital Book", "Author X", 120, "http://download.com"));
        
        cadastro.addUsuario(new Aluno("A1", "Eduardo Silva", 20, "Engenharia de Software", "202511"));
        cadastro.addUsuario(new Professor("P1", "Gerson Santos", "Compiladores", "TI", "gerson@unisenai.edu"));
    }

    @Override
    public void run(Scanner sc) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.print("""
            ================================================
                    SISTEMA DE EMPRÉSTIMOS (EX 3)
            ================================================
            1 - Realizar Empréstimo
            2 - Registrar Devolução
            3 - Listar Empréstimos Ativos
            4 - Consultar Histórico de Usuário
            0 - Voltar ao Menu Principal
            ================================================
            Escolha uma opção:\s""");

            try {
                opcao = sc.nextInt();
                sc.nextLine();
                ConsoleUtils.clear();

                switch (opcao) {
                    case 1 -> efetuarEmprestimo(sc);
                    case 2 -> efetuarDevolucao(sc);
                    case 3 -> listarAtivos();
                    case 4 -> consultarHistorico(sc);
                    case 0 -> System.out.println("Retornando...\n");
                    default -> System.out.println("Opção inválida!\n");
                }
            } catch (Exception e) {
                System.out.println("Erro na entrada de dados. Tente novamente.\n");
                sc.nextLine();
            }
        }
    }

    private void efetuarEmprestimo(Scanner sc) {
        System.out.print("Digite o código único do Usuário: ");
        String codUsuario = sc.nextLine();

        Usuario usuario = null;
        for (Usuario u : cadastro.getUsuarios()) {
            if (u.getCodigo_unico().equals(codUsuario)) {
                usuario = u;
                break;
            }
        }
        if (usuario == null) {
            System.out.println("\n[ERRO] Usuário não encontrado no sistema!\n");
            return;
        }

        if (controle.usuarioTemAtraso(codUsuario)) {
            System.out.println("\n[ERRO] Empréstimo Negado! O usuário possui pendências por atraso.\n");
            return;
        }

        if (controle.contarLivrosAtivosUsuario(codUsuario) >= 3) {
            System.out.println("\n[ERRO] Empréstimo Negado! Usuário já atingiu o limite de 3 livros simultâneos.\n");
            return;
        }

        System.out.print("Digite o código único do Livro Físico: ");
        String codLivro = sc.nextLine();

        Livro livroAlvo = null;
        for (Livro l : acervo.getLivros()) {
            if (l.getCodigo_unico().equals(codLivro)) {
                livroAlvo = l;
                break;
            }
        }
        if (livroAlvo == null) {
            System.out.println("\n[ERRO] Livro não encontrado no acervo!\n");
            return;
        }
        if (!(livroAlvo instanceof LivroFisico)) {
            System.out.println("\n[ERRO] Apenas livros FÍSICOS podem ser pegos por empréstimo!\n");
            return;
        }

        if (controle.livroEstaEmprestado(codLivro)) {
            System.out.println("\n[ERRO] Este livro já está emprestado para outra pessoa no momento.\n");
            return;
        }

        controle.registrarEmprestimo((LivroFisico) livroAlvo, usuario);
        System.out.println("\nEmpréstimo realizado com sucesso!");
        System.out.printf("Prazo de devolução: %d dias.\n\n", (usuario instanceof Aluno) ? 7 : 15);
    }

    private void efetuarDevolucao(Scanner sc) {
        System.out.print("Digite o código único do livro sendo devolvido: ");
        String codLivro = sc.nextLine();

        if (controle.registrarDevolucao(codLivro)) {
            System.out.println("\nDevolução registrada com sucesso!\n");
        } else {
            System.out.println("\n[ERRO] Não foi encontrado nenhum empréstimo ativo para o código de livro informado.\n");
        }
    }

    private void listarAtivos() {
        System.out.println("================================================");
        System.out.println("               EMPRÉSTIMOS ATIVOS               ");
        System.out.println("================================================");

        boolean temAtivo = false;
        for (Emprestimo e : controle.getEmprestimos()) {
            if (e.isAtivo()) {
                System.out.printf("Livro: [%s] %s\n", e.getCodigo_livro(), e.getTitulo_livro());
                System.out.printf("Retirado por: %s\n", e.getNome_usuario());
                System.out.printf("Data Empréstimo: %s | Entrega Prevista: %s\n", e.getDataEmprestimoFormatada(), e.getDataPrevistaFormatada());
                System.out.printf("Status: %s\n", e.getStatusFormatado());
                System.out.println("------------------------------------------------");
                temAtivo = true;
            }
        }
        if (!temAtivo) System.out.println("Nenhum empréstimo ativo no momento.\n------------------------------------------------");
        System.out.println();
    }

    private void consultarHistorico(Scanner sc) {
        System.out.print("Digite o código do usuário para consultar o histórico: ");
        String codUsuario = sc.nextLine();

        System.out.println("================================================");
        System.out.println("             HISTÓRICO DE EMPRÉSTIMOS           ");
        System.out.println("================================================");

        boolean encontrouOp = false;
        for (Emprestimo e : controle.getEmprestimos()) {
            if (e.getCodigo_usuario().equals(codUsuario)) {
                System.out.printf("Livro: %s (ID: %s)\n", e.getTitulo_livro(), e.getCodigo_livro());
                System.out.printf("Data Retirada: %s | Data Prevista: %s\n", e.getDataEmprestimoFormatada(), e.getDataPrevistaFormatada());
                System.out.printf("Situação do Registro: %s\n", e.getStatusFormatado());
                System.out.println("------------------------------------------------");
                encontrouOp = true;
            }
        }
        if (!encontrouOp) System.out.println("Nenhum registro encontrado para este usuário.\n------------------------------------------------");
        System.out.println();
    }
}