import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<IMeioTransporte> veiculos = new ArrayList<>();
        veiculos.add(new Carro());
        veiculos.add(new Bicicleta());
        veiculos.add(new Trem());

        System.out.println("--- Acelerando todos os veículos ---");
        for (IMeioTransporte veiculo : veiculos) {
            veiculo.acelerar();
            veiculo.acelerar();
        }

        System.out.println("\n--- Freando todos os veículos ---");
        for (IMeioTransporte veiculo : veiculos) {
            veiculo.frear();
            veiculo.frear();
        }

        System.out.println("\n--- Tentando operação inválida (acelerar além do limite) ---");
        try {
            IMeioTransporte bicicleta = new Bicicleta();
            for (int i = 0; i < 10; i++) {
                bicicleta.acelerar();
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}