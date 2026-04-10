package Repository;

import Model.Solicitacao;

public interface ISolicitacaoRepository {
    void salvar(Solicitacao solicitacao);

    Solicitacao buscar(String protocolo);
}
