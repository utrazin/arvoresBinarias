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

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        int contador = 0;

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            contador++;

            if (atual.left != null) {
                fila.add(atual.left);
            }
            if (atual.right != null) {
                fila.add(atual.right);
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

    public void posOrdem2(No raiz) {
        if (raiz == null) {
            return;
        }

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();

        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            No no = pilha1.pop();
            pilha2.push(no);

            if (no.left != null) {
                pilha1.push(no.left);
            }
            if (no.right != null) {
                pilha1.push(no.right);
            }
        }

        while (!pilha2.isEmpty()) {
            System.out.println(pilha2.pop().value);
        }
    }

    public int contarNosFolha(No no) {
        if (no == null) {
            return 0;
        }

        if (no.left == null && no.right == null) {
            return 1;
        }

        return contarNosFolha(no.left) + contarNosFolha(no.right);
    }

    public int contarNosFolha2(No raiz) {
        if (raiz == null) {
            return 0;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        int contador = 0;

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            if (atual.left == null && atual.right == null) {
                contador++;
            }

            if (atual.left != null) {
                fila.add(atual.left);
            }

            if (atual.right != null) {
                fila.add(atual.right);
            }
        }

        return contador;
    }
}