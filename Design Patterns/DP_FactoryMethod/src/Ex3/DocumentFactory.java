package Ex3;

public class DocumentFactory {
    public static Document createDocument(String type, String author, String name) {

        switch (type.toLowerCase()) {
            case "texto":
                return new TextDocument(author, name);

            case "folha de cálculo":
                return new SpreadsheetDocument(author, name);

            case "apresentação":
                return new PresentationDocument(author, name);

            default:
                return null;
        }
    }
}