package pedidos;

import pessoas.Cliente;
import pessoas.Funcionario;
import produtos.RepositorioProdutos;

public class Pedido {
	private String codigo;
	private RepositorioProdutos repositorioProduto;
	private Cliente cliente;
	private Funcionario funcionario;

	public Pedido(String codigo, RepositorioProdutos produtos, Cliente cliente, Funcionario funcionario) {
		this.codigo = codigo;
		this.repositorioProduto = produtos;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public String getCodigo() {
		return codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public RepositorioProdutos getProdutos() {
		return repositorioProduto;
	}
}