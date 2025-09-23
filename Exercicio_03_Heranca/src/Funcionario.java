import java.math.BigDecimal;

public class Funcionario {
    protected String nome;
    protected BigDecimal salario;

    public Funcionario(String nome, BigDecimal salario) {
        // Validação: garante que o salário não seja negativo.
        if (salario.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O salário não pode ser negativo.");
        }
        this.nome = nome;
        this.salario = salario;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    // Método que será sobrescrito (overridden) nas classes filhas
    public BigDecimal calcularBonus() {
        // Por padrão, um bônus pode ser zero ou um valor genérico.
        return BigDecimal.ZERO;
    }
}