public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        System.out.println("Árvore Binária:");
        arvore.criarArvore();
        System.out.println(arvore.contarNos(arvore.raiz) + " é o número de nós dessa árvore");
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

        System.out.println();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        System.out.println("\nÁrvore AVL:");
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        arvoreAVL.inserir("C");
        arvoreAVL.inserir("B");
        arvoreAVL.inserir("A");
        arvoreAVL.inserir("D");
        arvoreAVL.inserir("E");
        arvoreAVL.inserir("F");

        System.out.printf("Árvore AVL - Em Pré Ordem:\n");
        arvoreAVL.exibirPreOrdem();

        System.out.println("\n\nExcluir valor 'B'");
        arvoreAVL.excluir("B");

        System.out.println("Árvore AVL depois da exlusão de 'B':");
        arvoreAVL.exibirPreOrdem();

        System.out.println("\n\nInserir valor 'G'");
        arvoreAVL.inserir("G");

        System.out.println("Árvore AVL depois da inserção do valor 'G':");
        arvoreAVL.exibirPreOrdem();
    }
}