package entities.ex1;

public class Ebook extends Livro {
    private int num_paginas;
    private String link_download;

    public Ebook(String codigo_unico, String titulo, String autor, int num_paginas, String link_download) {
        super(codigo_unico, titulo, autor);
        this.num_paginas = num_paginas;
        this.link_download = link_download;
    }

    public int getNum_paginas() {
        return num_paginas;
    }

    public void setNum_paginas(int num_paginas) {
        this.num_paginas = num_paginas;
    }

    public String getLink_download() {
        return link_download;
    }

    public void setLink_download(String link_download) {
        this.link_download = link_download;
    }
}
