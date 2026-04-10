package Repository;

import Model.Solicitacao;
import java.util.HashMap;
import java.util.Map;

public class SolicitacaoRepository implements ISolicitacaoRepository {
    private final Map<String, Solicitacao> bancoDeDados = new HashMap<>();

    public void salvar(Solicitacao s) {
        bancoDeDados.put(s.getProtocolo(), s);
    }

    public Solicitacao buscar(String protocolo) {
        return bancoDeDados.get(protocolo.toUpperCase());
    }
}