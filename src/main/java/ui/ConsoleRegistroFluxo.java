package ui;

import Model.RegistroSolicitacaoInput;
import java.util.Optional;
import java.util.Scanner;

public final class ConsoleRegistroFluxo {

    private ConsoleRegistroFluxo() {}

    public static Optional<RegistroSolicitacaoInput> coletar(Scanner sc) {
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
            int p1 = escolherObstrucao(sc);
            int p2 = escolherRisco(sc);
            int p3 = escolherLocal(sc);
            int p4 = escolherVolume(sc);

            System.out.print("\n📍 Endereço da Ocorrência: ");
            String endereco = sc.nextLine();

            System.out.print("💬 Observação Adicional: ");
            String observacao = sc.nextLine();

            return Optional.of(new RegistroSolicitacaoInput(
                    ehAnonimo, nome, cpf, p1, p2, p3, p4, endereco, observacao));
        } catch (NumberFormatException e) {
            System.out.println("\n❌ ERRO: Dados inválidos. Operação cancelada.");
            return Optional.empty();
        }
    }

    private static int escolherObstrucao(Scanner sc) {
        System.out.println("\n Obstrução da Via:");
        System.out.println("1-Não Bloqueia | 2-Parcial | 3-Total");
        int op = Integer.parseInt(sc.nextLine());
        return (op == 3) ? 4 : (op == 2) ? 3 : 1;
    }

    private static int escolherRisco(Scanner sc) {
        System.out.println("\n Risco Sanitário:");
        System.out.println("1-Seco | 2-Ensacado | 3-Dengue | 4-Exposto");
        return Integer.parseInt(sc.nextLine());
    }

    private static int escolherLocal(Scanner sc) {
        System.out.println("\n Tipo de Local:");
        System.out.println("1-Residencial | 2-Parque/Escola | 3-Ecológico | 4-Saúde");
        int op = Integer.parseInt(sc.nextLine());
        return (op == 4) ? 5 : (op == 3) ? 4 : (op == 2) ? 3 : 2;
    }

    private static int escolherVolume(Scanner sc) {
        System.out.println("\nVolume do Lixo:");
        System.out.println("1-Espalhado | 2-Pequeno | 3-Moderado | 4-Excessivo");
        return Integer.parseInt(sc.nextLine());
    }
}
