package projetoLivrariaPoo;

import java.util.Scanner;

public class menuPrincipal {
	static Scanner teclado = new Scanner(System.in);
	static Scanner tecladoString = new Scanner(System.in);
	static int escolha;
	static LivroLivraria v = new LivroLivraria();
	static AppLivroLivraria c = new AppLivroLivraria();
	static AppLivroLivrariaCliente m = new AppLivroLivrariaCliente();

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Scanner tecladoString = new Scanner(System.in);

		int escolha, isbn;

		double vInicial, vFinal, preco;

		String titulo, autor, genero, acabamento, editora;

		do {
			inicializacao();
			escolha = teclado.nextInt();
			switch (escolha) {

			case 1:
				menuClientes();
				break;
			case 2:
				menuAdmin();
				break;
			case 3:
				System.out.println("Obrigado e volte sempre!");
				break;

			default:
				System.out.println("Opção de menu inválida!");
				break;
			}

		} while (escolha != 0);

	}

	static void menuClientes() {

		do {
			System.out.println("============== LIVRARIA =============");
			System.out.println("1 - Login");
			System.out.println("2 - Livros");
			System.out.println("0 - Voltar");
			System.out.print("\nDigite:");
			escolha = teclado.nextInt();

			switch (escolha) {
			case 1:
				v.setLogin(true);
				c.login();
				break;
			case 2:
				m.livroCliente();
				break;
			case 3:
				inicializacao();
				break;

			default:
				System.out.println("Opção inválida");
				break;
			}

		} while (escolha != 0);
	}

	static void menuAdmin() {
		do {
			System.out.println("============== LIVRARIA ADMIN =============");
			System.out.println("1 - Gerenciar livros");
			System.out.println("2 - Gerenciar Editoras");
			System.out.println("0 - Voltar");
			System.out.print("\nDigite:");
			escolha = teclado.nextInt();

			switch (escolha) {
			case 1:
				c.livroAdm();
				break;
			case 2:
				c.editora();
				break;
			case 3:
				inicializacao();
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}

		} while (escolha != 0);
	}

	public static void inicializacao() {
		System.out.println("====== Início =======");
		System.out.println("1 - Cliente");
		System.out.println("2 - Admininstrador");
		System.out.println("0 - Sair");
		System.out.print("\nDigite:");

	}

}
