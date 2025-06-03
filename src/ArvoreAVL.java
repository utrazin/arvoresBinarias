public class ArvoreAVL {
    No raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    private int altura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    private void atualizarAltura(No no) {
        no.altura = 1 + Math.max(altura(no.left), altura(no.right));
    }

    private int fatorBalanceamento(No no) {
        return (no == null) ? 0 : altura(no.left) - altura(no.right);
    }

    private No rotacaoDireita(No y) {
        No x = y.left;
        No T2 = x.right;

        x.right = y;
        y.left = T2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.right;
        No T2 = y.left;

        y.left = x;
        x.right = T2;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    public void inserir(String valor) {
        raiz = inserirAVL(raiz, valor);
    }

    private No inserirAVL(No no, String valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor.compareTo(no.value) < 0) {
            no.left = inserirAVL(no.left, valor);
        } else if (valor.compareTo(no.value) > 0) {
            no.right = inserirAVL(no.right, valor);
        } else {
            return no;
        }

        atualizarAltura(no);

        int fb = fatorBalanceamento(no);

        if (fb > 1 && valor.compareTo(no.left.value) < 0) {
            return rotacaoDireita(no);
        }

        if (fb < -1 && valor.compareTo(no.right.value) > 0) {
            return rotacaoEsquerda(no);
        }

        return no;
    }
}
