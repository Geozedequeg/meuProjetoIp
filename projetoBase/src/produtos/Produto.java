package produtos;

public class Produto {
    private String nome;
    private String descricao;
    private double valor;

    public Produto (String nome, String descricao, double valor) throws ValorInvalidoException{
        this.nome = nome;
        this.descricao = descricao;
        if (valor > 0){
            this.valor = valor;
        }else {
            throw new ValorInvalidoException();
        }
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public String getdescricao() {
        return descricao;
    }
}
