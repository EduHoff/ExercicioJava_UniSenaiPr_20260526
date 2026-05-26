package exercises;

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

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercicío 3 ---");

    }
}