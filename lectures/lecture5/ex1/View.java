package ex1;

import java.util.Scanner;

public class View {
    Scanner iScanner = new Scanner(System.in);

    public int getValue(String title) {
        System.out.printf("%s", title);
        return iScanner.nextInt();
    }

    public void print(int data, String title) {
        System.out.printf("%s%d\n", title, data);
    }
    
}
