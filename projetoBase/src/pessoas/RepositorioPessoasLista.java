package pessoas;

public class RepositorioPessoasLista implements RepositorioPessoas {
    private Pessoa pessoa;
    private RepositorioPessoasLista proximo;

    public RepositorioPessoasLista() {
        this.pessoa = null;
        this.proximo = null;
    }

    public void inserir(Pessoa pessoa) {
        if (this.pessoa == null) {
            this.pessoa = pessoa;
            this.proximo = new RepositorioPessoasLista();
        } else {
            this.proximo.inserir(pessoa);
        }
    }

    public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
        if (this.pessoa == null) {
            throw new PessoaNaoEncontradaException(pessoa.getIdentificador());
        } else if (this.pessoa.getIdentificador().equals(pessoa.getIdentificador())) {
            this.pessoa = pessoa;
        } else {
            this.proximo.atualizar(pessoa);
        }
    }

    public void remover(String codigo) throws PessoaNaoEncontradaException {
        if (this.pessoa == null) {
            throw new PessoaNaoEncontradaException(codigo);
        } else if (this.pessoa.getIdentificador().equals(pessoa.getIdentificador())) {
            this.pessoa = this.proximo.pessoa;
            this.proximo = this.proximo.proximo;
        } else {
            this.proximo.remover(codigo);
        }
    }

    public Pessoa procurar(String codigo) throws PessoaNaoEncontradaException {
        if (this.pessoa == null) {
            throw new PessoaNaoEncontradaException(codigo);
        } else if (this.pessoa.getIdentificador().equals(codigo)) {
            return this.pessoa;
        } else {
            return this.proximo.procurar(codigo);
        }
    }

    public boolean existe(String codigo) {
        if (this.pessoa == null) {
            return false;
        } else if (this.pessoa.getIdentificador().equals(codigo)) {
            return true;
        } else {
            return this.proximo.existe(codigo);
        }
    }
}