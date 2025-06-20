package Ex3;

public class PresentationDocument extends Document {
    public PresentationDocument(String author, String name) {
        super(author, name);
        this.extension = "pptx";
    }

    @Override
    public void open() {
        System.out.println("A abrir apresentação " + name + "." + extension);
    }

    @Override
    public void close() {
        System.out.println("A fechar o documento de apresentação.");
    }
}