package produtos;

public class RepositorioProdutosLista implements RepositorioProdutos{

    private Produto produto;
    private RepositorioProdutosLista proximo;

    public RepositorioProdutosLista(){
        this.produto = null;
        this.proximo = null;
    }

    //Metodo para inserir novos produtos.
    public void inserir(Produto produto) {
        if(this.produto==null){
            this.produto = produto;
            this.proximo = new RepositorioProdutosLista();
        }else{
            this.proximo.inserir(produto);
        }
    }

    //Metodo para procurar por produtos.
    public Produto procurar(String nome)
    throws ProdutoNaoEncontradoException{
        if(this.produto == null){
            throw new ProdutoNaoEncontradoException(nome);
        }else{
            if(this.produto.getNome().equals(nome)){
                return this.produto;
            }else{
                return this.proximo.procurar(nome);
            }
        }
    }

    //Metodo para remover produtos.
    public void remover (String nome)
    throws ProdutoNaoEncontradoException{
        if(this.produto == null){
            throw new ProdutoNaoEncontradoException(nome);
        }else{
            if (this.produto.getNome().equals(nome)){
                this.produto = this.proximo.produto;
                this.proximo = this.proximo.proximo;
            }else{
                this.proximo.remover(nome);
            }
        }
    }

    //Metodo para atualizar produtos.
    public void atualizar (Produto produto)
        throws ProdutoNaoEncontradoException{
        if(this.produto == null){
            throw new ProdutoNaoEncontradoException(produto.getNome());
        }else if(this.produto.getNome().equals(produto.getNome())){
                this.produto = produto;
        }else{
                this.proximo.atualizar(produto);
            }
        }

    //Metodo para checar a existencia de produtos.
    public boolean existe (String nome){
        if(this.produto==null){
            return false;
        }else{
            if(this.produto.getNome().equals(nome)){
                return true;
            }else{
                return this.proximo.existe(nome);
            }
        }
    }
}
