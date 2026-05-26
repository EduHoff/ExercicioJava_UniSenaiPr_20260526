package exercises;

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

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercicío 1 ---");

    }
}