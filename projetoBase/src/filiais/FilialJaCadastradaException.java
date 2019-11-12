package filiais;

public class FilialJaCadastradaException extends Exception{
	public FilialJaCadastradaException (String nome)
	{
		super("A filial " + nome + " ja pertence a nossa franquia!");
	}
}
