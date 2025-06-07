package Ex1;

public class Main {
    public static void main(String[] args) {

        Musica musica1 = new Musica("The Scientist", "Rock Alternativo", "Coldplay", 260);
        Musica musica2 = new Musica("Bohemian Rapsody", "Rock", "Queen", 359);
        Musica musica3 = new Musica("Mestre da Culinária", "Heavy Metal", "Quim Barreiros", 233);
        Musica musica4 = new Musica("Garagem da Vizinha", "Pimba", "Quim Barreiros", 255);
        Musica musica5 = new Musica("Yellow", "Rock Alternativo", "Quim Coldplay", 295);

        // Criamos o Music Player
        MusicPlayer mp = new MusicPlayer("Ivan");

        // Adicionamos músicas
        mp.adicionarMusica(musica1);
        mp.adicionarMusica(musica2);
        mp.adicionarMusica(musica3);
        mp.adicionarMusica(musica4);
        mp.adicionarMusica(musica5);

        // Imprimir relatório
        mp.imprimirDetalhes();
        mp.duracaoAlbum();

        System.out.println("___________________________________________");
        mp.removerMusica(2);
        System.out.println("___________________________________________");

        mp.imprimirDetalhes();
        mp.duracaoAlbum();
    }
}