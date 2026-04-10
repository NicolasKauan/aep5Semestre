package Model;

import enums.NivelPrioridade;
import enums.StatusSolicitacao;
import java.time.LocalDateTime;

public class Solicitacao {
    private final String protocolo;
    private final String nomeCidadao;
    private final String cpf; // Novo campo
    private final String descricao;
    private final NivelPrioridade prioridade;
    private final StatusSolicitacao status;
    private final String prazo;
    private final LocalDateTime dataCriacao;

    public Solicitacao(String protocolo, String nome, String cpf, String desc, NivelPrioridade prioridade, String prazo) {
        this.protocolo = protocolo;
        this.nomeCidadao = (nome == null) ? "ANÔNIMO" : nome;
        this.cpf = (cpf == null) ? "N/A" : cpf;
        this.descricao = desc;
        this.prioridade = prioridade;
        this.status = StatusSolicitacao.ABERTA;
        this.prazo = prazo;
        this.dataCriacao = LocalDateTime.now();
    }

    public String getProtocolo() { return protocolo; }

    @Override
    public String toString() {
        return String.format(
                "\n==========================================\n" +
                        "  PROTOCOLO: %s\n" +
                        "  CIDADÃO:   %s | CPF: %s\n" +
                        "  PRIORIDADE: %s (Prazo: %s)\n" +
                        "  DETALHES:  %s\n" +
                        "==========================================",
                protocolo, nomeCidadao, cpf, prioridade, prazo, descricao
        );
    }
}