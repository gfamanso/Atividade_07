import java.math.BigDecimal;

public class Pix extends FormaPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() {
        // Simulação de validação. Chave Pix não pode ser nula ou vazia.
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new PagamentoInvalidoException("Chave Pix inválida.");
        }
        System.out.println("Chave Pix validada com sucesso.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Processando pagamento via Pix no valor de R$" + valor);
        exibirRecibo(valor);
    }
}