import Model.Solicitacao;
import Repository.SolicitacaoRepository;
import Service.SolicitacaoService;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final SolicitacaoRepository repository = new SolicitacaoRepository();
    private static final SolicitacaoService solicitacaoService = new SolicitacaoService(repository, sc);

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n🏛️  SISTEMA DE ZELADORIA - PREFEITURA");
            System.out.println("1. [TELA 1] Registrar Reclamação");
            System.out.println("2. [TELA 2] Acompanhar Protocolo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1 -> solicitacaoService.executarFluxoRegistro();
                    case 2 -> acompanhar();
                    case 0 -> System.out.println("Encerrando sistema...");
                    default -> System.out.println("⚠️ Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Erro: Digite apenas números para as opções do menu.");
            }
        }
    }

    private static void acompanhar() {
        System.out.println("\n--- ACOMPANHAMENTO DE PROTOCOLO ---");
        System.out.print("Informe o número do protocolo: ");
        String protocoloBusca = sc.nextLine();

        Solicitacao solicitacaoencontrada = repository.buscar(protocoloBusca);

        if (solicitacaoencontrada != null) {
            System.out.println(solicitacaoencontrada);
        } else {
            System.out.println("⚠️ Protocolo não localizado. Verifique se digitou corretamente.");
        }
    }
}
