package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 12: Strategy e Observer ===");

        // --- Strategy ---
        System.out.println("\n1) Strategy: cada politica de desconto em um unico lugar");

        Matricula matricula = new Matricula("DSM-3", "34234DFEF34");
        Aluno aluno = new Aluno(matricula, "Evandro Azevedo");
        matricula.setDesconto(new DescontoIsBolsista());
        System.out.printf("   %-16s matricula: R$ %.2f%n",
                aluno.getNome(), matricula.calcularDesconto(600));

        Matricula matricula2 = new Matricula("DSM-3", "2112HJHJ3123");
        Aluno aluno2 = new Aluno(matricula2, "Maria Luiza");
        matricula2.setDesconto(new DescontoIsServidor());
        System.out.printf("   %-16s matricula: R$ %.2f%n",
                aluno2.getNome(), matricula2.calcularDesconto(600));

        // --- Observer ---
        System.out.println("\n2) Observer: reacoes desacopladas da fachada");

        FachadaMatricula fachada = new FachadaMatricula();
        System.out.println("   Matriculando Evandro (AvisoCoordenacao vai falhar, auditoria continua):");
        fachada.matricular(aluno, "DSM-3");

        // Etapa 5: quinta reacao sem alterar FachadaMatricula
        System.out.println("\n3) Etapa 5: adicionando EstatisticaOcupacao sem tocar na fachada");
        fachada.registrarOuvinte(new EstatisticaOcupacao());
        fachada.matricular(aluno2, "DSM-3");
    }
}