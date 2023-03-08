package ex1;

public class Program {
    public static void main(String[] args) {
        Presenter pr = new Presenter(new SumModel(), new View());
        pr.buttonClick();
    }
}
