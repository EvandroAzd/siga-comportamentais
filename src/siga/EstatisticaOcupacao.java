package siga;

/** Etapa 5: quinta reação adicionada sem alterar FachadaMatricula. */
public class EstatisticaOcupacao implements OuvinteMatricula {

    private int totalMatriculas = 0;

    @Override
    public void aoMatricular(Matricula matricula) {
        totalMatriculas++;
        System.out.println("   [estatistica] total de matriculas registradas: " + totalMatriculas);
    }
}