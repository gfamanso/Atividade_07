import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Valor de exemplo do pedido
        BigDecimal valorPedido = new BigDecimal("250.50");
        String meuCep = "12345678";

        // Criação do pedido com a estratégia padrão (Sedex)
        Pedido pedido = new Pedido(valorPedido, meuCep, new Sedex());
        System.out.println("Pedido criado com frete Sedex. Valor total: R$" + pedido.getValorTotal());
        
        BigDecimal frete = pedido.calcularFrete();
        System.out.println("Frete Sedex: R$" + frete);
        
        System.out.println("\n-------------------------------\n");

        // Troca de estratégia em tempo de execução para PAC
        System.out.println("Alterando a estratégia de frete para PAC...");
        pedido.setEstrategiaFrete(new Pac());
        frete = pedido.calcularFrete();
        System.out.println("Novo frete PAC: R$" + frete);

        System.out.println("\n-------------------------------\n");

        // Estratégia com Lambda: Frete grátis para pedidos acima de R$200
        System.out.println("Aplicando uma estratégia promocional via lambda...");
        BigDecimal valorLimite = new BigDecimal("200.00");

        EstrategiaFrete freteGratisLambda = (p) -> {
            if (p.getValorTotal().compareTo(valorLimite) > 0) {
                System.out.println("Promoção: Pedido acima de R$200. Frete grátis!");
                return BigDecimal.ZERO;
            } else {
                // Se não se qualificar, voltamos para a estratégia padrão de PAC
                System.out.println("Pedido não se qualifica para a promoção.");
                return new Pac().calcular(p);
            }
        };

        pedido.setEstrategiaFrete(freteGratisLambda);
        frete = pedido.calcularFrete();
        System.out.println("Frete final com lambda: R$" + frete);
        
        System.out.println("\n-------------------------------\n");

        // Tratando uma exceção para CEP inválido
        System.out.println("Testando com um CEP inválido...");
        try {
            Pedido pedidoInvalido = new Pedido(valorPedido, "123", new Sedex());
        } catch (CepInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
