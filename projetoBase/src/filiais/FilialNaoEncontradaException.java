package filiais;

public class FilialNaoEncontradaException extends Exception {
	public FilialNaoEncontradaException(int codigo)
	{
		super("A filial nao pertence a nossa franquia. O codigo " + codigo + " esta errado!");
	}
}
