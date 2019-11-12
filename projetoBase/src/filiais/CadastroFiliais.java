package filiais;

public class CadastroFiliais {
	private RepositorioFiliais repositorioFiliais;
	
	public CadastroFiliais (RepositorioFiliais repositorioFiliais)
	{
		this.repositorioFiliais = repositorioFiliais;
	}
	
	public void cadastrar (Filial filial) throws FilialJaCadastradaException
	{
		if(this.repositorioFiliais.existe(filial.getCodigo()))
		{
			throw new FilialJaCadastradaException(filial.getNome());
		}
		this.repositorioFiliais.inserir(filial);
	}
	
	public Filial procurar (int codigo) throws FilialNaoEncontradaException
	{
		return this.repositorioFiliais.procurar(codigo);
	}
	
	public void remover (int codigo) throws FilialNaoEncontradaException
	{
		this.repositorioFiliais.remover(codigo);
	}
	
	public void atualizar (Filial filial) throws FilialNaoEncontradaException
	{
		this.repositorioFiliais.atualizar(filial);
	}
	
	public boolean existe (int codigo)
	{
		return this.repositorioFiliais.existe(codigo);
	}
}
