package Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import Main.Catalog;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadCommand implements ICommand {
    private static String path;

    /**
     * Before the actual load, the user has to specify the path of the catalog they want to load
     */
    public static void OpenPathToLoadFrom(String _path){
        path = _path;
    }

    /**
     * Loads the catalog from an external file
     */
    private static Catalog load(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new File(path),
                Catalog.class
        );
    }

    /**
     * Apelul metodei load
     */
    public static void execute(Catalog catalog) {
        try{
            catalog = load(path);
        }catch (IOException ex) {
            Logger.getLogger(LoadCommand.class.getName()).log(Level.SEVERE, "NU s-a putut realiza commanda", ex);
        }
    }
}
