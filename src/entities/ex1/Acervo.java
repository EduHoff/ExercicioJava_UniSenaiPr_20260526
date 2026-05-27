package entities.ex1;

import java.util.ArrayList;

public class Acervo {

    private ArrayList<Livro> acervo = new ArrayList<>();

    public void addLivro(Livro livro){
        acervo.add(livro);
    }

    public void removeLivro(String codigo){

    }

}
