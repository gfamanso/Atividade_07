import java.math.BigDecimal;

public class Pedido {
    private BigDecimal valorTotal;
    private String cepDestino;
    private EstrategiaFrete estrategiaFrete;

    public Pedido(BigDecimal valorTotal, String cepDestino, EstrategiaFrete estrategiaFrete) {
        this.valorTotal = valorTotal;
        this.cepDestino = validarCep(cepDestino);
        this.estrategiaFrete = estrategiaFrete;
    }

    // Método para permitir a troca da estratégia
    public void setEstrategiaFrete(EstrategiaFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getCepDestino() {
        return cepDestino;
    }
    
    // Método que usa a estratégia atual para calcular o frete
    public BigDecimal calcularFrete() {
        return estrategiaFrete.calcular(this);
    }

    private String validarCep(String cep) {
        // Simulação de validação. Um CEP válido tem 8 dígitos.
        if (cep == null || cep.length() != 8) {
            throw new CepInvalidoException("CEP " + cep + " inválido. O CEP deve ter 8 dígitos.");
        }
        return cep;
    }
}