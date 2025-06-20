package Ex3;

public abstract class Document {
    protected String author;
    protected String name;
    protected String extension;

    public Document(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public abstract void open();
    public void save() {
        System.out.println("Alterações do " + author + " gravadas.");
    }
    public abstract void close();
}