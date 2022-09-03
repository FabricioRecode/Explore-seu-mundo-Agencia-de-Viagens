import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		Scanner entradaCidade = new Scanner(System.in);
		PacoteService pacoteService = new PacoteService();
		Cidade cidade = new Cidade();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("                                 Explore_Agencia                                  ");
		System.out.println("--------------------------------------------------------------------------------");
		int opc;
		do {
			System.out.println(" 1 - Buscar Pacotes pela Cidade");
			System.out.println(" 2 - Mostrar Cidades");
			System.out.println(" 3 - Buscar Pacotes por continente");
			System.out.println(" 0 - Continuar");
			System.out.println("___");
			System.out.print("Digite: ");
			opc = entrada.nextInt();
			switch (opc) {
			case 1 -> {
				System.out.println("Quer ir para qual cidade?");

				String cidadeNome = entradaCidade.nextLine();
				pacoteService.buscarPacotes(cidadeNome);
			}
			case 2 -> {
				pacoteService.mostrarCidades();
			}
			case 3 ->{
				
				System.out.println("Buscar Pacote por qual Continente? ");

				String continente = entradaCidade.nextLine();
				pacoteService.buscarPacotesByContinente(continente);
				
				
				
			}
			
			}
			System.out.println("");
		} while (opc != 0);
		entradaCidade.close();
	}

}
