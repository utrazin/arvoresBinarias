public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        System.out.println("Arvóre Binária:");
        arvore.criarArvore();
        System.out.println("\n" + arvore.contarNos(arvore.raiz) + " é o número de nós dessa árvore");
        System.out.println("\n" + arvore.contarNosFolha(arvore.raiz) + " é o número de nós folha dessa árvore");
        System.out.println("\nA árvore em Pré Ordem:");
        arvore.preOrdem(arvore.raiz);
        System.out.println("\nA árvore em Ordem:");
        arvore.emOrdem(arvore.raiz);
        System.out.println("\nA árvore em Pós Ordem:");
        arvore.posOrdem(arvore.raiz);
        System.out.println("\nA árvore em Largura:");
        arvore.emLargura();
        System.out.println("\n" + arvore.contarNosFila(arvore.raiz) + " é o número de nós dessa árvore (Fila)");
        System.out.println("\n" + arvore.contarNosPilha(arvore.raiz) + " é o número de nós dessa árvore (Pilha)");
        System.out.println("\n" + arvore.contarNosFolha2(arvore.raiz) + " é o número de nós folha dessa árvore (Iterativo)");
        System.out.println("\nA árvore em Pré Ordem (Iterativo):");
        arvore.preOrdem2(arvore.raiz);
        System.out.println("\nA árvore em Pré Ordem (Iterativo):");
        arvore.emOrdem2(arvore.raiz);
        System.out.println("\nA árvore em Pós Ordem (Iterativo):");
        arvore.posOrdem2(arvore.raiz);
        System.out.println("\nArvóre AVL:");
    }
}