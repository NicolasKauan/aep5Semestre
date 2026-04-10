package Service;

import enums.NivelPrioridade;

public class CalculadoraPrioridade implements ICalculadoraPrioridade {

    @Override
    public ResultadoPrioridade calcular(int pontosTotal) {
        if (pontosTotal >= 14) {
            return new ResultadoPrioridade(NivelPrioridade.URGENTE, "1-2 dias corridos");
        }
        if (pontosTotal >= 10) {
            return new ResultadoPrioridade(NivelPrioridade.ALTA, "3-4 dias úteis");
        }
        if (pontosTotal >= 6) {
            return new ResultadoPrioridade(NivelPrioridade.MEDIA, "5 dias úteis");
        }
        return new ResultadoPrioridade(NivelPrioridade.BAIXA, "7 dias úteis");
    }
}
