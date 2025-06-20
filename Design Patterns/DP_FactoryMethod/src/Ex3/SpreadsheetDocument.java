package Ex3;

public class SpreadsheetDocument extends Document {
    public SpreadsheetDocument(String author, String name) {
        super(author, name);
        this.extension = "xlsx";
    }

    @Override
    public void open() {
        System.out.println("A abrir folha de cálculo " + name + "." + extension);
    }

    @Override
    public void close() {
        System.out.println("A fechar o documento de folha de cálculo.");
    }
}