package parteB.gestaoBiblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    @Test
    void getTitulo() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        assertEquals("Dom Casmurro", livro.getTitulo());
    }

    @Test
    void getAutor() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        assertEquals("Machado de Assis", livro.getAutor());
    }

    @Test
    void getAnoPublicacao() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        assertEquals(2025, livro.getAnoPublicacao());
    }

    @Test
    void alterarTitulo() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        livro.alterarTitulo("Memórias Póstumas de Brás Cubas");
        assertEquals("Memórias Póstumas de Brás Cubas", livro.getTitulo());
    }

    @Test
    void emprestar() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        livro.emprestar(); // Empresta o livro
        assertFalse(livro.estaDisponivel());
    }

    @Test
    void recepcionar() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        livro.emprestar(); // Primeiro empresta o livro
        livro.recepcionar(); // Depois o recebe
        assertFalse(livro.estaDisponivel()); // O livro deve estar disponível após recepção
    }

    @Test
    void estaDisponivel() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        assertTrue(livro.estaDisponivel());
        livro.emprestar();
        assertFalse(livro.estaDisponivel());
    }

    @Test
    void obterResumo() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 2025, 500);
        String resumoEsperado = "Título: Dom Casmurro, Autor: Machado de Assis, Ano: 2025, Páginas: 500, Estado: indisponível";
        assertEquals(resumoEsperado, livro.obterResumo());
    }
}