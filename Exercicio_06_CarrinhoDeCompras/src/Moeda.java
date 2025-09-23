public enum Moeda {
    REAL("R$"),
    DOLAR("$"),
    EURO("€");

    private final String simbolo;

    Moeda(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}