public class Imovel {
    private String nome;
    private double preco;
    private double aluguel;
    private Jogador proprietario;

    public Imovel(String nome, double preco, double aluguel) {
        this.nome = nome;
        this.preco = preco;
        this.aluguel = aluguel;
        this.proprietario = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getAluguel() {
        return aluguel;
    }

    public void setAluguel(double aluguel) {
        this.aluguel = aluguel;
    }

    public Jogador getProprietario() {
        return proprietario;
    }

    public void setProprietario(Jogador proprietario) {
        this.proprietario = proprietario;
    }
}