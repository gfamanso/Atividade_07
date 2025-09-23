public class Trem implements IMeioTransporte {
    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 300;

    @Override
    public void acelerar() {
        if (velocidadeAtual < VELOCIDADE_MAXIMA) {
            velocidadeAtual += 50;
            System.out.println("Trem acelerando. Velocidade atual: " + velocidadeAtual + " km/h.");
        } else {
            throw new IllegalStateException("O trem já está na velocidade máxima.");
        }
    }

    @Override
    public void frear() {
        if (velocidadeAtual > 0) {
            velocidadeAtual -= 50;
            System.out.println("Trem freando. Velocidade atual: " + velocidadeAtual + " km/h.");
        } else {
            System.out.println("O trem já está parado.");
        }
    }
}