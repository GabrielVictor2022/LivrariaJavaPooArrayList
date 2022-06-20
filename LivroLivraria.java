package projetoLivrariaPoo;

public class LivroLivraria {

	private String titulo, autor, genero, acabamento, editora, carrinho,cartao,titularCartao;
	private int isbn, quantidade, cvc;
	int editoraQtd;
	private double preco;
	private boolean login;

	
	public LivroLivraria() {
	}

	public LivroLivraria(String nome, String email, String senha, String endereco, String id) {
		
	}
	public LivroLivraria(String titulo, String autor, String genero, String acabamento, String editora, int isbn,
			double preco, int quantidade) {
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setGenero(genero);
		this.setAcabamento(acabamento);
		this.setEditora(editora);
		this.setIsbn(isbn);
		this.setQuantidade(quantidade);
		this.setPreco(preco);
	}

	public LivroLivraria(String titulo, String autor, String genero, String acabamento, String editora, int isbn,
			 double preco) {
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setGenero(genero);
		this.setAcabamento(acabamento);
		this.setEditora(editora);
		this.setIsbn(isbn);
		this.setPreco(preco);
		
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAcabamento() {
		return acabamento;
	}

	public void setAcabamento(String acabamento) {
		this.acabamento = acabamento;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(String carrinho) {
		this.carrinho = carrinho;
	}

	public boolean getLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getTitularCartao() {
		return titularCartao;
	}

	public void setTitularCartao(String titularCartao) {
		this.titularCartao = titularCartao;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public int getEditoraQtd() {
		return editoraQtd;
	}

	public void setEditoraQtd(int editoraQtd) {
		this.editoraQtd = editoraQtd;
	}

	public String imprimir() {
		return "Título: " + getTitulo() + "\nAutor: " + getAutor() + "\nGênero: " + getGenero() + "\nAcabamento: "
				+ getAcabamento() + "\nEditora: " + getEditora() + String.format("\nPreço R$ %.2f\n", getPreco())
				+ "\nIsbn: " + getIsbn();
	}

}
