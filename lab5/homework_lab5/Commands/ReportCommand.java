package Commands;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportCommand implements ICommand {

    private static String pathToGetFileFrom;
    private static String pathToSaveTo;

    /**
     * Se creeaza reportul, se salveaza si mai apoi se afiseaza/deschide
     */
    public static void execute() throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(ReportCommand.class, "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> data = new HashMap<>();
        data.put("title", "File Report");
        data.put("content", readFile(pathToGetFileFrom));

        Template template = cfg.getTemplate("template.ftl");

        StringWriter out = new StringWriter();
        template.process(data, out);

        // salvam file-ul
        try {
            SaveCommand.save(out, pathToSaveTo);
        } catch (IOException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, "NU s-a putut realiza salvarea", ex);
        }

        //afisam continutul de html
        File document = new File(pathToSaveTo);
        Desktop.getDesktop().open(document);

    }

    /**
     * The method reads line by line the content from the specified path
     */
    private static String readFile(String path) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        }
        return builder.toString();
    }

    /**
     * Utilizatorul treb sa specifice inainte path-ul documentului pt care
     * se creeaza raportul si mai apoi path-ul unde de salveaza raportul
     */
    public static void OpenCatalogForReport(String _pathToGetFileFrom, String _pathToSaveTo){
        pathToGetFileFrom = _pathToGetFileFrom;
        pathToSaveTo = _pathToSaveTo;
    }
}
