package lectures.lecture2.ex6.Format;

import java.io.FileWriter;
import java.io.IOException;

import lectures.lecture2.ex6.Document.TextDocument;

public class Doc extends TextFormat {

    @Override
    public void SaveAs(TextDocument document, String path) {
        try (FileWriter writer = new FileWriter(path + ".doc", false)) {
            writer.write("<?Doc Format>\n");
            writer.write(document.getData());
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
