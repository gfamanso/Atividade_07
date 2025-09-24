import java.math.BigDecimal;

public class Sedex implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Simulação: frete por Sedex custa R$25,00
        System.out.println("Calculando frete via Sedex...");
        return new BigDecimal("25.00");
    }
} 
