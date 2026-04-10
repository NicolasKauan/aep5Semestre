package enums;

public enum StatusSolicitacao {
    ABERTA("Aguardando análise inicial"),
    ANDAMENTO("Sendo analisada pela equipe técnica"),
    AGUARDANDO_MATERIAIS("Verificando de recursos externos"),
    FINALIZADA("Serviço concluído"),
    CANCELADA("Solicitação não aprovada");

    private final String descricao;

    StatusSolicitacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}