package pedidos;

public interface RepositorioPedidos {
	
	public void inserir(Pedido pedido);
	public void atualizar (Pedido pedido) throws PedidoNaoEncontradoException;
	public void remover (String codigo) throws PedidoNaoEncontradoException;
	public Pedido procurar (String codigo) throws PedidoNaoEncontradoException;
	public boolean existe (String codigo);
	
}
