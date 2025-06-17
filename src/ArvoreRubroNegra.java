public class ArvoreRubroNegra {
    private NoRubroNegra raiz;
    private final NoRubroNegra NIL;

    public ArvoreRubroNegra() {
        NIL = new NoRubroNegra(0);
        NIL.cor = Cor.Preto;
        NIL.esquerda = NIL;
        NIL.direita = NIL;
        raiz = NIL;
    }

    public void inserir(int valor) {
        NoRubroNegra novo = new NoRubroNegra(valor);
        novo.esquerda = NIL;
        novo.direita = NIL;
        novo.cor = Cor.Vermelho;

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

    private void transplante(NoRubroNegra u, NoRubroNegra v) {
        if (u.pai == null) {
            raiz = v;
        } else if (u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }
        v.pai = u.pai;
    }

    private void deleteFixup(NoRubroNegra x) {
        while (x != raiz && x.cor == Cor.Preto) {
            if (x == x.pai.esquerda) {
                NoRubroNegra w = x.pai.direita;
                if (w.cor == Cor.Vermelho) {
                    w.cor = Cor.Preto;
                    x.pai.cor = Cor.Vermelho;
                    rotacaoEsquerda(x.pai);
                    w = x.pai.direita;
                }
                if (w.esquerda.cor == Cor.Preto && w.direita.cor == Cor.Preto) {
                    w.cor = Cor.Vermelho;
                    x = x.pai;
                } else {
                    if (w.direita.cor == Cor.Preto) {
                        w.esquerda.cor = Cor.Preto;
                        w.cor = Cor.Vermelho;
                        rotacaoDireita(w);
                        w = x.pai.direita;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.Preto;
                    w.direita.cor = Cor.Preto;
                    rotacaoEsquerda(x.pai);
                    x = raiz;
                }
            } else {
                NoRubroNegra w = x.pai.esquerda;
                if (w.cor == Cor.Vermelho) {
                    w.cor = Cor.Preto;
                    x.pai.cor = Cor.Vermelho;
                    rotacaoDireita(x.pai);
                    w = x.pai.esquerda;
                }
                if (w.direita.cor == Cor.Preto && w.esquerda.cor == Cor.Preto) {
                    w.cor = Cor.Vermelho;
                    x = x.pai;
                } else {
                    if (w.esquerda.cor == Cor.Preto) {
                        w.direita.cor = Cor.Preto;
                        w.cor = Cor.Vermelho;
                        rotacaoEsquerda(w);
                        w = x.pai.esquerda;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.Preto;
                    w.esquerda.cor = Cor.Preto;
                    rotacaoDireita(x.pai);
                    x = raiz;
                }
            }
        }
        x.cor = Cor.Preto;
    }

    public void excluir(int valor) {
        NoRubroNegra z = raiz;
        while (z != NIL) {
            if (valor == z.valor) {
                excluirRubroNegra(z);
                return;
            } else if (valor < z.valor) {
                z = z.esquerda;
            } else {
                z = z.direita;
            }
        }
    }

    private void excluirRubroNegra(NoRubroNegra z) {
        NoRubroNegra y = z;
        Cor yOriginalCor = y.cor;
        NoRubroNegra x;

        if (z.esquerda == NIL) {
            x = z.direita;
            transplante(z, z.direita);
        } else if (z.direita == NIL) {
            x = z.esquerda;
            transplante(z, z.esquerda);
        } else {
            y = getMin(z.direita);
            yOriginalCor = y.cor;
            x = y.direita;

            if (y.pai == z) {
                x.pai = y;
            } else {
                transplante(y, y.direita);
                y.direita = z.direita;
                y.direita.pai = y;
            }

            transplante(z, y);
            y.esquerda = z.esquerda;
            y.esquerda.pai = y;
            y.cor = z.cor;
        }

        if (yOriginalCor == Cor.Preto) {
            deleteFixup(x);
        }
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

    public void exibirEmOrdem() {
        emOrdem(raiz);
    }
}