package entities.ex3;

import entities.ex1.*;
import entities.ex2.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControleEmprestimos {
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public boolean livroEstaEmprestado(String codigo_livro) {
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getCodigo_livro().equals(codigo_livro)) {
                return true;
            }
        }
        return false;
    }

    public int contarLivrosAtivosUsuario(String codigo_usuario) {
        int cont = 0;
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getCodigo_usuario().equals(codigo_usuario)) {
                cont++;
            }
        }
        return cont;
    }

    public boolean usuarioTemAtraso(String codigo_usuario) {
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getCodigo_usuario().equals(codigo_usuario) && e.isEmAtraso()) {
                return true;
            }
        }
        return false;
    }

    public void registrarEmprestimo(LivroFisico livro, Usuario usuario) {
        LocalDate hoje = LocalDate.now();
        int diasPrazo = (usuario instanceof Aluno) ? 7 : 15;
        LocalDate prazo = hoje.plusDays(diasPrazo);

        Emprestimo novo = new Emprestimo(
            livro.getCodigo_unico(),
            livro.getTitulo(),
            usuario.getCodigo_unico(),
            usuario.getNome_completo(),
            hoje,
            prazo
        );
        emprestimos.add(novo);
    }

    public boolean registrarDevolucao(String codigo_livro) {
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getCodigo_livro().equals(codigo_livro)) {
                e.finalizarEmprestimo();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}