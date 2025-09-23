import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento {
    private String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void validarPagamento() {
        // Simulação de validação. Um cartão válido deve ter 16 dígitos.
        if (numeroCartao == null || numeroCartao.length() != 16) {
            throw new PagamentoInvalidoException("Número do cartão de crédito inválido.");
        }
        System.out.println("Cartão de crédito validado com sucesso.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Processando pagamento via Cartão de Crédito no valor de R$" + valor);
        exibirRecibo(valor);
    }
}