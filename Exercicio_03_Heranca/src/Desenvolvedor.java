import java.math.BigDecimal;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, BigDecimal salario) {
        // Chamando o construtor da classe pai (Funcionario)
        super(nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        // Bônus de 10% (0.10)
        BigDecimal bonus = this.salario.multiply(new BigDecimal("0.10"));
        return bonus;
    }
}