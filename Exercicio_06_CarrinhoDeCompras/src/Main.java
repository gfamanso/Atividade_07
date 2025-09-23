import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        try {
            // Criação dos objetos imutáveis
            Produto caneca = new Produto("Caneca", new Dinheiro(new BigDecimal("25.00"), Moeda.REAL));
            Produto camiseta = new Produto("Camiseta", new Dinheiro(new BigDecimal("50.00"), Moeda.REAL));

            // Fluxo do carrinho imutável
            Carrinho carrinho1 = new Carrinho();
            System.out.println("Carrinho 1 (vazio). Total: " + carrinho1.calcularTotal());

            Carrinho carrinho2 = carrinho1.adicionarItem(new ItemCarrinho(caneca, 2));
            System.out.println("Carrinho 2 (com 2 canecas). Total: " + carrinho2.calcularTotal());

            Carrinho carrinho3 = carrinho2.adicionarItem(new ItemCarrinho(camiseta, 1));
            System.out.println("Carrinho 3 (com 2 canecas e 1 camiseta). Total: " + carrinho3.calcularTotal());

            // Aplicando cupom e observando a criação de um novo objeto
            Carrinho carrinhoComCupom = carrinho3.aplicarCupom(new BigDecimal("0.20")); // 20%
            System.out.println("Carrinho com cupom de 20%. Total: " + carrinhoComCupom.calcularTotal());

            // Removendo um item
            Carrinho carrinhoFinal = carrinhoComCupom.removerItem(new ItemCarrinho(caneca, 2));
            System.out.println("Carrinho final (removendo 2 canecas). Total: " + carrinhoFinal.calcularTotal());

            // Testando validações
            System.out.println("\n--- Testando validações ---");
            // Testando cupom inválido
            try {
                carrinho3.aplicarCupom(new BigDecimal("0.50"));
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao aplicar cupom: " + e.getMessage());
            }
            // Testando quantidade zero
            try {
                new ItemCarrinho(caneca, 0);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao adicionar item: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
