package br.com.exemplo.model;

public class Leitor {
	//atributos
	private int codigoLeitor;
	private String nomeLeitor;
	private String tipoLeitor;
	//construtores
	public Leitor() {
	}
	public Leitor(int codigoLeitor, String nomeLeitor, String tipoLeitor) {
		super();
		this.codigoLeitor = codigoLeitor;
		this.nomeLeitor = nomeLeitor;
		this.tipoLeitor = tipoLeitor;
	}
	//getter e setters
	public int getCodigoLeitor() {
		return codigoLeitor;
	}
	public void setCodigoLeitor(int codigoLeitor) {
		this.codigoLeitor = codigoLeitor;
	}
	public String getNomeLeitor() {
		return nomeLeitor;
	}
	public void setNomeLeitor(String nomeLeitor) {
		this.nomeLeitor = nomeLeitor;
	}
	public String getTipoLeitor() {
		return tipoLeitor;
	}
	public void setTipoLeitor(String tipoLeitor) {
		this.tipoLeitor = tipoLeitor;
	}
	
}
