package pessoas;

public interface RepositorioPessoas {
    public void inserir(Pessoa pessoa);

    public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException;

    public void remover(String codigo) throws PessoaNaoEncontradaException;

    public Pessoa procurar(String codigo) throws PessoaNaoEncontradaException;

    public boolean existe(String codigo);
}