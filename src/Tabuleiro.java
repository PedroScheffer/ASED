public class Tabuleiro {
    private Node inicio;

    public Tabuleiro() {
        this.inicio = null;
    }

    public void adicionarCasa(Node novaCasa) {
        if (inicio == null) {
            inicio = novaCasa;
            inicio.setProximo(inicio);
        } else {
            Node atual = inicio;
            while (atual.getProximo() != inicio) {
                atual = atual.getProximo();
            }
            atual.setProximo(novaCasa);
            novaCasa.setProximo(inicio);
        }
    }

    public Node getInicio() {
        return inicio;
    }
}