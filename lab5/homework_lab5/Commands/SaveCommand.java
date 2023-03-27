package Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import Main.Catalog;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveCommand implements ICommand {
    private static Catalog catalog = null;
    private static String path = null;

    /**
     * Before the actual save, the user has to specify the catalog they
     * want to save and the path where they would like to find the file
     */
    public static void OpenCatalogForSave(Catalog _catalog, String _path){
        catalog = _catalog;
        path = _path;
    }

    /**
     * Save a catalog as a FILE at the location indicated by the path
     */
    private static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog
        );
    }

    /**
     * for the REPORT command --
     * The method saves the HTML report in the specified path
     */
    protected static void save(StringWriter file, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                file
        );
    }

    /**
     * Apelul metodei save
     */
    public static void execute(){
        try {
            save(catalog, path);
        } catch (IOException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, "NU s-a putut realiza salvarea", ex);
        }
    }
}
