package siga;

import java.util.ArrayList;
import java.util.List;

/**
 * Orquestra os passos da matrícula (validar, gravar) — papel legítimo da fachada.
 * As reações ao fato consumado são delegadas ao PublicadorMatricula: uma nova
 * reação exige apenas uma linha de registro aqui, sem alterar a lógica central.
 */
public class FachadaMatricula {

    private final List<Matricula> armazem = new ArrayList<>();
    private final PublicadorMatricula publicador = new PublicadorMatricula();

    public FachadaMatricula() {
        publicador.registrar(new NotificadorEmail());
        publicador.registrar(new PainelVagas());
        publicador.registrar(new AvisoCoordenacao());
        publicador.registrar(new RegistroAuditoria());
    }

    public void registrarOuvinte(OuvinteMatricula ouvinte) {
        publicador.registrar(ouvinte);
    }

    public Matricula matricular(Aluno aluno, String codigoTurma) {
        Matricula nova = new Matricula(codigoTurma, aluno.getNome());
        armazem.add(nova);
        publicador.publicar(nova);
        return nova;
    }

    public List<Matricula> listar() {
        return new ArrayList<>(armazem);
    }
}