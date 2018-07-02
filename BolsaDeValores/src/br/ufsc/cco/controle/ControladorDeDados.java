/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.cco.controle;

import br.ufsc.cco.objects.Ativo;
import java.util.HashMap;

public class ControladorDeDados {
    
    private static ControladorDeDados instance;
    private final HashMap<String, Ativo> ativos;
    
    private ControladorDeDados() {
        ativos = new HashMap<>();
    }
    
    public void adicionarAtivo(String key, Ativo ativo) {
        ativos.put(key, ativo);
    }
    
    public void adicionarAtivos(Ativo[] ativos) {
        for (Ativo ativo : ativos) {
            this.ativos.put(ativo.getNome(), ativo);
        }
    }
    
    public void removerAtivo(String key) {
        ativos.remove(key);
    }
    
    public Ativo getAtivo(String key) {
        return ativos.get(key);
    }
    
    public HashMap<String, Ativo> getAtivos() {
        return ativos;
    }
    
    public static ControladorDeDados getInstance() {
        if(instance == null) {
            instance = new ControladorDeDados();
        }
        return instance;
    }
}
