// Interface segregation principle
// Принцип разделения интерфейса 


public class ex4_2ISP {
    public static void main(String[] args) {

    }
}

interface BasePhone {
    void Call();
    void SendSMS();
}

interface Fax {
    void SendFax();

}

interface EMail {
    void SendEMail();
}

class IPhone implements BasePhone, Fax, EMail {

    @Override
    public void Call() {
    }

    @Override
    public void SendSMS() {
       

    }

    @Override
    public void SendEMail() {
        

    }

    @Override
    public void SendFax() {
    }
}

class Nokia3311 implements BasePhone {

    @Override
    public void Call() {
    }

    @Override
    public void SendSMS() {

    }
}