package pedidos;

public class PedidoJaExistenteException extends Exception {
	
	public PedidoJaExistenteException () {
		super ("Este pedido ja existe.");
	}
}
