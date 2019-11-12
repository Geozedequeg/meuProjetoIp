package produtos;

public class ValorInvalidoException extends Exception {
    //Erro caso tente inserir um produto de valor negativo ou zero.
    public ValorInvalidoException() {
        super ("Valor invalido.");

    }
}
