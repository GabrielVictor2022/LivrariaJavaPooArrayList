package projetoLivrariaPoo;

import java.util.ArrayList;

public class Acervo {
	static AppLivroLivraria m = new AppLivroLivraria();
	private static ArrayList<LivroLivraria> listaLivros = new ArrayList<LivroLivraria>();
	private static ArrayList<LivroLivraria> listaCarrinho = new ArrayList<LivroLivraria>();
	private static ArrayList<LivroLivraria> listaClientes = new ArrayList<LivroLivraria>();

	public static ArrayList<LivroLivraria> getLivro() {
		return listaLivros;
	}

	public static ArrayList<LivroLivraria> getCarrinho() {
		return listaCarrinho;
	}

	public static ArrayList<LivroLivraria> getClientes() {
		return listaClientes;
	}

	public static void adicionar(LivroLivraria l) {
		listaLivros.add(l);
	}

	public static void adicionarCarrinho(LivroLivraria c) {
		listaCarrinho.add(c);
	}

	public static void adicionarCliente(LivroLivraria c) {
		listaClientes.add(c);
	}

	public static String listar() {
		String saida = "";
		int i = 1;
		for (LivroLivraria l : listaLivros) {
			saida += "\n======= LIVRO " + (i++) + " =======\n";
			saida += l.imprimir() + "\n";
		}

		return saida;
	}

	public static int pesquisarG(String genero) {
		int qtd = 0;
		for (LivroLivraria l : listaLivros) {
			if (l.getGenero().equalsIgnoreCase(genero)) {
				qtd++;
			}
		}
		return qtd;

	}

	public static int pesquisarT(String titulo) {
		int qtd = 0;
		for (LivroLivraria l : listaLivros) {
			if (l.getTitulo().equalsIgnoreCase(titulo)) {
				qtd++;
			}
		}
		return qtd;

	}

	public static int pesquisarA(String autor) {
		int qtd = 0;
		for (LivroLivraria l : listaLivros) {
			if (l.getAutor().equalsIgnoreCase(autor)) {
				qtd++;
			}
		}
		return qtd;

	}

	public static int pesquisarE(String editora) {
		int qtd = 0;
		for (LivroLivraria l : listaLivros) {
			if (l.getEditora().equalsIgnoreCase(editora)) {
				qtd++;
			}
		}
		return qtd;

	}

	public static int pesquisarI(int isbn) {
		int qtd = 0;
		for (LivroLivraria l : listaLivros) {
			if (l.getIsbn() == (isbn)) {
				qtd++;
			}
		}
		return qtd;

	}

	public static double pesquisar(double i, double f) {
		int qtd = 0;

		for (LivroLivraria l : listaLivros) {
			if (l.getPreco() >= i && l.getPreco() <= f) {
				qtd++;
			}
		}

		return qtd;
	}

	public static boolean remover(String titulo) {

		for (LivroLivraria l : listaLivros) {
			if (l.getTitulo().equalsIgnoreCase(titulo)) {
				listaLivros.remove(l);
				return true;

			}

		}
		return false;

	}

	public static double calcularTotalAcervo() {
		double total = 0;

		for (LivroLivraria c : listaCarrinho) {
			total += c.getPreco();
		}

		return total;
	}

}
