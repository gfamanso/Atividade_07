import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal percentualCupom;
    private static final BigDecimal CUPOM_MAXIMO = new BigDecimal("0.30"); // 30%

    public Carrinho() {
        this(new ArrayList<>(), BigDecimal.ZERO);
    }

    private Carrinho(List<ItemCarrinho> itens, BigDecimal percentualCupom) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.percentualCupom = percentualCupom;
    }

    public Carrinho adicionarItem(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.add(item);
        return new Carrinho(novaLista, this.percentualCupom);
    }

    public Carrinho removerItem(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.remove(item);
        return new Carrinho(novaLista, this.percentualCupom);
    }

    public Carrinho aplicarCupom(BigDecimal porcentagem) {
        if (porcentagem.compareTo(BigDecimal.ZERO) < 0 || porcentagem.compareTo(CUPOM_MAXIMO) > 0) {
            throw new IllegalArgumentException("O cupom deve estar entre 0% e 30%.");
        }
        return new Carrinho(this.itens, porcentagem);
    }

    public Dinheiro calcularTotal() {
        BigDecimal subtotal = itens.stream()
                .map(item -> item.calcularTotal().getValor())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal desconto = subtotal.multiply(this.percentualCupom);
        BigDecimal totalComDesconto = subtotal.subtract(desconto)
                                            .setScale(2, RoundingMode.HALF_EVEN);
        
        return new Dinheiro(totalComDesconto, Moeda.REAL);
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }
}