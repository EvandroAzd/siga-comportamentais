package siga;

public class DescontoIsServidor implements Desconto {
    private static final double PORCENTAGEM = 0.8;

    @Override
    public double calcular(double valorBase){
        return valorBase * PORCENTAGEM;
    }
}
