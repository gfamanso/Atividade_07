import java.math.BigDecimal;

public class RetiradaNaLoja implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Frete para retirada na loja é sempre grátis
        System.out.println("Retirada na loja: frete grátis.");
        return BigDecimal.ZERO;
    }
}