public class Funcionario implements Identificavel<String> {
    private final String id;
    private String nome;

    public Funcionario(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}