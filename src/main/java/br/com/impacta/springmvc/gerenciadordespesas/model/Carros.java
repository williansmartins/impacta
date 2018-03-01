package br.com.impacta.springmvc.gerenciadordespesas.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Carros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Size(min=2, max=240)
	@NotNull
	private String nome;
	
	@Size(min=4, max=4)
	@NotNull
	private int ano;
	
	@NotNull
	private double valor;
	
	@NotNull
	private String cor;
	
	public Carros (){
		super();
	}
	
	public Carros(int codigo,String nome,int ano,double valor,String cor){
		setCodigo(codigo);
		setNome(nome);
		setAno(ano);
		setValor(valor);
		setCor(cor);
	}
	
	public int getCodigo(){
		return codigo;
	}
	
	public void setCodigo(int codigo){
		this.codigo = codigo;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public int getAno(){
		return ano;
	}
	
	public void setAno(int ano){
		this.ano = ano;
	}
	
	public double getValor(){
		return valor;
	}
	
	public void setValor(double valor){
		this.valor = valor;
	}
	
	
	public String getCor(){
		return cor;
	}
	
	public void setCor(String cor){
		this.cor = cor;
	}
	
	@Override
	public String toString() {
		return "Alunos [codigo=" + codigo + ", nome=" + nome + ", datanasc=" + ano + ", Valor=" + valor
				+ ", Cor=" + cor + "]";
	}
	
			
	}


