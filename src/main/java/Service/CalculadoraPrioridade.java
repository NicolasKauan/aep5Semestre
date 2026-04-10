package Service;

import enums.NivelPrioridade;

public class CalculadoraPrioridade {

    public static Object[] calcular(int pontosTotal) {
        if (pontosTotal >= 14) return new Object[]{NivelPrioridade.URGENTE, "1-2 dias corridos"};
        if (pontosTotal >= 10) return new Object[]{NivelPrioridade.ALTA, "3-4 dias úteis"};
        if (pontosTotal >= 6)  return new Object[]{NivelPrioridade.MEDIA, "5 dias úteis"};
        return new Object[]{NivelPrioridade.BAIXA, "7 dias úteis"};
    }

    public static String gerarProtocoloAleatorio() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        java.util.Random rnd = new java.util.Random();
        for (int i = 0; i < 8; i++) sb.append(caracteres.charAt(rnd.nextInt(caracteres.length())));
        return sb.toString();
    }
}