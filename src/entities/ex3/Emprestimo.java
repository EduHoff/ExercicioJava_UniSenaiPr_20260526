package entities.ex3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private String codigo_livro;
    private String titulo_livro;
    private String codigo_usuario;
    private String nome_usuario;
    private LocalDate data_emprestimo;
    private LocalDate data_devolucao_prevista;
    private boolean ativo;
    private boolean devolvido_com_atraso;

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Emprestimo(String codigo_livro, String titulo_livro, String codigo_usuario, String nome_usuario, LocalDate data_emprestimo, LocalDate data_devolucao_prevista) {
        this.codigo_livro = codigo_livro;
        this.titulo_livro = titulo_livro;
        this.codigo_usuario = codigo_usuario;
        this.nome_usuario = nome_usuario;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao_prevista = data_devolucao_prevista;
        this.ativo = true;
        this.devolvido_com_atraso = false;
    }

    public boolean isEmAtraso() {
        if (!ativo) return devolvido_com_atraso;
        return LocalDate.now().isAfter(data_devolucao_prevista);
    }

    public String getCodigo_livro() { 
        return codigo_livro; 
    }

    public String getTitulo_livro() { 
        return titulo_livro; 
    }

    public String getCodigo_usuario() { 
        return codigo_usuario;
    }

    public String getNome_usuario() { 
        return nome_usuario; 
    }

    public LocalDate getData_emprestimo() { 
        return data_emprestimo; 
    }

    public LocalDate getData_devolucao_prevista() { 
        return data_devolucao_prevista; 
    }

    public boolean isAtivo() { 
        return ativo; 
    }
    
    public void finalizarEmprestimo() {
        if (this.ativo) {
            if (LocalDate.now().isAfter(data_devolucao_prevista)) {
                this.devolvido_com_atraso = true;
            }
            this.ativo = false;
        }
    }

    public String getStatusFormatado() {
        if (!ativo) {
            return devolvido_com_atraso ? "FINALIZADO (DEVOLVIDO COM ATRASO)" : "FINALIZADO (NO PRAZO)";
        }
        return isEmAtraso() ? "ATIVO (EM ATRASO)" : "ATIVO (DENTRO DO PRAZO)";
    }

    public String getDataEmprestimoFormatada() { 
        return data_emprestimo.format(fmt); 
    }

    public String getDataPrevistaFormatada() { 
        return data_devolucao_prevista.format(fmt); 
    }
}