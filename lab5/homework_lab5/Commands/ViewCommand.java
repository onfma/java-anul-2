package Commands;

import Commands.ICommand;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ViewCommand implements ICommand {
    private static File document ;

    /**
     * Utlizatorul trebuie sa specifice path-ul pt
     * documentul pt care vrea sa apele view
     */
    public static void OpenFileForView(String path){
        document = new File(path);
    }

    /**
     * Deschide in notepad documentul dat
     */
    private static void view(File document) throws IOException{
        Desktop desktop = Desktop.getDesktop();
        desktop.open(document);
    }

    /**
     * Apelul metodei view
     */
    public static void execute(){
        try{
            view(document);
        } catch (IOException ex){
            Logger.getLogger(ViewCommand.class.getName()).log(Level.SEVERE, "NU s-a putut realiza vizualizarea", ex);
        }
    }
}
