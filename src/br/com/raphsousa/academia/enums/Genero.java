package br.com.raphsousa.academia.enums;


public enum Genero {
    MASCULINO("masculino"),
    FEMININO("feminino"),
    OUTROS("outros"),;
    private final String genero;

    
    public static Genero getGenero(String nome) {
        Genero retorno = null;
        for (Genero gn : Genero.values()) {
            if (gn.getGenero().equalsIgnoreCase(nome)) {
                retorno = gn;
            }
        }
        return retorno;
    }

    private Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

}
