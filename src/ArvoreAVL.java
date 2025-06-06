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

    private No rotacaoEsquerda(No x1) {
        No x2 = x1.right;
        No T2 = x2.left;

        x2.left = x1;
        x1.right = T2;

        atualizarAltura(x1);
        atualizarAltura(x2);

        return x2;
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

        if (fb > 1 && valor.compareTo(no.left.value) > 0) {
            no.left = rotacaoEsquerda(no.left);
            return rotacaoDireita(no);
        }

        if (fb < -1 && valor.compareTo(no.right.value) < 0) {
            no.right = rotacaoDireita(no.right);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void excluir(String valor) {
        raiz = excluirAVL(raiz, valor);
    }

    private No excluirAVL(No no, String valor) {
        if (no == null) return null;

        if (valor.compareTo(no.value) < 0) {
            no.left = excluirAVL(no.left, valor);
        } else if (valor.compareTo(no.value) > 0) {
            no.right = excluirAVL(no.right, valor);
        } else {
            if (no.left == null || no.right == null) {
                No temp = (no.left != null) ? no.left : no.right;
                if (temp == null) {
                    no = null;
                } else {
                    no = temp;
                }
            } else {
                No sucessor = getMin(no.right);
                no.value = sucessor.value;
                no.right = excluirAVL(no.right, sucessor.value);
            }
        }

        if (no == null) return null;

        atualizarAltura(no);
        int fb = fatorBalanceamento(no);

        if (fb > 1 && fatorBalanceamento(no.left) >= 0) {
            return rotacaoDireita(no);
        }

        if (fb < -1 && fatorBalanceamento(no.right) <= 0) {
            return rotacaoEsquerda(no);
        }

        if (fb > 1 && fatorBalanceamento(no.left) < 0) {
            no.left = rotacaoEsquerda(no.left);
            return rotacaoDireita(no);
        }

        if (fb < -1 && fatorBalanceamento(no.right) > 0) {
            no.right = rotacaoDireita(no.right);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private No getMin(No no) {
        while (no.left != null)
            no = no.left;
        return no;
    }

    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.value + " ");
            preOrdem(no.left);
            preOrdem(no.right);
        }
    }

    public void exibirPreOrdem() {
        preOrdem(raiz);
    }
}
