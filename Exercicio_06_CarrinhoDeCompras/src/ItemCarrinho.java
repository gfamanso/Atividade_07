import java.math.BigDecimal;

public final class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public Dinheiro calcularTotal() {
        BigDecimal totalValor = produto.getPreco().getValor().multiply(new BigDecimal(quantidade));
        return new Dinheiro(totalValor, produto.getPreco().getMoeda());
    }
}