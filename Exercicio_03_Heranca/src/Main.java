import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criando a lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();

        // Adicionando instâncias de Gerente e Desenvolvedor à lista de Funcionario
        funcionarios.add(new Gerente("Lais Vieira", new BigDecimal("12000.00")));
        funcionarios.add(new Desenvolvedor("Gabriel Manso", new BigDecimal("7500.00")));
        funcionarios.add(new Desenvolvedor("Beatriz Costa", new BigDecimal("8000.00")));

        // Exibindo o bônus de cada funcionário
        System.out.println("--- Bônus de Funcionários ---");
        for (Funcionario f : funcionarios) {
            System.out.println("Funcionário: " + f.getNome());
            System.out.println("Salário: R$" + f.getSalario());
            System.out.println("Bônus: R$" + f.calcularBonus());
            System.out.println("-----------------------------");
        }

        // Testando a validação de salário negativo
        try {
            System.out.println("\n--- Tentando criar funcionário com salário negativo ---");
            new Desenvolvedor("Lucas Silva", new BigDecimal("-1000.00"));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}