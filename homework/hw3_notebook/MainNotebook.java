package homework.hw3_notebook;

public class MainNotebook {
    public static void main(String[] args) {

        Notebook[] notebooks = new Notebook[12];
        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebook(Notebook.randRam(), Notebook.randPrice());
            System.out.print(i + 1 + ". " + notebooks[i]);
        }

    }
}
