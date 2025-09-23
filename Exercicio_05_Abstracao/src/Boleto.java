import java.math.BigDecimal;

public class Boleto extends FormaPagamento {
    private String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() {
        // Simulação de validação. O código de barras de um boleto tem 48 dígitos.
        if (codigoBarras == null || codigoBarras.length() != 48) {
            throw new PagamentoInvalidoException("Código de barras do boleto inválido.");
        }
        System.out.println("Boleto validado com sucesso.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Processando pagamento via Boleto no valor de R$" + valor);
        exibirRecibo(valor);
    }
}