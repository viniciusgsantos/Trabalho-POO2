/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.cco.controle;

import br.ufsc.cco.objects.Ativo;
import br.ufsc.cco.objects.Atributo;
import br.ufsc.cco.telas.TelaPrincipal;
import java.awt.Color;
import java.util.Map.Entry;

public class ControladorDeTela {
    
    private static ControladorDeTela instance;
    private final TelaPrincipal tela;
    private boolean monitorando;
    
    private ControladorDeTela() {
        tela = new TelaPrincipal();
        monitorando = false;
    }
    
    public static ControladorDeTela getInstance() {
        if(instance == null) {
            instance = new ControladorDeTela();
        }
        return instance;
    }
    
    public void setCelula(String linha, Atributo coluna, String dado, Color color) {
        switch (linha) {
            case "Banco do Brasil":
                switch(coluna) {
                    case CLOSE:
                        tela.getlCloseBB().setForeground(color);
                        tela.getlCloseBB().setText("BRL " + dado);
                        break;
                    case SMA:
                        tela.getlSMABB().setText("BRL " + dado);
                        break;
                    case SITUACAO:
                        tela.getlSitBB().setText(dado);
                        break;
                    default:
                        break;
                }
                break;
            case "Google":
                switch(coluna) {
                    case CLOSE:
                        tela.getlCloseGoogle().setForeground(color);
                        tela.getlCloseGoogle().setText("USD " + dado);
                        break;
                    case SMA:
                        tela.getlSMAGoogle().setText("USD " + dado);
                        break;
                    case SITUACAO:
                        tela.getlSitGoogle().setText(dado);
                        break;
                    default:
                        break;
                }
                break;
            case "Petrobras":
                switch(coluna) {
                    case CLOSE:
                        tela.getlClosePetr().setForeground(color);
                        tela.getlClosePetr().setText("BRL " + dado);
                        break;
                    case SMA:
                        tela.getlSMAPetr().setText("BRL " + dado);
                        break;
                    case SITUACAO:
                        tela.getlSitPetr().setText(dado);
                        break;
                    default:
                        break;
                }
                break;
            case "Santander":
                switch(coluna) {
                    case CLOSE:
                        tela.getlCloseSAN().setForeground(color);
                        tela.getlCloseSAN().setText("BRL " + dado);
                        break;
                    case SMA:
                        tela.getlSMASAN().setText("BRL " + dado);
                        break;
                    case SITUACAO:
                        tela.getlSitSAN().setText(dado);
                        break;
                    default:
                        break;
                }
                break;
            case "Vale":
                switch(coluna) {
                    case CLOSE:
                        tela.getlCloseVale().setForeground(color);
                        tela.getlCloseVale().setText("BRL " + dado);
                        break;
                    case SMA:
                        tela.getlSMAVale().setText("BRL " + dado);
                        break;
                    case SITUACAO:
                        tela.getlSitVale().setText(dado);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }
    
    public void updateScreen() {
        for(Entry<String, Ativo> entry : ControladorDeDados.getInstance().getAtivos().entrySet()) {
            Ativo ativo = entry.getValue();
            if(ativo.isUpdated()) {
                setCelula(ativo.getNome(), Atributo.CLOSE, String.format("%.2f", ativo.getClose()), ativo.getColor());
                setCelula(ativo.getNome(), Atributo.SMA, String.format("%.2f", ativo.getSma()), null);
                setCelula(ativo.getNome(), Atributo.SITUACAO, ativo.getSituacao(), null);
                ativo.setUpdated(false);
            }
        }
    }
    
    public void setMonitoramento() {
        if(!monitorando) {
            tela.getLMonitoramento().setText("Monitoramento Ligado");
        } else {
            tela.getLMonitoramento().setText("Monitoramento Desligado");
        }
        monitorando = !monitorando;
    }
    
    public TelaPrincipal getTela() {
        return tela;
    }
    
}
