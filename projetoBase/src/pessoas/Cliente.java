package pessoas;

import utils.Endereco;

public class Cliente extends Pessoa {
    public Cliente(String nome, Endereco endereco, String cpf) {
        super(nome, endereco, cpf);
    }

    public String getIdentificador() {
        return this.getCpf();
    }
}