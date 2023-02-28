package seminars.seminar2.adapter;

public class MouseUsbAdapter implements Usb1 {

    private final Mouse mouse;

    public MouseUsbAdapter(Mouse mouse) {
        this.mouse = mouse;
    }

}
