package siga;

public class DescontoIsBolsista implements Desconto{
    private static final double PORCENTAGEM = 0.5;

    @Override
    public double calcular(double valorBase){
        return valorBase * PORCENTAGEM;
    }
}
