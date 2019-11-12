package pedidos;

public class PedidoNaoEncontradoException extends Exception {

	public PedidoNaoEncontradoException() {
		super("Este pedido nao foi encontrado.");
	}
}
