import java.math.BigDecimal;

public class Pac implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Simulação: frete por PAC custa R$15,00
        System.out.println("Calculando frete via PAC...");
        return new BigDecimal("15.00");
    }
} 