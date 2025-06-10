public class NoAVL {
    int valor;
    NoAVL left;
    NoAVL right;
    int altura;

    public NoAVL(int valor) {
        this.valor = valor;
        this.left = null;
        this.right = null;
        this.altura = 1;
    }
}