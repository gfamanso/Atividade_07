import java.math.BigDecimal;

public class Gerente extends Funcionario {

    public Gerente(String nome, BigDecimal salario) {
        // Chamando o construtor da classe pai (Funcionario)
        super(nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        // Bônus de 20% (0.20)
        BigDecimal bonus = this.salario.multiply(new BigDecimal("0.20"));
        return bonus;
    }
}
