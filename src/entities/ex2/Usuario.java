package entities.ex2;

abstract public class Usuario {
    private String codigo_unico;
    private String nome_completo;

    public Usuario(String codigo_unico, String nome_completo) {
        this.codigo_unico = codigo_unico;
        this.nome_completo = nome_completo;
    }

    public String getCodigo_unico() {
        return codigo_unico;
    }

    public void setCodigo_unico(String codigo_unico) {
        this.codigo_unico = codigo_unico;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }
}