public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.criarArvore();
        System.out.println(arvore.contarNos(arvore.raiz) + " é o número de nós dessa árvore\n");
        System.out.println("\nA árvore em Pré Ordem:");
        arvore.preOrdem(arvore.raiz);
        System.out.println("\nA árvore em Ordem:");
        arvore.emOrdem(arvore.raiz);
        System.out.println("\nA árvore em Pós Ordem:");
        arvore.posOrdem(arvore.raiz);
    }
}