package siga;

import java.util.ArrayList;
import java.util.List;

public class PublicadorMatricula {
    private final List<OuvinteMatricula> ouvintes = new ArrayList<>();

    public void registrar(OuvinteMatricula ouvinteMatricula) {
        ouvintes.add(ouvinteMatricula);
    }

    public void remover(OuvinteMatricula ouvinteMatricula) {
        ouvintes.remove(ouvinteMatricula);
    }

    public void publicar(Matricula matricula) {
        for (OuvinteMatricula o : new ArrayList<>(ouvintes)) {
            try {
                o.aoMatricular(matricula);
            } catch (Exception e) {
                System.out.println("   [aviso] ouvinte falhou: " + e.getMessage());
            }
        }
    }
}
