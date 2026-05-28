package exercises;

import entities.ex1.*;
import utils.ConsoleUtils;
import java.util.Scanner;

/* 
Exercício 1:
Relato da Cliente:
Olá, tudo bem?
Meu nome é Marina Silva e sou a bibliotecária responsável pela Biblioteca
Municipal. Nossa biblioteca está crescendo e precisamos de um sistema interno
para facilitar o gerenciamento do nosso acervo. Atualmente, realizamos o controle
manualmente, mas isso tem causado problemas na organização dos livros,
dificultando o cadastro, remoção e consulta dos títulos disponíveis.
Estamos buscando uma solução que atenda às nossas necessidades e permita um
cadastro eficiente e estruturado, garantindo que cada livro seja identificado
corretamente e possa ser facilmente encontrado ou removido quando necessário.
Vou explicar como nossa biblioteca funciona para que vocês desenvolvam um
sistema adequado.
Organização do Acervo
Nosso acervo conta com diferentes tipos de livros, cada um com suas
particularidades. É importante que o sistema respeite essas diferenças e registre
corretamente as informações de cada tipo.
Os livros podem ser classificados nas seguintes categorias:
1. Livros Físicos
oSão os tradicionais livros impressos que temos nas prateleiras.
oCada livro possui um código único que o identifica dentro do sistema.
oInformações essenciais:
Código único (utilizado para todas as operações)
Título
Autor
Número de páginas
Número da estante (local onde ele está guardado na
biblioteca)
2. E-books
oSão versões digitais dos livros disponíveis na biblioteca.
oAssim como os livros físicos, cada e-book precisa ter um código
único.
oInformações essenciais:
Código único
Título
Autor
Número de páginas
Link de download (para acessar o e-book)
3. Audiobooks
oSão livros em formato de áudio, ideais para quem prefere ouvir as
histórias ou conteúdo.
oComo nos outros casos, cada audiobook tem um código único.
oInformações essenciais:
Código único
Título
Autor
Duração total do áudio (em minutos)
Nome do narrador
Funcionalidades Necessárias
Nosso sistema deve permitir que os funcionários realizem as seguintes operações
em um menu interativo (Use o console):
1. Cadastro de livros
oAo receber um novo livro (físico, e-book ou audiobook), o sistema
deve permitir o seu cadastro. (Use ArrayList)
oO cadastro deve incluir todas as informações essenciais para o tipo
de livro.
oCada livro deve ter um código único, gerado automaticamente ou
inserido manualmente no momento do registro.
2. Remoção de livros
oPara remover um livro do sistema, o código único deve ser informado.
oA remoção não pode ser feita apenas pelo título, pois há casos de
livros com o mesmo nome, mas edições ou formatos diferentes.
3. Listagem de livros cadastrados
oO sistema deve permitir que os funcionários visualizem todos os
livros cadastrados.
oAs informações devem ser organizadas de forma clara, respeitando
as diferenças entre os tipos de livros.
4. Destaque das informações
oAo exibir a lista de livros, é importante que cada tipo de livro seja
apresentado de forma adequada.
oPor exemplo, livros físicos devem mostrar a estante onde estão
guardados, e-books devem exibir o link de download, e audiobooks
devem informar o tempo de duração e o narrador.
*/

public class Ex1 implements Exercise {

    private Acervo acervo = new Acervo();

    @Override
    public void run(Scanner sc) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.print("""
            ================================================
                       GERENCIAMENTO DE ACERVO (EX 1)
            ================================================
            1 - Cadastrar Livro
            2 - Remover Livro
            3 - Listar Livros
            0 - Voltar ao Menu Principal
            ================================================
            Escolha uma opção:\s""");
            
            try {
                opcao = sc.nextInt();
                sc.nextLine();
                ConsoleUtils.clear();

                switch (opcao) {
                    case 1 -> cadastrarLivro(sc);
                    case 2 -> removerLivro(sc);
                    case 3 -> listarLivros();
                    case 0 -> System.out.println("Retornando...\n");
                    default -> System.out.println("Opção inválida!\n");
                }
            } catch (Exception e) {
                System.out.println("Erro na entrada de dados. Tente novamente.\n");
                sc.nextLine();
            }
        }
    }

    private void cadastrarLivro(Scanner sc) {
        System.out.print("""
        Selecione o tipo de livro:
        1 - Livro Físico
        2 - Ebook
        3 - Audiobook
        Escolha:\s""");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Código Único: ");
        String codigo = sc.nextLine();

        if (acervo.idExiste(codigo)) {
            System.out.println("\n[ERRO] Já existe um livro cadastrado com este código!\n");
            return;
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();

        switch (tipo) {
            case 1 -> {
                System.out.print("Número de Páginas: ");
                int paginas = sc.nextInt();
                System.out.print("Número da Estante: ");
                int estante = sc.nextInt();
                sc.nextLine();
                acervo.addLivro(new LivroFisico(codigo, titulo, autor, paginas, estante));
                System.out.println("\nLivro Físico cadastrado com sucesso!\n");
            }
            case 2 -> {
                System.out.print("Número de Páginas: ");
                int paginas = sc.nextInt();
                sc.nextLine();
                System.out.print("Link de Download: ");
                String link = sc.nextLine();
                acervo.addLivro(new Ebook(codigo, titulo, autor, paginas, link));
                System.out.println("\nEbook cadastrado com sucesso!\n");
            }
            case 3 -> {
                System.out.print("Duração Total (em minutos): ");
                double duracao = sc.nextDouble();
                sc.nextLine();
                System.out.print("Nome do Narrador: ");
                String narrador = sc.nextLine();
                acervo.addLivro(new Audiobook(codigo, titulo, autor, duracao, narrador));
                System.out.println("\nAudiobook cadastrado com sucesso!\n");
            }
            default -> System.out.println("\n[ERRO] Tipo de livro inválido. Cadastro cancelado.\n");
        }
    }

    private void removerLivro(Scanner sc) {
        System.out.print("Digite o Código Único do livro que deseja remover: ");
        String codigo = sc.nextLine();

        if (acervo.removeLivro(codigo)) {
            System.out.println("\nLivro removido com sucesso!\n");
        } else {
            System.out.println("\n[ERRO] Livro não encontrado com o código fornecido.\n");
        }
    }

    private void listarLivros() {
        if (acervo.getLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado no acervo.\n");
            return;
        }

        System.out.println("================================================");
        System.out.println("               LIVROS CADASTRADOS               ");
        System.out.println("================================================");
        
        for (Livro l : acervo.getLivros()) {
            System.out.printf("ID: %s | Título: %s | Autor: %s\n", l.getCodigo_unico(), l.getTitulo(), l.getAutor());
            
            if (l instanceof LivroFisico fisico) {
                System.out.printf("   [Físico] Páginas: %d | Estante: %d\n", fisico.getNum_paginas(), fisico.getNum_estante());
            } else if (l instanceof Ebook ebook) {
                System.out.printf("   [Ebook] Páginas: %d | Download: %s\n", ebook.getNum_paginas(), ebook.getLink_download());
            } else if (l instanceof Audiobook audio) {
                System.out.printf("   [Audiobook] Duração: %.1f min | Narrador: %s\n", audio.getDuracao_total_audio_min(), audio.getNome_narrador());
            }
            System.out.println("------------------------------------------------");
        }
        System.out.println();
    }
}