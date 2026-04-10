package Model;

public record RegistroSolicitacaoInput(
        boolean anonimo,
        String nome,
        String cpf,
        int pontosObstrucao,
        int pontosRisco,
        int pontosLocal,
        int pontosVolume,
        String endereco,
        String observacao
) {
    public int pontosTotal() {
        return pontosObstrucao + pontosRisco + pontosLocal + pontosVolume;
    }
}
