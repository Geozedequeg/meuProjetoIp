package filiais;

public class RepositorioFiliaisLista implements	RepositorioFiliais {
	private Filial filial;
	private RepositorioFiliaisLista proximo;
	
	public RepositorioFiliaisLista ()
	{
		this.filial = null;
		this.proximo = null;
	}
	
	public void inserir (Filial filial)
	{
		if (this.filial==null)
		{
			this.filial = filial;
			this.proximo = new RepositorioFiliaisLista ();
		}
		else
		{
			this.proximo.inserir(filial);
		}
	}
	
	public void atualizar (Filial filial) throws FilialNaoEncontradaException
	{
		if(this.filial==null)
		{
			throw new FilialNaoEncontradaException(filial.getCodigo());
		}
		else
		{
			if (this.filial.getCodigo()==filial.getCodigo())
			{
				this.filial = filial;
			}
			else
			{
				this.proximo.atualizar(filial);
			}
		}
	}
	
	public void remover (int codigo) throws FilialNaoEncontradaException
	{
		if(this.filial==null)
		{
			throw new FilialNaoEncontradaException(codigo);
		}
		else
		{
			if(this.filial.getCodigo()==codigo)
			{
				this.filial = this.proximo.filial;
				this.proximo = this.proximo.proximo;
			}
			else
			{
				this.proximo.remover(codigo);
			}
		}
	}
	
	public Filial procurar (int codigo) throws FilialNaoEncontradaException
	{
		if(this.filial==null)
		{
			throw new FilialNaoEncontradaException(codigo);
		}
		else
		{
			if(this.filial.getCodigo()==codigo)
			{
				return this.filial;
			}
			else
			{
				return this.proximo.procurar(codigo);
			}
		}
	}
	
	public boolean existe (int codigo)
	{
		if(this.filial==null)
		{
			return false;
		}
		else
		{
			if(this.filial.getCodigo()==codigo)
			{
				return true;
			}
			else
				return this.proximo.existe(codigo);
		}
	}
}
