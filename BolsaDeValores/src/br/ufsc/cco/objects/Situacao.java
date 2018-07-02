package br.ufsc.cco.objects;

public enum Situacao {
    DEU_VENDA("Deu venda!"),
    DEU_COMPRA("Deu compra!"),
    AGUARDANDO("Aguardando"),
    ESTAVEL("Estável");
    
    public final String mensagem;
    
    Situacao(String texto) {
        this.mensagem = texto;
    }
}
