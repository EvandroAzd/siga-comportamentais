package siga;

public class SemDeconto implements Desconto{
    @Override
    public double calcular(double valorBase) {
        return valorBase;
    }
}
