public class ArvoreRubroNegra {
    private NoRubroNegra raiz;
    private final NoRubroNegra NIL;

    public ArvoreRubroNegra() {
        NIL = new NoRubroNegra(0);
        NIL.cor = Cor.Preto;
        raiz = NIL;
    }

    public void inserir(int valor) {
        NoRubroNegra novo = new NoRubroNegra(valor);
        novo.esquerda = NIL;
        novo.direita = NIL;

        NoRubroNegra y = null;
        NoRubroNegra x = raiz;

        while (x != NIL) {
            y = x;
            if (valor < x.valor) {
                x = x.esquerda;
            } else {
                x = x.direita;
            }
        }

        novo.pai = y;
        if (y == null) {
            raiz = novo;
        } else if (valor < y.valor) {
            y.esquerda = novo;
        } else {
            y.direita = novo;
        }

        corrigirInsercao(novo);
    }

    private void corrigirInsercao(NoRubroNegra z) {
        while (z.pai != null && z.pai.cor == Cor.Vermelho) {
            if (z.pai == z.pai.pai.esquerda) {
                NoRubroNegra y = z.pai.pai.direita;
                if (y.cor == Cor.Vermelho) {
                    z.pai.cor = Cor.Preto;
                    y.cor = Cor.Preto;
                    z.pai.pai.cor = Cor.Vermelho;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.direita) {
                        z = z.pai;
                        rotacaoEsquerda(z);
                    }
                    z.pai.cor = Cor.Preto;
                    z.pai.pai.cor = Cor.Vermelho;
                    rotacaoDireita(z.pai.pai);
                }
            } else {
                NoRubroNegra y = z.pai.pai.esquerda;
                if (y.cor == Cor.Vermelho) {
                    z.pai.cor = Cor.Preto;
                    y.cor = Cor.Preto;
                    z.pai.pai.cor = Cor.Vermelho;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.esquerda) {
                        z = z.pai;
                        rotacaoDireita(z);
                    }
                    z.pai.cor = Cor.Preto;
                    z.pai.pai.cor = Cor.Vermelho;
                    rotacaoEsquerda(z.pai.pai);
                }
            }
        }
        raiz.cor = Cor.Preto;
    }

    private void rotacaoEsquerda(NoRubroNegra x) {
        NoRubroNegra y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != NIL) {
            y.esquerda.pai = x;
        }
        y.pai = x.pai;
        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }
        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(NoRubroNegra x) {
        NoRubroNegra y = x.esquerda;
        x.esquerda = y.direita;
        if (y.direita != NIL) {
            y.direita.pai = x;
        }
        y.pai = x.pai;
        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.direita) {
            x.pai.direita = y;
        } else {
            x.pai.esquerda = y;
        }
        y.direita = x;
        x.pai = y;
    }

    public void excluir(int valor) {
        raiz = excluirRubroNegra(raiz, valor);
    }

    private NoRubroNegra excluirRubroNegra(NoRubroNegra no, int valor) {
        if (no == NIL) return no;

        if (valor < no.valor) {
            no.esquerda = excluirRubroNegra(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = excluirRubroNegra(no.direita, valor);
        } else {
            if (no.esquerda == NIL || no.direita == NIL) {
                NoRubroNegra temp = (no.esquerda != NIL) ? no.esquerda : no.direita;
                no = temp;
            } else {
                NoRubroNegra sucessor = getMin(no.direita);
                no.valor = sucessor.valor;
                no.direita = excluirRubroNegra(no.direita, sucessor.valor);
            }
        }

        return no;
    }

    private NoRubroNegra getMin(NoRubroNegra no) {
        while (no.esquerda != NIL) {
            no = no.esquerda;
        }
        return no;
    }

    public void emOrdem(NoRubroNegra no) {
        if (no != NIL) {
            emOrdem(no.esquerda);
            System.out.println(no.valor + " (" + no.cor + ")");
            emOrdem(no.direita);
        }
    }

    public void exibir() {
        emOrdem(raiz);
    }
}