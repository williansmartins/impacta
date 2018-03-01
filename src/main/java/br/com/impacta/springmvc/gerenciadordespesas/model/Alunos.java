package br.com.impacta.springmvc.gerenciadordespesas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Alunos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull(message = "Data é obrigatória")
	private Date datanasc;
	
	private String turma;
	
	@NotEmpty(message="CPF é obrigatório")
	private String cpf;
	
	
	public Alunos() {
		super();
	}


	public Integer getCod() {
		return cod;
	}


	public void setCod(Integer cod) {
		this.cod = cod;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDatanasc() {
		return datanasc;
	}


	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}


	public String getTurma() {
		return turma;
	}


	public void setTurma(String turma) {
		this.turma = turma;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	@Override
	public String toString() {
		return "Alunos [cod=" + cod + ", nome=" + nome + ", datanasc=" + datanasc + ", turma=" + turma
				+ ", cpf=" + cpf + "]";
	}

}
