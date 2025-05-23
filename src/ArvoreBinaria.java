public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void criarArvore() {
        raiz = new No("A");
        raiz.left = new No("B");
        raiz.right = new No("C");
        raiz.left.left = new No("D");
        raiz.left.right = new No("E");
        raiz.right.right = new No("F");
    }

    public int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.left) + contarNos(no.right);
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.value);
        preOrdem(no.left);
        preOrdem(no.right);
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.left);
        System.out.println(no.value);
        emOrdem(no.right);
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.left);
        posOrdem(no.right);
        System.out.println(no.value);
    }

    public int altura (No no) {
        if (no == null) {
            return 0;
        }
        int left = altura(no.left);
        int right = altura(no.right);
        return Math.max(left, right) + 1;
    }

    public void alturaNo (No no, int nivel) {
        if (no == null) {
            return;
        }
        if (nivel == 1) {
            System.out.println(no.value);
        } else if (nivel > 1) {
            alturaNo(no.left, nivel - 1);
            alturaNo(no.right, nivel - 1);
        }
    }

    public void emLargura() {
        int h = altura(raiz);
        for (int i = 1; i <= h; i++) {
            alturaNo(raiz, i);
        }
    }
}