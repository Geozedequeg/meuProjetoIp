package produtos;

public class RepositorioProdutosArray implements RepositorioProdutos{

    private Produto[] produtos;
    private int indice;

    public RepositorioProdutosArray(int tamanho){
        this.produtos = new Produto[tamanho];
        this.indice = 0;
    }

    //Metodo para inserir novos produtos.
    //Caso tente inserir mais produtos com o array cheio, o tamanho do array é alterado para receber mais produtos.
    public void inserir(Produto produto){
        if(this.indice==this.produtos.length) {
        	Produto[]auxiliar = new Produto[this.indice];
        	auxiliar = this.produtos;
        	indice++;
        	this.produtos = new Produto[this.indice];
        	for(int i = 0; i < this.indice-1; i++) {
        		this.produtos[i] = auxiliar[i];
        	}
        	this.produtos[this.indice-1] = produto;
        }else{
        	this.produtos[this.indice] = produto;
        	this.indice++;
        }
    }

    //Metodo para procurar por produtos.
    public Produto procurar(String nome)
    throws ProdutoNaoEncontradoException{
        Produto resposta = null;
        int auxiliar = this.getIndice(nome);
        if(auxiliar == this.indice) {
            throw new ProdutoNaoEncontradoException(nome);
        }else{
            resposta = this.produtos[auxiliar];
        }
        return resposta;
    }

    //Metodo para remover produtos.
    public void remover (String nome)
    throws ProdutoNaoEncontradoException{
        int auxiliar = this.getIndice(nome);
        if (auxiliar == this.indice) {
            throw new ProdutoNaoEncontradoException(nome);
        }else{
            this.indice--;
            this.produtos[auxiliar] = this.produtos[this.indice];
            this.produtos[this.indice] = null;

        }

    }

    //Metodo para atualizar produtos.
    public void atualizar (Produto produto)
        throws ProdutoNaoEncontradoException {
        int auxiliar = this.getIndice(produto.getNome());
        if (auxiliar == this.indice) {
            throw new ProdutoNaoEncontradoException(produto.getNome());
        } else {
            this.produtos[auxiliar] = produto;
        }
    }

    //Metodo para checar a existencia de produtos.
    public boolean existe (String nome){
        int auxiliar = this.getIndice(nome);
        return (auxiliar !=this.indice);
    }

    public int getIndice(String nome) {
        String normal;
        boolean achado = false;
        int auxiliar = 0;
        while((!achado) && (auxiliar < this.indice)){
            normal = produtos[auxiliar].getNome();
            if (normal.equals(nome)){
                achado = true;
            }else{
                auxiliar = auxiliar + 1;
            }
        }
        return auxiliar;
    }
}
