package produtos;

public class ProdutoNaoEncontradoException extends Exception {
    private String nome;

    //Erro caso tente interagir com um produto que não existe.
    public ProdutoNaoEncontradoException(String nome){
        super ("Produto nao encontrado.");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
