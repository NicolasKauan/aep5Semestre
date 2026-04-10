import Repository.ISolicitacaoRepository;
import Repository.SolicitacaoRepository;
import Service.CalculadoraPrioridade;
import Service.GeradorProtocoloAleatorio;
import Service.ICalculadoraPrioridade;
import Service.IGeradorProtocolo;
import Service.SolicitacaoService;
import java.util.Scanner;
import ui.ConsoleRegistroFluxo;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ISolicitacaoRepository repository = new SolicitacaoRepository();
    private static final ICalculadoraPrioridade calculadoraPrioridade = new CalculadoraPrioridade();
    private static final IGeradorProtocolo geradorProtocolo = new GeradorProtocoloAleatorio();
    private static final SolicitacaoService solicitacaoService =
            new SolicitacaoService(repository, calculadoraPrioridade, geradorProtocolo);

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
                    case 1 -> registrarReclamacao();
                    case 2 -> acompanhar();
                    case 0 -> System.out.println("Encerrando sistema...");
                    default -> System.out.println("⚠️ Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Erro: Digite apenas números para as opções do menu.");
            }
        }
    }

    private static void registrarReclamacao() {
        ConsoleRegistroFluxo.coletar(sc).ifPresent(input -> solicitacaoService
                .registrar(input)
                .ifPresent(s -> System.out.println("\n✅ SUCESSO! PROTOCOLO GERADO: " + s.getProtocolo())));
    }

    private static void acompanhar() {
        System.out.println("\n--- ACOMPANHAMENTO DE PROTOCOLO ---");
        System.out.print("Informe o número do protocolo: ");
        String protocoloBusca = sc.nextLine();

        solicitacaoService
                .buscarPorProtocolo(protocoloBusca)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(
                                "⚠️ Protocolo não localizado. Verifique se digitou corretamente."));
    }
}
