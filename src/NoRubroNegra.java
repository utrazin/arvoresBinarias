enum Cor {
    Vermelho, Preto;
}

class NoRubroNegra {
    int valor;
    Cor cor;
    NoRubroNegra esquerda, direita, pai;

    public NoRubroNegra(int valor) {
        this.valor = valor;
        this.cor = Cor.Vermelho;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}