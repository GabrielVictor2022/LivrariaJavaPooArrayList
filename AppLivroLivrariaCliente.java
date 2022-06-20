package projetoLivrariaPoo;

import java.util.Scanner;

public class AppLivroLivrariaCliente {
	static int menuL;
	static int isbn;
	static int quantidade = 0;
	static int escolha;
	static double vInicial;
	static double vFinal;
	static double preco = 0;
	static String titulo;
	static String autor;
	static String genero;
	static String acabamento;
	static String editora;

	String carrinho;
	public static void livroCliente() {

		Scanner teclado = new Scanner(System.in);
		Scanner tecladoString = new Scanner(System.in);
		AppLivroLivraria c = new AppLivroLivraria();
		menuPrincipal m = new menuPrincipal();


		do {
			c.menuCliente();
			menuL = teclado.nextInt();
			switch (menuL) {

			case 1:
				System.out.println("======== Listagem =========");
				System.out.println(Acervo.listar());
				System.out.println("Qual livro deseja adicionar ao carrinho? ");

				System.out.print("Digite o título: \n");
				titulo = tecladoString.nextLine();

				System.out.print("Digite o autor: \n");
				autor = tecladoString.nextLine();

				System.out.print("Digite o gênero: \n");
				genero = tecladoString.nextLine();

				System.out.print("Digite o acabamento: \n");
				acabamento = tecladoString.nextLine();

				System.out.print("Digite a editora: \n");
				editora = tecladoString.nextLine();

				System.out.print("Digite o ISBN: \n");
				isbn = teclado.nextInt();

				System.out.print("Digite o preço: \n");
				preco = teclado.nextDouble();

				System.out.print("Digite a quantidade: \n");
				quantidade = teclado.nextInt();

				System.out.print("Embrulhar para presente?(1 - sim, 2 - não) \n");
				escolha = teclado.nextInt();

				if (escolha == 1) {
					System.out.println("Pedido embrulhado com sucesso!");
				} else {
					System.out.println("Adicionado com sucesso!");
					continue;
				}

				LivroLivraria objLivro = new LivroLivraria(titulo, autor, genero, acabamento, editora, isbn,
						preco * quantidade);

				Acervo.adicionarCarrinho(objLivro);

				break;
			case 2:
				System.out.println("====== Pesquisa pelo gênero =======");
				System.out.print("Digite o gênero: ");
				genero = tecladoString.nextLine();
				System.out.println("Existem " + Acervo.pesquisarG(genero) + " livro(s) deste gênero.");
				break;
			case 3:
				System.out.println("====== Pesquisa por faixa de preço =======");
				System.out.print("Digite o preço inicial: ");
				vInicial = teclado.nextDouble();
				System.out.print("Digite o preço final: ");
				vFinal = teclado.nextDouble();

				System.out.println("Existem " + Acervo.pesquisar(vInicial, vFinal) + " livro(s) entre "
						+ String.format("R$ %.2f e R$ %.2f", vInicial, vFinal));
				break;
			case 4:
				System.out.println("====== Pesquisar livro por título =======");
				System.out.print("Digite o título: ");
				titulo = tecladoString.nextLine();
				System.out.println("Existem " + Acervo.pesquisarT(titulo) + " livro(s) deste título.");
				break;
			case 5:
				System.out.println("====== Pesquisar livro por ISBN =======");
				System.out.print("Digite o ISBN: ");
				isbn = teclado.nextInt();
				System.out.println("Existe " + Acervo.pesquisarI(isbn) + " livro deste ISBN.");
				break;
			case 6:
				System.out.println("====== Pesquisar livro por autor =======");
				System.out.print("Digite o autor: ");
				autor = tecladoString.nextLine();
				System.out.println("Existem " + Acervo.pesquisarA(autor) + " livro(s) deste autor.");
				break;
			case 7:
				System.out.println("====== Total do carrinho =======");
				System.out.println("O total do carrinho foi: " + String.format("R$ %.2f \n", preco *= quantidade));
				break;
			case 8:
				System.out.println("====== Finalizar compras =======");
				System.out.println("O total do carrinho foi: " + String.format("R$ %.2f \n", preco *= quantidade));

				System.out.println("Deseja finalizar as compras? (1 - sim, 2 - não)");
				escolha = teclado.nextInt();
				if (escolha == 1) {
					c.finalizarCompra();
				} else if (escolha == 2) {
					c.menuCliente();
				}
				break;
			case 0:
				m.menuClientes();
				break;

			default:
				System.out.println("Opção de menu inválida!");
				break;
			}

		} while (menuL != 0);

	}
}
