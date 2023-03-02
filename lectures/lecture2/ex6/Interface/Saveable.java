package lectures.lecture2.ex6.Interface;

import lectures.lecture2.ex6.Document.TextDocument;

public interface Saveable {
    void SaveAs(TextDocument document, String path);
}
