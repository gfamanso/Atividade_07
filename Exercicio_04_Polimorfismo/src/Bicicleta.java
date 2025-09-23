public class Bicicleta implements IMeioTransporte {
    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 30;

    @Override
    public void acelerar() {
        if (velocidadeAtual < VELOCIDADE_MAXIMA) {
            velocidadeAtual += 5;
            System.out.println("Bicicleta acelerando. Velocidade atual: " + velocidadeAtual + " km/h.");
        } else {
            throw new IllegalStateException("A bicicleta já está na velocidade máxima.");
        }
    }

    @Override
    public void frear() {
        if (velocidadeAtual > 0) {
            velocidadeAtual -= 5;
            System.out.println("Bicicleta freando. Velocidade atual: " + velocidadeAtual + " km/h.");
        } else {
            System.out.println("A bicicleta já está parada.");
        }
    }
}