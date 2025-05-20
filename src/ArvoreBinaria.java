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

}