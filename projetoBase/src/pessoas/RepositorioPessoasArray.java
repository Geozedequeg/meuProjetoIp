package pessoas;

public class RepositorioPessoasArray implements RepositorioPessoas {
    private Pessoa[] pessoas;
    private int indice;

    public RepositorioPessoasArray() {
        this.pessoas = new Pessoa[1];
        this.indice = 0;
    }

    public void inserir(Pessoa pessoa) {
		if (this.indice >= pessoas.length) {
			Pessoa[]aux = new Pessoa [this.indice];
			aux = this.pessoas;
			this.indice++;
			this.pessoas = new Pessoa [this.indice];
			for (int i = 0; i < (this.indice-1); i++) {
				this.pessoas[i] = aux[i];
			}
			this.pessoas[this.indice-1] = pessoa;
		} else {
			// O ARRAY pessoaS DE INDICE (this.indice) RECEBE O PARAMETRO (pessoas)
			this.pessoas[this.indice] = pessoa;
			// ADICIONA 1 AO INDICE
			this.indice++;
		}
    }

    public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
        int indicePessoa = this.getIndice(pessoa.getIdentificador());
        this.pessoas[indicePessoa] = pessoa;
    }

    public void remover(String codigo) throws PessoaNaoEncontradaException {
        int indicePessoa = this.getIndice(codigo);
        this.indice--;
        this.pessoas[indicePessoa] = this.pessoas[this.indice];
        this.pessoas[this.indice] = null;
    }

    public Pessoa procurar(String codigo) throws PessoaNaoEncontradaException {
        for (int i = 0; i < this.indice; i++) {
            if (pessoas[i].getIdentificador().equals(codigo)) {
                return pessoas[i];
            }
        }
        throw new PessoaNaoEncontradaException(codigo);
    }

    public boolean existe(String codigo) {
        for (int i = 0; i < this.indice; i++) {
            if (pessoas[i].getIdentificador().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    private int getIndice(String codigo) throws PessoaNaoEncontradaException {
        for (int i = 0; i < this.indice; i++) {
            if (pessoas[i].getIdentificador().equals(codigo)) {
                return i;
            }
        }
        throw new PessoaNaoEncontradaException(codigo);
    }
}