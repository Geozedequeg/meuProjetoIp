package utils;

public class Endereco {
    private String cep;
    private String rua;
    private int numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String pontoReferencia;

    public Endereco(String cep, String rua, int numero, String complemento, String cidade, String estado, String pontoReferencia) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.pontoReferencia = pontoReferencia;
    }

    public String getCep() {
        return this.cep;
    }

    public String getRua() {
        return this.rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getPontoReferencia() {
        return this.pontoReferencia;
    }
}