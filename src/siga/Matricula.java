package siga;

/**
 * DESLIZE 1 (parte A) — a cadeia de condicionais de desconto, a mesma
 * situação-problema da Aula 3. Cada nova política obriga a alterar e
 * retestar esta classe, que já funcionava.
 */
public class Matricula {

    //resolvendo problema de acoplamento entre Matricula e Aluno
    /*private final Aluno aluno;*/
    private final String codigoTurma;
    private String codigoMatricula;
    private Desconto desconto;

    public Matricula(String codigoTurma, String codigoMatricula) {
        this.codigoTurma = codigoTurma;
        this.codigoMatricula = codigoMatricula;
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setDesconto(Desconto desconto) {
        this.desconto = desconto;
    }

    public double calcularDesconto(double valorBase) {
        return desconto.calcular(valorBase);
       /* if (aluno.isBolsista()) {
            return valorBase * 0.50;
        } else if (aluno.isServidor()) {
            return valorBase * 0.80;
        } else if (aluno.isEgresso()) {
            return valorBase * 0.90;
        }
        return valorBase;*/
    }

    @Override
    public String toString() {
        return codigoMatricula + " pertence a turma " + codigoTurma;
    }
}
