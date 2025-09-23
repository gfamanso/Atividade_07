public class Main {
    public static void main(String[] args) {
        // Cenário 1: Criando uma instância válida e exibindo os dados
        try {
            Produto p1 = new Produto("Notebook", 3500.00, 10);
            System.out.println("--- Produto criado com sucesso ---");
            System.out.println("Nome: " + p1.getNome());
            System.out.println("Preço: " + p1.getPreco());
            System.out.println("Quantidade em estoque: " + p1.getQuantidadeEmEstoque());

            System.out.println("\n----------------------------------\n");

            // Cenário 2: Alterando valores válidos
            System.out.println("--- Alterando valores válidos ---");
            p1.setPreco(3200.50);
            p1.setQuantidadeEmEstoque(8);
            System.out.println("Novo preço: " + p1.getPreco());
            System.out.println("Nova quantidade: " + p1.getQuantidadeEmEstoque());

            System.out.println("\n----------------------------------\n");

            // Cenário 3: Tentando atribuições inválidas
            System.out.println("--- Tentando atribuições inválidas ---");

            // Tentando definir um preço negativo
            System.out.println("Tentando definir preço como -100...");
            p1.setPreco(-100.00); // Esta linha vai lançar uma exceção e o código para aqui
            System.out.println("Este texto não será exibido.");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Outro exemplo de tentativa inválida de criação
        try {
            System.out.println("\n--- Tentando criar um produto com nome nulo ---");
            Produto p2 = new Produto(null, 100.00, 5); // Exceção será lançada no construtor
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        // CÓDIGO DO EXERCÍCIO 2: Teste do método aplicarDesconto()
        try {
            Produto p1 = new Produto("Mouse Gamer", 250.00, 50);
            System.out.println("--- Aplicando Desconto Válido ---");
            System.out.println("Preço original: R$" + p1.getPreco());

            p1.aplicarDesconto(10.0); // Aplica 10% de desconto
            System.out.println("Preço com 10% de desconto: R$" + p1.getPreco());

            System.out.println("\n----------------------------------\n");

            // Cenário 2: Tentando aplicar um desconto inválido
            System.out.println("--- Tentando aplicar um Desconto Inválido ---");
            System.out.println("Preço atual: R$" + p1.getPreco());
            System.out.println("Tentando aplicar 60% de desconto...");

            p1.aplicarDesconto(60.0); // Essa linha vai lançar a exceção
            System.out.println("Este texto não será exibido.");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}