public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.criarArvore();
        System.out.println("O número de nós nessa árvore é:");
        arvore.contarNos(arvore.raiz);
        System.out.println("\nA árvore em Pré Ordem:");
        arvore.preOrdem(arvore.raiz);
        System.out.println("\nA árvore em Ordem:");
        arvore.emOrdem(arvore.raiz);
        System.out.println("\nA árvore em Pós Ordem:");
        arvore.posOrdem(arvore.raiz);
        System.out.println("\nA árvore em Largura:");
        arvore.emLargura();
        System.out.println("O número de nós nessa árvore é (Iterativo):");
        arvore.contarNos2(arvore.raiz);
        System.out.println("\nA árvore em Pré Ordem (Iterativo):");
        arvore.preOrdem2(arvore.raiz);
        System.out.println("\nA árvore em Ordem (Iterativo):");
        arvore.emOrdem2(arvore.raiz);
        System.out.println("\nA árvore em Pós Ordem (Iterativo):");
        arvore.posOrdem2(arvore.raiz);
    }
}