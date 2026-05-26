package entities.ex1;

public class LivroFisico extends Livro {
    private int num_paginas;
    private int num_estante;
    
    public LivroFisico(String codigo_unico, String titulo, String autor, int num_paginas, int num_estante) {
        super(codigo_unico, titulo, autor);
        this.num_paginas = num_paginas;
        this.num_estante = num_estante;
    }

    public int getNum_paginas() {
        return num_paginas;
    }

    public void setNum_paginas(int num_paginas) {
        this.num_paginas = num_paginas;
    }

    public int getNum_estante() {
        return num_estante;
    }

    public void setNum_estante(int num_estante) {
        this.num_estante = num_estante;
    }
}
