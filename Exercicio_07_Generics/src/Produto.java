public class Produto implements Identificavel<Long> {
    private final Long id;
    private String nome;

    public Produto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}