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
}