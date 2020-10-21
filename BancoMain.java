
import java.util.ArrayList;
import java.util.Scanner;
public class BancoMain {
	public static void main(String args[]) {
		
		ArrayList<Banco> Fila = new ArrayList<>();
		ArrayList<Banco> FilaPref = new ArrayList<>();
		int op, id, op2;
		String nome, horario, serv;
		int idade;
		int verif = 0;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println(" ----- FILA BANCO UEL ----- ");
			System.out.println("Digite uma opção: ");
			System.out.println("1 - Cadastrar cliente na fila");
			System.out.println("2 - Remover cliente desistente");
			System.out.println("3 - Atender cliente");
			System.out.println("4 - Buscar posição do cliente especificado");
			System.out.println("5 - Visualizar a fila de clientes");
			System.out.println("0 - Sair do programa");
			op = input.nextInt();
			switch(op){
				case 1:
					System.out.println("Nome do cliente:");
					nome = input.next();
					System.out.println("Idade do cliente: ");
					idade = input.nextInt();
					System.out.println("Horario de chegada na fila: ");
					horario = input.next();
					input.nextLine();
					System.out.println("Serviço a ser realizado: ");
					serv = input.nextLine();
					Banco infos = new Banco(nome, idade, horario, serv);
					if(idade > 65) {
						FilaPref.add(infos);
						System.out.println("Cliente cadastrado na fila preferencial.");
					}else {
						Fila.add(infos);
						System.out.println("Cliente cadastrado na fila comum.");
					}
					break;
				case 2:
					System.out.println("Qual fila foi pedida desistência?");
					System.out.println("1- FILA COMUM");
					System.out.println("2 - FILA PREFERENCIAL");
					System.out.println("Selecione uma opção:");
					op2 = input.nextInt();
					System.out.println("Qual a posicao do cliente desistente?");
					id = input.nextInt();
					if(op2 == 1) {
						for(int i = 0; i < Fila.size(); i++) {
							if(Fila.size() == 0 || id > Fila.size()) {
								System.out.println("Erro. Posição inserida inválida.");
							}else if(i == id) {
								Fila.remove(id);
							}
						}
					}
					if(op2 == 2) {
						for(int i = 0; i < FilaPref.size(); i++) {
							if(FilaPref.size() == 0 || id > FilaPref.size()) {
								System.out.println("Erro. Posição inserida inválida.");
							}else if(id == i) {
								FilaPref.remove(id);
							}
						}
					}
					break;
				case 3:
					if(FilaPref.size() > 0 && verif < 2 || Fila.size() == 0){
						FilaPref.remove(0);
						verif++;
						break;
					}else if(Fila.size() > 0 ){
						if(verif == 2)
							verif = 0;
						Fila.remove(0);
					}else {
						System.out.println("Não há ninguém na fila.");
					}
					break;
				case 4:
					System.out.println("Qual fila será feita a busca?");
					System.out.println("1- FILA COMUM");
					System.out.println("2 - FILA PREFERENCIAL");
					System.out.println("Selecione uma opção:");
					op2 = input.nextInt();
					if(op2 == 1) {
						System.out.println("Nome do cliente a ser buscado: ");
						nome = input.next();
						for(int i = 0;i < Fila.size(); i++) {
							if(Fila.get(i).getNome().compareTo(nome) == 0){
								System.out.println("Posicao na fila:" + i + "\n\n");
							}
						}
					}
					if(op2 == 2) {
						System.out.println("Nome do cliente a ser buscado: ");
						nome = input.next();
						for(int i = 0;i < FilaPref.size(); i++) {
							if(FilaPref.get(i).getNome().compareTo(nome) == 0){
								System.out.println("Posicao na fila:" + i + "\n\n");
							}
						}
					}else {
						System.out.println("Opção inválida.");
					}
					break;
				case 5:
					System.out.println("-----Fila comum-----");
					for(int i=0; i < Fila.size(); i++) {
						System.out.println(Fila.get(i).getData() + "\nPosicao na fila: "+ i+"\n\n");
					}
					System.out.println("-----Fila preferencial-----");
					for(int i=0; i < FilaPref.size(); i++) {
						System.out.println(FilaPref.get(i).getData() + "\nPosicao na fila: "+ i+"\n\n");
					}
					break;
				case 0:
					System.out.println("App encerrado.");
					break;
					
				default: System.out.println("Opção inválida.");
			}
		}while(op != 0);
		input.close();
	}
}
