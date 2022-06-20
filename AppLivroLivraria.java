package projetoLivrariaPoo;

import java.util.Scanner;

public class AppLivroLivraria {
	static String titulo;
	static String autor;
	static String genero;
	String acabamento;
	static String editora;
	static menuPrincipal m = new menuPrincipal();
	static Scanner teclado = new Scanner(System.in);
	static Scanner tecladoString = new Scanner(System.in);
	static int escolhaAddCarrinho;
	static int escolha;
	static boolean login;

	public static void livroAdm() {

		Scanner teclado = new Scanner(System.in);
		Scanner tecladoString = new Scanner(System.in);

		int menuL, isbn;

		double vInicial, vFinal, preco;

		String titulo, autor, genero, acabamento, editora;

		do {
			menuAdm();
			menuL = teclado.nextInt();
			switch (menuL) {

			case 1:
				System.out.println("====== Cadastrar livro =======");
				System.out.print("Digite o t�tulo: \n");
				titulo = tecladoString.nextLine();

				System.out.print("Digite o autor: \n");
				autor = tecladoString.nextLine();

				System.out.print("Digite o g�nero: \n");
				genero = tecladoString.nextLine();

				System.out.print("Digite o acabamento: \n");
				acabamento = tecladoString.nextLine();

				System.out.print("Digite a editora: \n");
				editora = tecladoString.nextLine();

				System.out.print("Digite o ISBN: \n");
				isbn = teclado.nextInt();

				System.out.print("Digite o pre�o: \n");
				preco = teclado.nextDouble();

				LivroLivraria objLivro = new LivroLivraria(titulo, autor, genero, acabamento, editora, isbn, preco);

				// static LivroLivraria l = new LivroLivraria();
				Acervo.adicionar(objLivro);

				break;
			case 2:
				System.out.println("======== Listagem =========");
				System.out.println(Acervo.listar());
				break;
			case 3:
				System.out.println("======== Exclus�o =========");
				System.out.print("Digite o t�tulo do livro: ");

				titulo = tecladoString.nextLine();

				if (!(Acervo.getLivro().isEmpty())) { // Acervo n�o vazio
					if (Acervo.remover(titulo)) {
						System.out.println("Livro removido com sucesso");
					} else {
						System.out.println("Livro n�o encontrado");
					}
				} else {
					System.out.println("N�o existem livros no acervo!");
				}

				break;
			case 4:
				System.out.println("====== Pesquisa pelo g�nero ======");
				System.out.print("Digite o g�nero: ");
				genero = tecladoString.nextLine();
				System.out.println("Existem " + Acervo.pesquisarG(genero) + " livro(s) deste g�nero.");
				break;
			case 5:
				System.out.println("====== Pesquisa por faixa de pre�o ======");
				System.out.print("Digite o pre�o inicial: ");
				vInicial = teclado.nextDouble();
				System.out.print("Digite o pre�o final: ");
				vFinal = teclado.nextDouble();

				System.out.println("Existem " + Acervo.pesquisar(vInicial, vFinal) + " livro(s) entre "
						+ String.format("R$ %.2f e R$ %.2f", vInicial, vFinal));
				break;
			case 6:
				System.out.println("====== Pesquisar livro por t�tulo ======");
				System.out.print("Digite o t�tulo: ");
				titulo = tecladoString.nextLine();
				System.out.println("Existem " + Acervo.pesquisarT(titulo) + " livro(s) deste t�tulo.");
				break;
			case 7:
				System.out.println("======= Pesquisar livro por ISBN =======");
				System.out.print("Digite o ISBN: ");
				isbn = teclado.nextInt();
				System.out.println("Existe " + Acervo.pesquisarI(isbn) + " livro deste ISBN.");

				break;
			case 8:
				System.out.println("====== Pesquisar livro por autor ======");
				System.out.print("Digite o autor: ");
				autor = tecladoString.nextLine();
				System.out.println("Existem " + Acervo.pesquisarA(autor) + " livro(s) deste autor.");
				break;
			
			case 0:
				m.menuAdmin();
				break;

			default:
				System.out.println("Op��o de menu inv�lida!");
				break;
			}

		} while (menuL != 0);

	}

