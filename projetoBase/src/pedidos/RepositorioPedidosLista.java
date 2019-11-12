package pedidos;

public class RepositorioPedidosLista implements RepositorioPedidos {

	private Pedido pedido;
	private RepositorioPedidosLista proximo;

	public RepositorioPedidosLista() {

	}
	
	public void inserir(Pedido pedido) {
		// SE ESTIVER NO FIM DA LISTA
		if (this.pedido == null) {
			this.pedido = pedido;
			this.proximo = new RepositorioPedidosLista();
		} else {
			// SE NAO --> RECURSAO DO METODO NO PROXIMO
			this.proximo.inserir(pedido);
		}
	}
	
	public void atualizar(Pedido pedido) throws PedidoNaoEncontradoException {
		// SE ESTIVER NO FIM DA LISTA
		if (this.pedido == null) {
			// DE O ERRO --> PEDIDO NAO ENCONTRADO
			throw new PedidoNaoEncontradoException();
		} else {
			// SE O CODIGO DO PEDIDO EM QUE ESTOU FOR IGUAL AO CODIGO DO PEDIDO DO PARAMETRO
			if (this.pedido.getCodigo().equals(pedido.getCodigo())) {
				// ATUALIZE O PEDIDO
				this.pedido = pedido;
			} else {
				// SE NAO --> RECURSAO DO METODO NO PROXIMO
				this.proximo.atualizar(pedido);
			}
		}
	}
	
	public void remover(String codigo) throws PedidoNaoEncontradoException {
		// SE ESTIVER NO FIM DA LISTA
		if (this.pedido == null) {
			// DE O ERRO --> PEDIDO NAO ENCONTRADO
			throw new PedidoNaoEncontradoException();
		} else {
			// SE O CODIGO DO PEDIDO EM QUE ESTOU FOR IGUAL AO CODIGO DO PEDIDO DO PARAMETRO
			if (this.pedido.getCodigo().equals(codigo)) {
				// O PEDIDO EM QUE ESTOU RECEBE O PROXIMO
				this.pedido = this.proximo.pedido;
				// O PROXIMO RECEBE O PROXIMO
				this.proximo = this.proximo.proximo;
			} else {
				// SE NAO --> RECURSAO DO METODO NO PROXIMO
				this.proximo.remover(codigo);
			}
		}
	}
	
	public Pedido procurar(String codigo) throws PedidoNaoEncontradoException {
		// SE ESTIVER NO FIM DA LISTA
		if (this.pedido == null) {
			// DE O ERRO --> PEDIDO NAO ENCONTRADO
			throw new PedidoNaoEncontradoException();
		} else {
			// SE O CODIGO DO PEDIDO EM QUE ESTOU FOR IGUAL AO CODIGO DO PEDIDO DO PARAMETRO
			if (this.pedido.getCodigo().equals(codigo)) {
				// RETORNE O PEDIDO EM QUE ESTOU
				return this.pedido;
			} else {
				// SE NAO --> RECURSAO DO METODO NO PROXIMO
				return this.proximo.procurar(codigo);
			}
		}
	}
	
	public boolean existe(String codigo) {
		// SE ESTIVER NO FIM DA LISTA
		if (this.pedido == null) {
			// NAO ACHEI
			return false;
		} else {
			// SE O CODIGO DO PEDIDO EM QUE ESTOU FOR IGUAL AO CODIGO DO PEDIDO DO PARAMETRO
			if (this.pedido.getCodigo().equals(codigo)) {
				return true;
			} else {
				// SE NAO --> RECURSAO DO METODO NO PROXIMO
				return this.proximo.existe(codigo);
			}
		}
	}
}