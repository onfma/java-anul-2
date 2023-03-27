package Commands;

import Main.Catalog;
import Main.Document;
import Commands.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCommand implements ICommand {
    private Catalog catalog = null;
    private Document document = null;

    /**
     * The user hat to specify the document they want
     * to save and in witch catalog
     */
    public void OpenCatalogAndDocument(Catalog catalog, Document document) throws IOException {
        this.catalog = catalog;
        this.document = document;
    }

    /**
     * Apelul metodei add
     */
    public void execute() {
        catalog.addDocument(document);
    }
}
