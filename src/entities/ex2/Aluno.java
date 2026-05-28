package entities.ex2;

public class Aluno extends Usuario {
    private int idade;
    private String curso_matriculado;
    private String numero_matricula;

    public Aluno(String codigo_unico, String nome_completo, int idade, String curso_matriculado, String numero_matricula) {
        super(codigo_unico, nome_completo);
        this.idade = idade;
        this.curso_matriculado = curso_matriculado;
        this.numero_matricula = numero_matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCurso_matriculado() {
        return curso_matriculado;
    }

    public void setCurso_matriculado(String curso_matriculado) {
        this.curso_matriculado = curso_matriculado;
    }

    public String getNumero_matricula() {
        return numero_matricula;
    }

    public void setNumero_matricula(String numero_matricula) {
        this.numero_matricula = numero_matricula;
    }
}