package Commands;

import Main.Document;

import java.util.ArrayList;
import java.util.List;

public class ListCommand implements ICommand {
    private static List<Document> allDocuments = new ArrayList<>();

    /**
     * Adauga in lista un document
     */
    public static void AddToList(Document document){
        allDocuments.add(document);
    }

    /**
     * Dispalys on the screen all documents created
     */
    private static void PrintAllDocuments(){
        for(Document d : allDocuments){
            System.out.println(d.toString());
        }
    }

    /**
     * Apelul metodei list
     */
    public static void execute() {
        PrintAllDocuments();
    }
}
