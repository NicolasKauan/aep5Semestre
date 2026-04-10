package Service;

import Model.RegistroSolicitacaoInput;
import Model.Solicitacao;
import Repository.ISolicitacaoRepository;
import java.util.Optional;

public class SolicitacaoService {
    private final ISolicitacaoRepository repository;
    private final ICalculadoraPrioridade calculadoraPrioridade;
    private final IGeradorProtocolo geradorProtocolo;

    public SolicitacaoService(
            ISolicitacaoRepository repository,
            ICalculadoraPrioridade calculadoraPrioridade,
            IGeradorProtocolo geradorProtocolo) {
        this.repository = repository;
        this.calculadoraPrioridade = calculadoraPrioridade;
        this.geradorProtocolo = geradorProtocolo;
    }

    public Optional<Solicitacao> registrar(RegistroSolicitacaoInput input) {
        ResultadoPrioridade resultado = calculadoraPrioridade.calcular(input.pontosTotal());
        String protocolo = geradorProtocolo.gerar();
        String descricao = "LOCAL: " + input.endereco() + " | OBS: " + input.observacao();

        Solicitacao solicitacao = new Solicitacao(
                protocolo,
                input.anonimo() ? null : input.nome(),
                input.anonimo() ? null : input.cpf(),
                descricao,
                resultado.nivel(),
                resultado.prazo());

        repository.salvar(solicitacao);
        return Optional.of(solicitacao);
    }

    public Optional<Solicitacao> buscarPorProtocolo(String protocolo) {
        return Optional.ofNullable(repository.buscar(protocolo));
    }
}
