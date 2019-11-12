package produtos;

public class ProdutoJaCadastradoException extends Exception{
    private String nome;

    //Erro caso tente ser inserido um produto que já existe.
    public ProdutoJaCadastradoException (String nome){
        super ("Produto ja cadastrado.");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
