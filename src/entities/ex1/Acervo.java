package entities.ex1;

import java.util.ArrayList;

public class Acervo {

    private ArrayList<Livro> acervo = new ArrayList<>();

    public void addLivro(Livro livro) {
        acervo.add(livro);
    }

    public boolean removeLivro(String codigo) {
        return acervo.removeIf(livro -> livro.getCodigo_unico().equals(codigo));
    }

    public ArrayList<Livro> getLivros() {
        return acervo;
    }

    public boolean idExiste(String codigo) {
        for (Livro livro : acervo) {
            if (livro.getCodigo_unico().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
}