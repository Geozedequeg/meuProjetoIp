package filiais;

public interface RepositorioFiliais {
	public void inserir (Filial filial);
	public void atualizar (Filial filial) throws FilialNaoEncontradaException;
	public void remover (int codigo) throws FilialNaoEncontradaException;
	public Filial procurar (int codigo) throws FilialNaoEncontradaException;
	public boolean existe (int codigo);
}
