package entities.ex1;

public class Audiobook extends Livro {
    private double duracao_total_audio_min;
    private String nome_narrador;

    public Audiobook(String codigo_unico, String titulo, String autor, double duracao_total_audio_min, String nome_narrador) {
        super(codigo_unico, titulo, autor);
        this.duracao_total_audio_min = duracao_total_audio_min;
        this.nome_narrador = nome_narrador;
    }

    public double getDuracao_total_audio_min() {
        return duracao_total_audio_min;
    }

    public void setDuracao_total_audio_min(double duracao_total_audio_min) {
        this.duracao_total_audio_min = duracao_total_audio_min;
    }

    public String getNome_narrador() {
        return nome_narrador;
    }

    public void setNome_narrador(String nome_narrador) {
        this.nome_narrador = nome_narrador;
    }
}
