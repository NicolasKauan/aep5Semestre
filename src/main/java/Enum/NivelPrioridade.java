package Enum;

public enum NivelPrioridade {
    BAIXA(1),
    MEDIA(2),
    ALTA(3),
    URGENTE(4);


    private final int valorNumerico;

    NivelPrioridade(int valorNumerico){
        this.valorNumerico=valorNumerico;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }
}
