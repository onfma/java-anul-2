package Main;
import Commands.*;
import freemarker.template.TemplateException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, TemplateException {
        Catalog catalog = new Catalog("catalog");
        var book = new Document("carte", "autor", ".." );
        var article = new Document("articol", "autor", ".." );
        catalog.addDocument(book);
        catalog.addDocument(article);

        //SaveCommand.OpenCatalogForSave(catalog,"C:/Users/Maria/Desktop/catalog.json");
        //SaveCommand.execute();

        // THIS DOES NOT WORK
        //LoadCommand.OpenPathToLoadFrom("C:/Users/Maria/Desktop/catalog.json");
        //Catalog c = new Catalog("catalog2");
        //LoadCommand.execute(c);

        //ListCommand.execute();

        //ViewCommand.OpenFileForView("C:/Users/Maria/Desktop/catalog.json");
        //ViewCommand.execute();

        //ReportCommand.OpenCatalogForReport("C:/Users/Maria/Desktop/catalog.json", "C:/Users/Maria/Desktop/cataloggg.html");
        //ReportCommand.execute();
    }
}