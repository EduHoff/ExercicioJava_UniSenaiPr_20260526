package exercises;

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

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercicío 2 ---");

    }
}