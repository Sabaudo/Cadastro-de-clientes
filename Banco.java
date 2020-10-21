
public class Banco {
	String nome;
	int idade;
	String horario;
	String servico;
	
	public Banco() {
	}
	
	public Banco(String nome, int idade, String horario, String servico) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.horario = horario;
		this.servico = servico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	
	public String getData() {
		return "Nome:"+ this.nome + 
				"\nIdade:"+ this.idade + 
				"\nHorario de chegada:" + this.horario +
				"\nServiço a ser realizado:"+ this.servico;
	}
	
}
