public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.criarArvore();
        System.out.println(arvore.contarNos(arvore.raiz));
    }
}