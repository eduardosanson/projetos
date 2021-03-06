package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ENDERECO")
public class Endereco {
	
	@Id
	@Column(name="ENDERECO_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer endereco_Id;
	
	@Column(name="LOGRADOURO")
	private String 	 logradouro;
	
	@Column(name="NUMERO")
	private Integer numero;
	
	@Column(name="COMPLEMENTO")
	private String 	 completmento;
	
	@Override
	public String toString() {
		return "Endereco [endereco_id=" + endereco_Id + ", logradouro="
				+ logradouro + ", numero=" + numero + ", completmento="
				+ completmento + "]";
	}

	public Endereco(Integer endereco_Id, String logradouro, Integer numero,
			String completmento) {
		super();
		this.endereco_Id = endereco_Id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.completmento = completmento;
	}

	public Endereco() {
	
	}

	public Integer getEndereco_Id() {
		return endereco_Id;
	}

	public void setEndereco_Id(Integer endereco_Id) {
		this.endereco_Id = endereco_Id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCompletmento() {
		return completmento;
	}

	public void setCompletmento(String completmento) {
		this.completmento = completmento;
	}
	
	
}
