package homework.hw3_notebook;

import java.util.Collections;
import java.util.Comparator;

public class MainNotebook {
    public static void main(String[] args) {

        Notebook[] notebooks = new Notebook[12];
        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebook(Notebook.randRam(), Notebook.randPrice());
            System.out.print(i + 1 + ". " + notebooks[i]);
        }

        // Comparator<String> strComparator = (s1, s2) -> s1.length() - s2.length();

        Collections.sort(notebooks, Notebook.ramComparator);
        System.out.println(notebooks);

    }
}
