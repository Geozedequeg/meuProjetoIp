package pessoas;

public class PessoaNaoEncontradaException extends Exception {
    private String codigo;

    public PessoaNaoEncontradaException(String codigo) {
        super("A pessoa procurada nao foi encontrada.");
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}