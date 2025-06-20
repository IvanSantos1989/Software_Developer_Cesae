package Ex3;

public class TextDocument extends Document {
    public TextDocument(String author, String name) {
        super(author, name);
        this.extension = "docx";
    }

    @Override
    public void open() {
        System.out.println("A abrir documento de texto " + name + "." + extension);
    }

    @Override
    public void close() {
        System.out.println("A fechar o documento de texto.");
    }
}