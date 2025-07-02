public class Node {
    private String tipo;
    private Imovel imovel;
    private Node proximo;

    public Node(String tipo, Imovel imovel) {
        this.tipo = tipo;
        this.imovel = imovel;
        this.proximo = null;
    }

    public String getTipo() {
        return tipo;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}