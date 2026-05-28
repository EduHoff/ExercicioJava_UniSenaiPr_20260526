package entities.ex2;

public class Professor extends Usuario {
    private String area_atuacao;
    private String departamento;
    private String email_institucional;

    public Professor(String codigo_unico, String nome_completo, String area_atuacao, String departamento, String email_institucional) {
        super(codigo_unico, nome_completo);
        this.area_atuacao = area_atuacao;
        this.departamento = departamento;
        this.email_institucional = email_institucional;
    }

    public String getArea_atuacao() {
        return area_atuacao;
    }

    public void setArea_atuacao(String area_atuacao) {
        this.area_atuacao = area_atuacao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEmail_institucional() {
        return email_institucional;
    }

    public void setEmail_institucional(String email_institucional) {
        this.email_institucional = email_institucional;
    }
}