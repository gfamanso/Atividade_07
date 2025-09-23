public class Carro implements IMeioTransporte {
    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 120;

    @Override
    public void acelerar() {
        if (velocidadeAtual < VELOCIDADE_MAXIMA) {
            velocidadeAtual += 10;
            System.out.println("Carro acelerando. Velocidade atual: " + velocidadeAtual + " km/h.");
        } else {
            throw new IllegalStateException("O carro já está na velocidade máxima.");
        }
    }

    @Override
    public void frear() {
        if (velocidadeAtual > 0) {
            velocidadeAtual -= 10;
            System.out.println("Carro freando. Velocidade atual: " + velocidadeAtual + " km/h.");
        } else {
            System.out.println("O carro já está parado.");
        }
    }
}