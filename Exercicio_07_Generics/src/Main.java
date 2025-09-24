import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Testando o repositório com a entidade Produto (ID do tipo Long)
        InMemoryRepository<Produto, Long> repoProdutos = new InMemoryRepository<>();

        System.out.println("--- Testando Repositório de Produtos ---");
        Produto p1 = new Produto(1L, "Mouse");
        Produto p2 = new Produto(2L, "Teclado");

        repoProdutos.salvar(p1);
        repoProdutos.salvar(p2);

        System.out.println("Buscando produto com ID 2: " + repoProdutos.buscarPorId(2L).map(Produto::getNome).orElse("Não encontrado"));

        System.out.println("Lista de todos os produtos:");
        List<Produto> todosProdutos = repoProdutos.listarTodos();
        todosProdutos.forEach(p -> System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome()));
        
        repoProdutos.remover(1L);
        System.out.println("Buscando produto com ID 1: " + repoProdutos.buscarPorId(1L).map(Produto::getNome).orElse("Não encontrado"));

        // Testando o repositório com a entidade Funcionario (ID do tipo String)
        InMemoryRepository<Funcionario, String> repoFuncionarios = new InMemoryRepository<>();

        System.out.println("\n--- Testando Repositório de Funcionários ---");
        Funcionario f1 = new Funcionario("f001", "Ana");
        Funcionario f2 = new Funcionario("f002", "Pedro");

        repoFuncionarios.salvar(f1);
        repoFuncionarios.salvar(f2);
        
        System.out.println("Lista de todos os funcionários:");
        List<Funcionario> todosFuncionarios = repoFuncionarios.listarTodos();
        todosFuncionarios.forEach(f -> System.out.println("ID: " + f.getId() + ", Nome: " + f.getNome()));

        // Testando remoção de ID inexistente
        try {
            System.out.println("\nTentando remover ID inexistente...");
            repoFuncionarios.remover("f999");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}