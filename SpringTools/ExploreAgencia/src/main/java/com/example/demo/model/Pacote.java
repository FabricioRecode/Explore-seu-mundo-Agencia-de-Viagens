package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Pacote {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(nullable = false,name = "id_cidade")
	private Cidade cidade;
	@Column(nullable = false)
	private double preco;
	@Column(nullable = false)
	private int diaria;
	@Column(nullable = false)
	private boolean cafe_manha;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade( Cidade cidade) {
		this.cidade = cidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getDiaria() {
		return diaria;
	}
	public void setDiaria(int diaria) {
		this.diaria = diaria;
	}
	public boolean isCafe_manha() {
		return cafe_manha;
	}
	public void setCafe_manha(boolean cafe_manha) {
		this.cafe_manha = cafe_manha;
	}
	
	
	
}
