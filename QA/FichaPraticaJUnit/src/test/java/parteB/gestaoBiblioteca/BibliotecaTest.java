package parteB.gestaoBiblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {


    @Test
    void adicionarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.contarLivros());
        assertEquals(livro, biblioteca.pesquisarLivroPorTitulo("Dom Casmurro"));
    }

    @Test
    void removerLivroPorTitulo() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        Livro livro2 = new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 2023, 300);
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.removerLivroPorTitulo("Dom Casmurro");
        assertEquals(1, biblioteca.contarLivros());
    }

    @Test
    void pesquisarLivroPorTitulo() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        biblioteca.adicionarLivro(livro);
        assertNotNull(biblioteca.pesquisarLivroPorTitulo("Dom Casmurro"));
    }

    @Test
    void contarLivros() {
    }

    @Test
    void contarLivrosPorAutor() {
    }

    @Test
    void listarLivros() {
    }

    @Test
    void gerarRelatorioBiblioteca() {
    }

    @Test
    void obterLivrosDisponiveis() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        Livro livro2 = new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 2023, 300);
        livro1.emprestar(); // Marca o livro como indisponível
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        assertEquals(2, biblioteca.obterLivrosDisponiveis().size());
    }

    @Test
    void obterLivrosIndisponiveis() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        Livro livro2 = new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 2023, 300);
        livro1.emprestar(); // Marca o livro como indisponível
        livro2.emprestar(); // Marca o livro como indisponível
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        assertEquals(2, biblioteca.obterLivrosIndisponiveis().size());
    }
}