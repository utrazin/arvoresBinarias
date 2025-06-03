public class No {
    String value;
    No left;
    No right;
    int altura;

    public No(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.altura = 1;
    }
}