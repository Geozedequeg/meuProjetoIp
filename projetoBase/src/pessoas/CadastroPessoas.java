package pessoas;

public class CadastroPessoas {
    private RepositorioPessoas repositorioPessoas;

    public CadastroPessoas(RepositorioPessoas repositorioPessoas) {
        this.repositorioPessoas = repositorioPessoas;
    }

    public void cadastrar(Pessoa pessoa) throws PessoaJaCadastradaException {
        if (this.repositorioPessoas.existe(pessoa.getIdentificador())) {
            throw new PessoaJaCadastradaException(pessoa.getNome());
        }
        this.repositorioPessoas.inserir(pessoa);
    }

    public void remover(String identificador) throws PessoaNaoEncontradaException {
        this.repositorioPessoas.remover(identificador);
    }

    public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
        this.repositorioPessoas.atualizar(pessoa);
    }

    public Pessoa procurar(String identificador) throws PessoaNaoEncontradaException {
        return this.repositorioPessoas.procurar(identificador);
    }

    public boolean existe(String identificador) {
        return this.repositorioPessoas.existe(identificador);
    }
}