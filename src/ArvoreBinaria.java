import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void emLargura() {
        if (raiz == null) {
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.printf(atual.value + "\n");

            if (atual.left != null) {
                fila.add(atual.left);
            }
            if (atual.right != null) {
                fila.add(atual.right);
            }
        }
    }

    public int contarNos2(No raiz) {
        if (raiz == null) {
            return 0;
        }

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);
        int contador = 0;

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            contador++;

            if (atual.right != null) {
                pilha.push(atual.right);
            }
            if (atual.left != null) {
                pilha.push(atual.left);
            }
        }

        return contador;
    }

    public void preOrdem2(No raiz) {
        if (raiz == null) {
            return;
        }

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No noAtual = pilha.pop();
            System.out.println(noAtual.value);

            // Primeiro empilha o filho da direita, depois o da esquerda
            if (noAtual.right != null) {
                pilha.push(noAtual.right);
            }
            if (noAtual.left != null) {
                pilha.push(noAtual.left);
            }
        }
    }

    public void emOrdem2(No raiz) {
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.left;
            }
            atual = pilha.pop();
            System.out.println(atual.value);

            atual = atual.right;
        }
    }
}