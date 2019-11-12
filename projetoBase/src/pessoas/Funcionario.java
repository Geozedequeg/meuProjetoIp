package pessoas;

import utils.Endereco;

public class Funcionario extends Pessoa {
    private String matricula;

    public Funcionario(String nome, Endereco endereco, String cpf, String matricula) {
        super(nome, endereco, cpf);
        this.matricula = matricula;
    }

    public String getIdentificador() {
        return this.matricula;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}