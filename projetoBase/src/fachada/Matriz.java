package fachada;

import filiais.*;
import pedidos.*;
import pessoas.*;
import produtos.*;

public class Matriz {
    private CadastroPessoas cadastroPessoasFuncionarios;
    private CadastroPessoas cadastroPessoasClientes;
    private CadastroFiliais cadastroFiliais;
    private CadastroProdutos cadastroProdutos;
    private CadastroPedidos cadastroPedidos;

    public Matriz(RepositorioPessoas repositorioPessoasFuncionarios, RepositorioPessoas repositorioPessoasClientes, RepositorioFiliais repositorioFiliais, RepositorioProdutos repositorioProdutos, RepositorioPedidos repositorioPedidos) {
        this.cadastroPessoasFuncionarios = new CadastroPessoas(repositorioPessoasFuncionarios);
        this.cadastroPessoasClientes = new CadastroPessoas(repositorioPessoasClientes);
        this.cadastroFiliais = new CadastroFiliais(repositorioFiliais);
        this.cadastroProdutos = new CadastroProdutos(repositorioProdutos);
        this.cadastroPedidos = new CadastroPedidos(repositorioPedidos);
    }

    public void cadastrar(Cliente cliente) throws PessoaJaCadastradaException {
        cadastroPessoasClientes.cadastrar(cliente);
    }

    public void atualizar(Cliente cliente) throws PessoaNaoEncontradaException {
        cadastroPessoasClientes.atualizar(cliente);
    }

    public void removerCliente(String codigo) throws PessoaNaoEncontradaException {
        cadastroPessoasClientes.remover(codigo);
    }

    public Cliente procurarCliente(String codigo) throws PessoaNaoEncontradaException {
        return (Cliente) cadastroPessoasClientes.procurar(codigo);
    }

    public boolean existeCliente(String codigo) {
        return cadastroPessoasClientes.existe(codigo);
    }

    public void cadastrar(Funcionario cliente) throws PessoaJaCadastradaException {
        cadastroPessoasFuncionarios.cadastrar(cliente);
    }

    public void atualizar(Funcionario cliente) throws PessoaNaoEncontradaException {
        cadastroPessoasFuncionarios.atualizar(cliente);
    }

    public void removerFuncionario(String codigo) throws PessoaNaoEncontradaException {
        cadastroPessoasFuncionarios.remover(codigo);
    }

    public Funcionario procurarFuncionario(String codigo) throws PessoaNaoEncontradaException {
        return (Funcionario) cadastroPessoasClientes.procurar(codigo);
    }

    public boolean existeFuncionario(String codigo) {
        return cadastroPessoasFuncionarios.existe(codigo);
    }

    public void cadastrar(Filial filial) throws FilialJaCadastradaException {
        cadastroFiliais.cadastrar(filial);
    }

    public void atualizar(Filial filial) throws FilialNaoEncontradaException {
        cadastroFiliais.atualizar(filial);
    }

    public void removerFilial(int codigo) throws FilialNaoEncontradaException {
        cadastroFiliais.remover(codigo);
    }

    public Filial procurarFilial(int codigo) throws FilialNaoEncontradaException {
        return cadastroFiliais.procurar(codigo);
    }

    public boolean existeFilial(int codigo) {
        return cadastroFiliais.existe(codigo);
    }

    public void cadastrar(Produto produto) throws ProdutoJaCadastradoException {
        cadastroProdutos.cadastrar(produto);
    }

    public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
        cadastroProdutos.atualizar(produto);
    }

    public void removerProduto(String nome) throws ProdutoNaoEncontradoException {
        cadastroProdutos.remover(nome);
    }

    public Produto procurarProduto(String nome) throws ProdutoNaoEncontradoException {
        return cadastroProdutos.procurar(nome);
    }

    public boolean existeProduto(String nome) {
        return cadastroProdutos.existe(nome);
    }

    public void cadastrar(Pedido pedido) throws PedidoJaExistenteException, PessoaNaoEncontradaException {
        if (!existeCliente(pedido.getCliente().getIdentificador())) {
            throw new PessoaNaoEncontradaException(pedido.getCliente().getNome());
        } else if (!existeFuncionario(pedido.getFuncionario().getIdentificador())) {
            throw new PessoaNaoEncontradaException(pedido.getFuncionario().getNome());
        } else {
            cadastroPedidos.cadastrar(pedido);
        }
    }

    public void atualizar(Pedido pedido) throws PedidoNaoEncontradoException, PessoaNaoEncontradaException {
        if (!existeCliente(pedido.getCliente().getIdentificador())) {
            throw new PessoaNaoEncontradaException(pedido.getCliente().getNome());
        } else if (!existeFuncionario(pedido.getFuncionario().getIdentificador())) {
            throw new PessoaNaoEncontradaException(pedido.getFuncionario().getNome());
        } else {
            cadastroPedidos.atualizar(pedido);
        }
    }

    public void removerPedido(String codigo) throws PedidoNaoEncontradoException {
        cadastroPedidos.removerPedido(codigo);
    }

    public Pedido procurarPedido(String codigo) throws PedidoNaoEncontradoException {
        return cadastroPedidos.procurarPedido(codigo);
    }

    public boolean existePedido(String codigo) {
        return cadastroPedidos.existePedido(codigo);
    }

}
