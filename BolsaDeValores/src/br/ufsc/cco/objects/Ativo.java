/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.cco.objects;

import java.awt.Color;

public class Ativo {

	private final String nome;
	private double close;
	private double sma;
	private String situacao;
	private boolean updated;
	private Color color;

	public Ativo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getSma() {
		return sma;
	}

	public void setSma(double sma) {
		this.sma = sma;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
