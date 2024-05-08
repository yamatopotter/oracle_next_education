package br.com.alura.aluramusic.model;

public enum TipoArtista {
    SOLO("Solo"),
    DUPLA("Dupla"),
    BANDA("Banda");

    private String tipoArtista;

    TipoArtista(String tipoArtista){
        this.tipoArtista = tipoArtista;
    }

    public static TipoArtista fromString(String text) {
        for (TipoArtista tipoArtista : TipoArtista.values()) {
            if (tipoArtista.tipoArtista.equalsIgnoreCase(text)) {
                return tipoArtista;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
