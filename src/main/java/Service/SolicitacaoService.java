package Service;

import Model.Solicitacao;
import Repository.SolicitacaoRepository;
import enums.NivelPrioridade;
import java.util.Scanner;

public class SolicitacaoService {
    private final SolicitacaoRepository repository;
    private final Scanner sc;

    public SolicitacaoService(SolicitacaoRepository repository, Scanner sc) {
        this.repository = repository;
        this.sc = sc;
    }

    public void executarFluxoRegistro() {
        System.out.println("\n--- 📝 NOVO REGISTRO DE ZELADORIA ---");

        System.out.print("Deseja Anonimato? (S/N): ");
        boolean ehAnonimo = sc.nextLine().equalsIgnoreCase("S");
        String nome = null;
        String cpf = null;

        if (!ehAnonimo) {
            System.out.print("Digite seu Nome Completo: ");
            nome = sc.nextLine();
            System.out.print("Digite seu CPF: ");
            cpf = sc.nextLine();
        }

        try {
            int p1 = escolherObstrucao();
            int p2 = escolherRisco();
            int p3 = escolherLocal();
            int p4 = escolherVolume();


            System.out.print("\n📍 Endereço da Ocorrência: ");
            String endereco = sc.nextLine();

            System.out.print("💬 Observação Adicional: ");
            String observacao = sc.nextLine();


            int pontos = p1 + p2 + p3 + p4;
            Object[] calc = CalculadoraPrioridade.calcular(pontos);
            String protocolo = CalculadoraPrioridade.gerarProtocoloAleatorio();

            Solicitacao s = new Solicitacao(
                    protocolo, nome, cpf,
                    ("LOCAL: " + endereco + " | OBS: " + observacao),
                    (NivelPrioridade) calc[0], (String) calc[1]
            );

            repository.salvar(s);
            System.out.println("\n✅ SUCESSO! PROTOCOLO GERADO: " + s.getProtocolo());

        } catch (Exception e) {
            System.out.println("\n❌ ERRO: Dados inválidos. Operação cancelada.");
        }
    }

    private int escolherObstrucao() {
        System.out.println("\n Obstrução da Via:");
        System.out.println("1-Não Bloqueia | 2-Parcial | 3-Total");
        int op = Integer.parseInt(sc.nextLine());
        return (op == 3) ? 4 : (op == 2) ? 3 : 1;
    }

    private int escolherRisco() {
        System.out.println("\n Risco Sanitário:");
        System.out.println("1-Seco | 2-Ensacado | 3-Dengue | 4-Exposto");
        return Integer.parseInt(sc.nextLine());
    }

    private int escolherLocal() {
        System.out.println("\n Tipo de Local:");
        System.out.println("1-Residencial | 2-Parque/Escola | 3-Ecológico | 4-Saúde");
        int op = Integer.parseInt(sc.nextLine());
        return (op == 4) ? 5 : (op == 3) ? 4 : (op == 2) ? 3 : 2;
    }

    private int escolherVolume() {
        System.out.println("\nVolume do Lixo:");
        System.out.println("1-Espalhado | 2-Pequeno | 3-Moderado | 4-Excessivo");
        return Integer.parseInt(sc.nextLine());
    }
}