	static void menuCliente() {
		System.out.println("============= LOJA LIVRARIA =============");
		System.out.println("1 - Listar");
		System.out.println("2 - Pesquisar livro por g�nero");
		System.out.println("3 - Pesquisar livro por faixa de pre�o");
		System.out.println("4 - Pesquisar livro por t�tulo");
		System.out.println("5 - Pesquisar livro por ISBN");
		System.out.println("6 - Pesquisar livro por autor");
		System.out.println("7 - Calcular total do carrinho");
		System.out.println("8 - Finalizar compras");
		System.out.println("0 - Voltar");
		System.out.print("\nDigite:");
	}

	static void menuAdm() {
		System.out.println("============= LIVRARIA ADM =============");
		System.out.println("1 - Cadastrar livro");
		System.out.println("2 - Listagem");
		System.out.println("3 - Excluir livro");
		System.out.println("4 - Pesquisar livro por g�nero");
		System.out.println("5 - Pesquisar livro por faixa de pre�o");
		System.out.println("6 - Pesquisar livro por t�tulo");
		System.out.println("7 - Pesquisar livro por ISBN");
		System.out.println("8 - Pesquisar livro por autor");
		System.out.println("0 - Voltar");
		System.out.print("\nDigite:");
	}

	static void finalizarCompra() {
		LivroLivraria l = new LivroLivraria();
		System.out.println("============= FINALIZAR COMPRA =============");
		if (login == true) {
			System.out.println("N�mero do cart�o: ");
			l.setCartao(tecladoString.nextLine());
			System.out.println("Titular da conta: ");
			l.setTitularCartao(tecladoString.nextLine());
			System.out.println("CVC: ");
			l.setCvc(teclado.nextInt());
			System.out.println("============================================");
			System.out.println("Pedido realizado com sucesso!");
		} else if (login == false) {
			login();
			finalizarCompra();
		}
	}

	static void login() {
		String nome, email, senha, endereco, id;

		LivroLivraria l = new LivroLivraria();

		System.out.println("============= LOGIN =============");

		System.out.println("Digite nome:");
		nome = tecladoString.nextLine();

		System.out.println("Digite o CPF:");
		id = tecladoString.nextLine();

		System.out.println("Digite email:");
		email = tecladoString.nextLine();

		System.out.println("Digite endere�o:");
		endereco = tecladoString.nextLine();

		System.out.println("Digite senha:");
		senha = tecladoString.nextLine();

		LivroLivraria clientesDados = new LivroLivraria(nome, email, senha, endereco, id);

		Acervo.adicionarCliente(clientesDados);

		l.setLogin(true);
		login = true;

		System.out.println("Login efetuado com sucesso!");
	}

	static void editora() {
		Scanner teclado = new Scanner(System.in);
		Scanner tecladoString = new Scanner(System.in);
		LivroLivraria e = new LivroLivraria();
		int escolhaE;

		do {
			System.out.println("======= Editoras =======");
			System.out.println("1 - Cadastrar nova editora.");
			System.out.println("2 - Verificar quantidade de editoras cadastradas.");
			System.out.println("0 - Voltar");
			System.out.print("\nDigite:");
			escolhaE = teclado.nextInt();

			switch (escolhaE) {
			case 1:
				System.out.print("Digite o c�digo: \n");
				int codigo = teclado.nextInt();

				System.out.print("Digite o nome: \n");
				String nome = tecladoString.nextLine();

				System.out.print("Digite o telefone: \n");
				String telefone = tecladoString.nextLine();
				
				e.setEditoraQtd(e.getEditoraQtd() + 1);
				
				System.out.println("Cadastrada com sucesso!");
				break;
			case 2:
				System.out.println("Existem " + e.getEditoraQtd() + " editora(s) j� cadastradas.");
				break;
			case 0:
				m.menuClientes();
				break;
			default:
				System.out.println("Op��o inv�lida.");
				break;
			}

		} while (escolhaE != 0);

	}


}
