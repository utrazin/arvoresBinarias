enum Cor {
    Vermelho, Preto;
}

class NoRubroNegro {
    int chave;
    Cor cor;
    No esquerda, direita, pai;

    public NoRubroNegro(int chave) {
        this.chave = chave;
        this.cor = Cor.Vermelho;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}