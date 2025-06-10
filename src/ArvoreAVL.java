public class ArvoreAVL {
    NoAVL raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    private int altura(NoAVL no) {
        return (no == null) ? 0 : no.altura;
    }

    private void atualizarAltura(NoAVL no) {
        no.altura = 1 + Math.max(altura(no.left), altura(no.right));
    }

    private int fatorBalanceamento(NoAVL no) {
        return (no == null) ? 0 : altura(no.left) - altura(no.right);
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.left;
        NoAVL T2 = x.right;

        x.right = y;
        y.left = T2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x1) {
        NoAVL x2 = x1.right;
        NoAVL T2 = x2.left;

        x2.left = x1;
        x1.right = T2;

        atualizarAltura(x1);
        atualizarAltura(x2);

        return x2;
    }

    public void inserir(int valor) {
        raiz = inserirAVL(raiz, valor);
    }

    private NoAVL inserirAVL(NoAVL no, int valor) {
        if (no == null) {
            return new NoAVL(valor);
        }

        if (valor < no.valor) {
            no.left = inserirAVL(no.left, valor);
        } else if (valor > no.valor) {
            no.right = inserirAVL(no.right, valor);
        } else {
            return no; // Duplicado
        }

        atualizarAltura(no);
        int fb = fatorBalanceamento(no);

        if (fb > 1 && valor < no.left.valor)
            return rotacaoDireita(no);
        if (fb < -1 && valor > no.right.valor)
            return rotacaoEsquerda(no);
        if (fb > 1 && valor > no.left.valor) {
            no.left = rotacaoEsquerda(no.left);
            return rotacaoDireita(no);
        }
        if (fb < -1 && valor < no.right.valor) {
            no.right = rotacaoDireita(no.right);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void excluir(int valor) {
        raiz = excluirAVL(raiz, valor);
    }

    private NoAVL excluirAVL(NoAVL no, int valor) {
        if (no == null) return null;

        if (valor < no.valor) {
            no.left = excluirAVL(no.left, valor);
        } else if (valor > no.valor) {
            no.right = excluirAVL(no.right, valor);
        } else {
            if (no.left == null || no.right == null) {
                NoAVL temp = (no.left != null) ? no.left : no.right;
                no = temp;
            } else {
                NoAVL sucessor = getMin(no.right);
                no.valor = sucessor.valor;
                no.right = excluirAVL(no.right, sucessor.valor);
            }
        }

        if (no == null) return null;

        atualizarAltura(no);
        int fb = fatorBalanceamento(no);

        if (fb > 1 && fatorBalanceamento(no.left) >= 0)
            return rotacaoDireita(no);
        if (fb < -1 && fatorBalanceamento(no.right) <= 0)
            return rotacaoEsquerda(no);
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

    private NoAVL getMin(NoAVL no) {
        while (no.left != null)
            no = no.left;
        return no;
    }

    public void preOrdem(NoAVL no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.left);
            preOrdem(no.right);
        }
    }

    public void exibirPreOrdem() {
        preOrdem(raiz);
        System.out.println();
    }

    public void emOrdem(NoAVL no) {
        if (no != null) {
            emOrdem(no.left);
            System.out.print(no.valor + " ");
            emOrdem(no.right);
        }
    }

    public void exibirEmOrdem() {
        emOrdem(raiz);
        System.out.println();
    }
}