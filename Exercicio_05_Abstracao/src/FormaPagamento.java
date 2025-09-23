import java.math.BigDecimal;

public abstract class FormaPagamento {

    public abstract void validarPagamento();
    public abstract void processarPagamento(BigDecimal valor);

    // Método concreto (não abstrato) para mostrar um conceito
    public void exibirRecibo(BigDecimal valor) {
        System.out.println("Recibo gerado. Valor: R$" + valor);
    }
}