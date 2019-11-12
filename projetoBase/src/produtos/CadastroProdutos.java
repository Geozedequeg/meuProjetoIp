package produtos;

public class CadastroProdutos {
    private RepositorioProdutos repositorioProdutos;
    public CadastroProdutos(RepositorioProdutos repositorioProdutos){
        this.repositorioProdutos = repositorioProdutos;
    }

    //Cadastra novos produtos no repositorio e retorna uma excecao caso ele ja tenha sido cadastrado.
    public void cadastrar (Produto produto)
        throws ProdutoJaCadastradoException {
        if(this.repositorioProdutos.existe(produto.getNome())){
            throw new ProdutoJaCadastradoException(produto.getNome());
        }else{
            this.repositorioProdutos.inserir(produto);
        }
    }

    //Remove produtos do repositorio e retorna uma excecao caso ele nao esteja no repositorio.
    public void remover(String nome)
        throws ProdutoNaoEncontradoException{
        this.repositorioProdutos.remover(nome);
    }

    //Atualiza produtos do repositorio e retorna uma excecao caso ele nao esteja no repositorio.
    public void atualizar(Produto produto)
        throws ProdutoNaoEncontradoException{
        this.repositorioProdutos.atualizar(produto);
    }

    //Procura produtos do repositorio e retorna uma excecao caso ele nao esteja no repositorio.
    public Produto procurar(String nome)
        throws ProdutoNaoEncontradoException{
        return this.repositorioProdutos.procurar(nome);
    }

    //Confirma se ha um produto no repositorio.
    public boolean existe(String nome){
        return this.repositorioProdutos.existe(nome);
    }
}
