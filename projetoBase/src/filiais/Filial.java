package filiais;

import pedidos.*;
import pessoas.*;
import utils.*;

public class Filial {
	private int codigo;
	private String nome;
	private Endereco endereco;
	private RepositorioPessoas funcionarios;
	private RepositorioPedidos pedidos;
	
	public Filial(int codigo, String nome, Endereco endereco, RepositorioPessoas funcionarios, RepositorioPedidos pedidos) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.funcionarios = funcionarios;
		this.pedidos = pedidos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public RepositorioPessoas getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(RepositorioPessoas funcionarios) {
		this.funcionarios = funcionarios;
	}

	public RepositorioPedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(RepositorioPedidos pedidos) {
		this.pedidos = pedidos;
	}
	
	
}