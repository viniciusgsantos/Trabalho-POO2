package br.ufsc.cco.objects;

public enum NomeDeAtivo {
 
    BANCO_DO_BRASIL(0, "Banco do Brasil"),
    PETROBRAS(1, "Petrobras"),
    VALE(2, "Vale"),
    GOOGLE(3, "Google"),
    SANTANDER(4, "Santander");
    
    public final int id;
    public final String nome;
    
    NomeDeAtivo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
