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
        arvoreAVL.inserir(10);
        arvoreAVL.inserir(20);
        arvoreAVL.inserir(30);
        arvoreAVL.inserir(40);
        arvoreAVL.inserir(50);
        arvoreAVL.inserir(25);

        System.out.printf("Árvore AVL - Em Pré Ordem:\n");
        arvoreAVL.exibirPreOrdem();

        System.out.printf("Árvore AVL - Em Ordem:\n");
        arvoreAVL.exibirEmOrdem();

        System.out.println("\nExcluir valor '30'");
        arvoreAVL.excluir(30);

        System.out.println("Árvore AVL depois da exlusão de '30' em Pré Ordem:");
        arvoreAVL.exibirPreOrdem();

        System.out.println("Árvore AVL depois da exlusão de '30' em Ordem:");
        arvoreAVL.exibirEmOrdem();

        System.out.println("\nInserir valor '70'");
        arvoreAVL.inserir(70);

        System.out.println("Árvore AVL depois da inserção do valor '70' em Pré Ordem:");
        arvoreAVL.exibirPreOrdem();

        System.out.println("Árvore AVL depois da inserção do valor '70' em Ordem:");
        arvoreAVL.exibirEmOrdem();

        System.out.println();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        System.out.println("\nÁrvore Rubro Negra:");

        ArvoreRubroNegra arvoreRubroNegra = new ArvoreRubroNegra();
        arvoreRubroNegra.inserir(10);
        arvoreRubroNegra.inserir(20);
        arvoreRubroNegra.inserir(30);
        arvoreRubroNegra.inserir(15);
        arvoreRubroNegra.inserir(25);
        arvoreRubroNegra.exibirEmOrdem();
    }
}