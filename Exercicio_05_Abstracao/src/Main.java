import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FormaPagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new CartaoCredito("1234567890123456")); // Válido
        pagamentos.add(new Boleto("123456789012345678901234567890123456789012345678")); // Válido
        pagamentos.add(new Pix("minhachave@email.com")); // Válido

        BigDecimal valorCompra = new BigDecimal("150.75");

        // Testando pagamentos válidos
        System.out.println("--- Testando pagamentos válidos ---");
        for (FormaPagamento forma : pagamentos) {
            try {
                forma.processarPagamento(valorCompra);
                System.out.println("----------------------------------------");
            } catch (PagamentoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        
        System.out.println("\n--- Testando pagamentos inválidos ---");
        // Testando pagamentos inválidos
        try {
            FormaPagamento cartaoInvalido = new CartaoCredito("12345");
            cartaoInvalido.processarPagamento(valorCompra);
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        try {
            FormaPagamento pixInvalido = new Pix(null);
            pixInvalido.processarPagamento(valorCompra);
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}