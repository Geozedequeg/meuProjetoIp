package produtos;

public interface RepositorioProdutos {

    public void inserir(Produto produto);
    public void atualizar(Produto produtos) throws ProdutoNaoEncontradoException;
    public void remover(String nome) throws ProdutoNaoEncontradoException;
    public Produto procurar(String nome) throws ProdutoNaoEncontradoException;
    public boolean existe(String nome);

}
