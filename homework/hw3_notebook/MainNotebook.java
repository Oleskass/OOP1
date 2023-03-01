package homework.hw3_notebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainNotebook {
    public static void main(String[] args) {

        List<Notebook> notebooks = new ArrayList<>(12);
        // Notebook[] notebooks = new Notebook[12];
        for (int i = 0; i < 12; i++) {
            Notebook res = new Notebook(Notebook.randRam(), Notebook.randPrice());
            notebooks.add(res);
            System.out.print(i + 1 + ". " + notebooks.get(i));
        }

        // просто sort - настроила упорядочивание по цене
        Collections.sort(notebooks);
        System.out.println("\nУпорядочивание по цене:\n" + notebooks);

        // компаратор ramComparator упорядочивает по оперативной памяти
        Collections.sort(notebooks, Notebook.ramComparator);
        System.out.println("\nУпорядочивание по ram:\n" + notebooks);

        Collections.sort(notebooks, Notebook.ramPriceComparator);
        System.out.println("\nУпорядочивание по памяти, затем по цене:\n" + notebooks);
    }
}
