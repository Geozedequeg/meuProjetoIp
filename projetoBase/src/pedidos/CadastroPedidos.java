package pedidos;

public class CadastroPedidos {

	private RepositorioPedidos repositorioPedidos;

	public CadastroPedidos (RepositorioPedidos repositorioPedidos) {
		this.repositorioPedidos = repositorioPedidos;
	}

	public void cadastrar (Pedido pedido) throws PedidoJaExistenteException {
		// SE JA EXISTIR UM PEDIDO COM ESSE CODIGO
		if (this.repositorioPedidos.existe(pedido.getCodigo())) {
			// DE O ERRO --> PEDIDO JA EXISTENTE
			throw new PedidoJaExistenteException();
		} else {
			this.repositorioPedidos.inserir(pedido);
		}
	}

	public void removerPedido (String codigo) throws PedidoNaoEncontradoException {
		// ESSE METODO JA PODE DAR O ERRO ACIMA
		this.repositorioPedidos.remover(codigo);
	}

	public void atualizar (Pedido pedido) throws PedidoNaoEncontradoException{
		// ESSE METODO JA PODE DAR O ERRO ACIMA
		this.repositorioPedidos.atualizar(pedido);
	}

	public Pedido procurarPedido (String codigo) throws PedidoNaoEncontradoException {
		// ESSE METODO JA PODE DAR O ERRO ACIMA
		return this.repositorioPedidos.procurar(codigo);
	}

	public boolean existePedido (String codigo) {
		return this.repositorioPedidos.existe(codigo);
	}
}