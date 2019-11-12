package pessoas;

public class PessoaJaCadastradaException extends Exception {
    private String nome;

    public PessoaJaCadastradaException(String nome) {
        super("Pessoa ja foi cadastrada.");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}