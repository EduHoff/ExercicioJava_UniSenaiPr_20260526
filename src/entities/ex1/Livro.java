package entities.ex1;

abstract public class Livro {
    private String codigo_unico;
    private String titulo;
    private String autor;
    
    public Livro(String codigo_unico, String titulo, String autor) {
        this.codigo_unico = codigo_unico;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getCodigo_unico() {
        return codigo_unico;
    }

    public void setCodigo_unico(String codigo_unico) {
        this.codigo_unico = codigo_unico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
