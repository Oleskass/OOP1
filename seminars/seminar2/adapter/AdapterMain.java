package seminars.seminar2.adapter;

public class AdapterMain {

    public static void main(String[] args) {
        Computer computer = new Computer();

        Mouse mouse = new Mouse();

        // computer.accept(mouse); - не можем так
        computer.accept(new MouseUsbAdapter(mouse));
    }

}
