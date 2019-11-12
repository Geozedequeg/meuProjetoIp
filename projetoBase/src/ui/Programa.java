package ui;

import fachada.Matriz;
import filiais.*;
import pedidos.*;
import pessoas.*;
import produtos.Produto;
import produtos.RepositorioProdutos;
import produtos.RepositorioProdutosArray;
import produtos.RepositorioProdutosLista;
import utils.Endereco;

public class Programa {

    public static void main(String[] args) {
        RepositorioPessoas repositorioPessoasClientes = new RepositorioPessoasArray();
        // RepositorioPessoas repositorioPessoasClientes = new RepositorioPessoasLista();

        RepositorioPessoas repositorioPessoasFuncionarios = new RepositorioPessoasLista();
        // RepositorioPessoas repositorioPessoasFuncionarios = new RepositorioPessoasArray();

        //RepositorioPedidos repositorioPedidos = new RepositorioPedidosLista();
        RepositorioPedidos repositorioPedidos = new RepositorioPedidosArray(1);

        RepositorioProdutos repositorioProdutos = new RepositorioProdutosLista();
        //RepositorioProdutos repositorioProdutos = new RepositorioProdutosArray(1);

        RepositorioFiliais repositorioFiliais = new RepositorioFiliaisArray(1);
        //RepositorioFiliais repositorioFiliais = new RepositorioFiliaisLista();

        Matriz fachada = new Matriz(repositorioPessoasClientes, repositorioPessoasFuncionarios, repositorioFiliais, repositorioProdutos, repositorioPedidos);


        System.out.println("---TESTE DE VALOR INVALIDO---");
        //Deve cadastrar um produto de valor negativo ou zero e falhar.
        try {
            Produto produtoValorInvalido = new Produto("Galeto", "Nada", -1.00);
            fachada.cadastrar(produtoValorInvalido);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---TESTE DE CADASTRAR PRODUTO---");
        //Deve cadastrar um produto.
        try {
            Produto produtoTeste = new Produto("Tapiocao", "Queijo", 2.00);
            fachada.cadastrar(produtoTeste);
            System.out.println(produtoTeste.getNome() + " cadastrado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Tenta cadastrar um produto jï¿½ cadastrado anteriormente e falhar.
        try {
            Produto produtoTeste = new Produto("Tapiocao", "Queijo", 2.00);
            fachada.cadastrar(produtoTeste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---TESTE DE PROCURAR PRODUTO---");
        //Deve procurar um produto que existe.
        try {
            Produto produto = fachada.procurarProduto("Tapiocao");
            System.out.println(produto.getNome() + " encontrado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Tenta procurar um produto que nï¿½o existe e falha.
        try {
            Produto produto = fachada.procurarProduto("Galeto");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---TESTE DE ATUALIZAR PRODUTO---");
        //Deve atualizar um pedidos jï¿½ cadastrado.
        try {
            Produto novoProduto = new Produto("Tapiocao", "Presunto", 2.50);
            fachada.atualizar(novoProduto);
            System.out.println(novoProduto.getNome() + " atualizado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Tenta atualizar um produto que nï¿½o existe e falha.
        try {
            Produto produtoInvalido = new Produto("Galeto", "Nada", 5.00);
            fachada.atualizar(produtoInvalido);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---TESTE DE EXISTE PRODUTO---");
        boolean produtoExiste;
        //Procura se um produto jï¿½ cadastrado existe.
        try {
            Produto produtoTeste = new Produto("Tapiocao", "Queijo", 2.00);
            produtoExiste = fachada.existeProduto(produtoTeste.getNome());
            System.out.println("O produto existe no sistema: " + produtoExiste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Procura se um produto nï¿½o cadastrado existe.
        produtoExiste = fachada.existeProduto("Galeto");
        System.out.println("O produto existe no sistema: " + produtoExiste);

        System.out.println("---TESTE DE REMOVER PRODUTO---");
        //Deve remover um produto existe.
        try {
            Produto produtoTeste = new Produto("Tapiocao", "Queijo", 2.00);
            fachada.removerProduto(produtoTeste.getNome());
            System.out.println(produtoTeste.getNome() + " foi removido com sucesso.");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        //Tenta remover um produto que nï¿½o existe e falha.
        try {
            fachada.removerProduto("Galeto");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // PEDIDOS


        String codigo1 = "001";
        String codigo2 = "002";
        String codigo3 = "003";

        //RepositorioProdutosLista produto = new RepositorioProdutosLista();
        RepositorioProdutosArray produto = new RepositorioProdutosArray(1);

        // ENDERECO DE CLIENTE E FUNCIONARIO (AMBAS AS CLASSES PRECISAM DE ENDERECO)
        Endereco endereco = new Endereco("50740-445", "Rua dos Bobos", 0, null, "Recife", "PE", "Casinha");

        Cliente cliente1 = new Cliente("Joao Pedro", endereco, "789.654.321-00");
        Funcionario funcionario1 = new Funcionario("Tia", endereco, "321.654.987-00", "1");

        Cliente cliente2 = new Cliente("Matheus Correia", endereco, "789.654.321-10");
        Funcionario funcionario2 = new Funcionario("Tio", endereco, "321.654.987-10", "2");

        try {
            fachada.cadastrar(cliente1);
            fachada.cadastrar(cliente2);
            fachada.cadastrar(funcionario1);
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
        System.out.println("\n" + "----- CADASTRAR DOIS PEDIDOS -----" + "\n");
        try {
            Pedido pedido = new Pedido(codigo1, produto, cliente1, funcionario1);
            fachada.cadastrar(pedido);
            System.out.println("O pedido " + pedido.getCodigo() + " foi cadastrado." + "\n");
            Pedido pedido2 = new Pedido(codigo2, produto, cliente1, funcionario1);
            fachada.cadastrar(pedido2);
            System.out.println("O pedido " + pedido2.getCodigo() + " foi cadastrado." + "\n");
        } catch (PedidoJaExistenteException pedidoJaExistente) {
            System.out.println(pedidoJaExistente.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- CADASTRAR UM PEDIDO JA EXISTENTE -----" + "\n");
        try {
            Pedido pedido = new Pedido(codigo1, produto, cliente1, funcionario1);
            fachada.cadastrar(pedido);
            System.out.println("O pedido " + pedido.getCodigo() + " foi cadastrado." + "\n");
        } catch (PedidoJaExistenteException pedidoJaExistente) {
            System.out.println(pedidoJaExistente.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- CADASTRAR UM PEDIDO COM FUNCIONARIO NAO EXISTENTE -----" + "\n");
        try {
            Pedido pedido = new Pedido(codigo1, produto, cliente2, funcionario2);
            fachada.cadastrar(pedido);
            System.out.println("O pedido " + pedido.getCodigo() + " foi cadastrado." + "\n");
        } catch (PedidoJaExistenteException pedidoJaExistente) {
            System.out.println(pedidoJaExistente.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- ATUALIZAR UM PEDIDO -----" + "\n");
        try {
            Pedido pedido = new Pedido(codigo1, produto, cliente1, funcionario1);
            Pedido pedidoAtualizar = new Pedido(codigo1, produto, cliente2, funcionario1);
            fachada.atualizar(pedidoAtualizar);
            System.out.println("O pedido " + pedido.getCodigo() + " foi atualizado." + "\n");
        } catch (PedidoNaoEncontradoException pedidoNaoEncontrado) {
            System.out.println(pedidoNaoEncontrado.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- ATUALIZAR UM PEDIDO NAO EXISTENTE -----" + "\n");
        try {
            Pedido pedido = new Pedido(codigo3, produto, cliente1, funcionario1);
            fachada.atualizar(pedido);
            System.out.println("O pedido " + pedido.getCodigo() + " foi atualizado." + "\n");
        } catch (PedidoNaoEncontradoException pedidoNaoEncontrado) {
            System.out.println(pedidoNaoEncontrado.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- ATUALIZAR UM PEDIDO COM UM FUNCIONARIO NAO EXISTENTE -----" + "\n");
        try {
            Pedido pedido = new Pedido(codigo1, produto, cliente2, funcionario2);
            fachada.atualizar(pedido);
            System.out.println("O pedido " + pedido.getCodigo() + " foi atualizado." + "\n");
        } catch (PedidoNaoEncontradoException pedidoNaoEncontrado) {
            System.out.println(pedidoNaoEncontrado.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- PROCURAR UM PEDIDO -----" + "\n");
        try {
            Pedido pedido = new Pedido(codigo1, produto, cliente1, funcionario1);
            fachada.procurarPedido(codigo1);
            System.out.println("O pedido " + pedido.getCodigo() + " foi encontrado." + "\n");
        } catch (PedidoNaoEncontradoException PedidoNaoEncontrado) {
            System.out.println(PedidoNaoEncontrado.getMessage() + "\n");
        }
        System.out.println("----- PROCURAR UM PEDIDO NAO EXISTENTE -----" + "\n");
        try {
            Pedido pedido = new Pedido(codigo3, produto, cliente1, funcionario1);
            fachada.procurarPedido(codigo3);
            System.out.println("O pedido " + pedido.getCodigo() + " foi encontrado." + "\n");
        } catch (PedidoNaoEncontradoException PedidoNaoEncontrado) {
            System.out.println(PedidoNaoEncontrado.getMessage() + "\n");
        }
        System.out.println("----- REMOVER UM PEDIDO -----" + "\n");
        try {
            Pedido pedido = new Pedido(codigo1, produto, cliente1, funcionario1);
            fachada.removerPedido(codigo1);
            System.out.println("O pedido " + pedido.getCodigo() + " foi removido." + "\n");
        } catch (PedidoNaoEncontradoException PedidoNaoEncontrado) {
            System.out.println(PedidoNaoEncontrado.getMessage() + "\n");
        }
        System.out.println("----- REMOVER UM PEDIDO NAO EXISTENTE -----" + "\n");
        try {
            Pedido pedido = new Pedido(codigo1, produto, cliente1, funcionario1);
            fachada.removerPedido(codigo1);
            System.out.println("O pedido " + pedido.getCodigo() + " foi removido." + "\n");
        } catch (PedidoNaoEncontradoException PedidoNaoEncontrado) {
            System.out.println(PedidoNaoEncontrado.getMessage() + "\n");
        }
        System.out.println("----- VER SE OS PEDIDOS EXISTEM -----" + "\n");
        boolean pedidoExiste = fachada.existePedido(codigo1);
        System.out.println("O pedido " + codigo1 + " existe: " + pedidoExiste);
        boolean pedido2Existe = fachada.existePedido(codigo2);
        System.out.println("O pedido " + codigo2 + " existe: " + pedido2Existe);
        boolean pedido3Existe = fachada.existePedido(codigo3);
        System.out.println("O pedido " + codigo3 + " existe: " + pedido3Existe + "\n");


        // CLIENTES
        Endereco enderecoTeste = new Endereco("50740-445", "Rua dos Bobos", 0, null, "Recife", "PE", "Casinha");

        String CPF_CLIENTE_TESTE = "85000205049";
        Cliente clienteTeste = new Cliente("Joao Pedro", enderecoTeste, CPF_CLIENTE_TESTE);

        /* TESTES DE CADASTRAR CLIENTE */
        System.out.println("----- TESTES DE CADASTRAR CLIENTE -----");
        // Deve cadastrar um cliente no Cadastro de Clientes
        try {
            fachada.cadastrar(clienteTeste);
            System.out.println(clienteTeste.getNome() + " cadastrado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Deve tentar cadastrar o mesmo Cliente no Cadastro novamente e falhar
        try {
            fachada.cadastrar(clienteTeste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE PROCURAR CLIENTE */
        System.out.println("----- TESTES DE PROCURAR CLIENTE -----");
        // Busca um cliente que existe
        try {
            Cliente cliente = fachada.procurarCliente(CPF_CLIENTE_TESTE);
            System.out.println(cliente.getNome() + " encontrado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Busca um cliente que nao existe
        try {
            Cliente cliente = fachada.procurarCliente("123");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE ATUALIZAR CLIENTE */
        System.out.println("----- TESTES DE ATUALIZAR CLIENTE -----");
        // Atualiza um cliente que existe
        try {
            Cliente novoCliente = new Cliente("Matheus", enderecoTeste, CPF_CLIENTE_TESTE);
            fachada.atualizar(novoCliente);
            System.out.println(novoCliente.getNome() + " atualizado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Atualiza um cliente que nao existe
        try {
            Cliente novoClienteNaoExiste = new Cliente("Troll", enderecoTeste, "123");
            fachada.atualizar(novoClienteNaoExiste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE EXISTE CLIENTE */
        System.out.println("----- TESTES DE EXISTE CLIENTE -----");
        // Busca um cliente que existe
        boolean clienteExiste = fachada.existeCliente(clienteTeste.getIdentificador());
        System.out.println("O cliente buscado existe: " + clienteExiste);

        // Busca um cliente que nao existe
        clienteExiste = fachada.existeCliente("0");
        System.out.println("O cliente buscado existe: " + clienteExiste);

        /* TESTES DE REMOVER CLIENTE */
        System.out.println("----- TESTES DE REMOVER CLIENTE -----");
        // Remove um cliente que existe
        try {
            fachada.removerCliente(clienteTeste.getIdentificador());
            System.out.println(clienteTeste.getNome() + " removido com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Remove um cliente que nao existe
        try {
            fachada.removerCliente("123");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // FUNCIONARIOS

        String CPF_FUNCIONARIO_TESTE = "85000205049";
        String MATRICULA_FUNCIONARIO = "1234";
        Funcionario FuncionarioTeste = new Funcionario("Joao Pedro", enderecoTeste, CPF_FUNCIONARIO_TESTE, MATRICULA_FUNCIONARIO);

        /* TESTES DE CADASTRAR Funcionario */
        System.out.println("----- TESTES DE CADASTRAR Funcionario -----");
        // Deve cadastrar um Funcionario no Cadastro de Funcionarios
        try {
            fachada.cadastrar(FuncionarioTeste);
            System.out.println(FuncionarioTeste.getNome() + " cadastrado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Deve tentar cadastrar o mesmo Funcionario no Cadastro novamente e falhar
        try {
            fachada.cadastrar(FuncionarioTeste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE PROCURAR Funcionario */
        System.out.println("----- TESTES DE PROCURAR Funcionario -----");
        // Busca um Funcionario que existe
        try {
            Funcionario Funcionario = fachada.procurarFuncionario(CPF_FUNCIONARIO_TESTE);
            System.out.println(Funcionario.getNome() + " encontrado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Busca um Funcionario que nao existe
        try {
            Funcionario Funcionario = fachada.procurarFuncionario("123");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE ATUALIZAR Funcionario */
        System.out.println("----- TESTES DE ATUALIZAR Funcionario -----");
        // Atualiza um Funcionario que existe
        try {
            Funcionario novoFuncionario = new Funcionario("Matheus", enderecoTeste, CPF_FUNCIONARIO_TESTE, MATRICULA_FUNCIONARIO);
            fachada.atualizar(novoFuncionario);
            System.out.println(novoFuncionario.getNome() + " atualizado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Atualiza um Funcionario que nao existe
        try {
            Funcionario novoFuncionarioNaoExiste = new Funcionario("Troll", enderecoTeste, "123", MATRICULA_FUNCIONARIO);
            fachada.atualizar(novoFuncionarioNaoExiste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE EXISTE Funcionario */
        System.out.println("----- TESTES DE EXISTE Funcionario -----");
        // Busca um Funcionario que existe
        boolean FuncionarioExiste = fachada.existeFuncionario(FuncionarioTeste.getIdentificador());
        System.out.println("O Funcionario buscado existe: " + FuncionarioExiste);

        // Busca um Funcionario que nao existe
        FuncionarioExiste = fachada.existeFuncionario("0");
        System.out.println("O Funcionario buscado existe: " + FuncionarioExiste);

        /* TESTES DE REMOVER Funcionario */
        System.out.println("----- TESTES DE REMOVER Funcionario -----");
        // Remove um Funcionario que existe
        try {
            fachada.removerFuncionario(FuncionarioTeste.getIdentificador());
            System.out.println(FuncionarioTeste.getNome() + " removido com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Remove um Funcionario que nao existe
        try {
            fachada.removerFuncionario("123");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Endereco endereco1 = new Endereco("55820-000", "Rua Jose Cavalcanti", 99, "Zona quase rural", "Atui", "Estado Livre de Direito", "Ao lado do Amorintel");
        Endereco endereco2 = new Endereco("92201-20", "Rua João de Lira", 456, "Centro", "Afogados", "Amazonas", "Ao lado da oficina de seu Zé");
        Filial filial1 = new Filial(4558, "Tairone da mandioca", endereco1, repositorioPessoasFuncionarios, repositorioPedidos);
        Filial filial2 = new Filial(488, "Tapiocaria da Steffany", endereco2, repositorioPessoasFuncionarios, repositorioPedidos);
        Filial filial3 = new Filial(488, "Tapiocaria da Steffany", endereco1, repositorioPessoasFuncionarios, repositorioPedidos);

        //FILIAL

        //CADASTRAR

        //Cadastro Filial
        try {
            System.out.println("\n\n*********************\n* Teste de cadastro *\n*********************\n");
            fachada.cadastrar(filial1);
            System.out.println("A filial " + filial1.getNome() + " foi cadastrada com sucesso.");
        } catch (FilialJaCadastradaException e) {
            System.out.println(e.getMessage());
        }

        //Cadastro Repetido
        try {
            System.out.println("\n******************************\n* Teste de cadastro repetido *\n******************************\n");
            fachada.cadastrar(filial2);
            System.out.println("A filial " + filial2.getNome() + " foi cadastrada com sucesso.");
            fachada.cadastrar(filial1);
            System.out.println("A filial " + filial1.getNome() + " foi cadastrada com sucesso.");
        } catch (FilialJaCadastradaException e) {
            System.out.println(e.getMessage());
        }

        //REMOVER

        // Remocao filial
        try {
            System.out.println("\n********************\n* Teste de remocao *\n********************\n");
            fachada.removerFilial(4558);
            System.out.println("A filial foi removida com sucesso.");
        } catch (FilialNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        // Remocao filial inexistente

        try {
            System.out.println("\n******************************************\n* Teste de remocao de filial inexistente *\n******************************************\n");
            fachada.removerFilial(4558);
            System.out.println("A filial foi removida com sucesso.");
        } catch (FilialNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        // Atualizar

        // Atualizacao filial
        try {
            System.out.println("\n************************\n* Teste de atualizacao *\n************************\n");
            fachada.atualizar(filial3);
            System.out.println("A filial " + filial3.getNome() + " foi atualizada com sucesso.");
        } catch (FilialNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        // Atualizacao filial inexistente
        try {
            System.out.println("\n**********************************************\n* Teste de atualizacao de filial inexistente *\n**********************************************\n");
            fachada.atualizar(filial1);
            System.out.println("A filial " + filial3.getNome() + " foi atualizada com sucesso.");
        } catch (FilialNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        // PROCURAR

        // Procura filial
        try {
            System.out.println("\n********************\n* Teste de procura *\n********************\n");
            Filial filial4 = fachada.procurarFilial(488);
            System.out.println("A filial com o código " + 488 + " é " + filial4.getNome() + ".");
        } catch (FilialNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        // Procura filial inexistente
        try {
            System.out.println("\n******************************************\n* Teste de procura de filial inexistente *\n******************************************\n");
            fachada.procurarFilial(4558);
            System.out.println("A filial com o código " + 4558 + " é " + filial1.getNome() + ".");
        } catch (FilialNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        //EXISTE

        System.out.println("\n************************\n * Teste de Existencia *\n************************\n");
        boolean filial1Existe = fachada.existeFilial(4558);
        boolean filial2Existe = fachada.existeFilial(488);
        System.out.println("O código " + 4558 + " existe: " + filial1Existe);
        System.out.println("O código " + 488 + " existe: " + filial2Existe);
    }

}

