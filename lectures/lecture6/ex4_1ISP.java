// Interface segregation principle
// Принцип разделения интерфейса 


public class ex4_1ISP {
    public static void main(String[] args) {

    }
}


interface Phone {
    void Call();    
    void SendSMS();    
    void SendEMail();
    void SendFax();
}


class Siemens implements Phone {

    @Override
    public void Call() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void SendSMS() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void SendEMail() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void SendFax() {
        // TODO Auto-generated method stub
        
    }
}

 
class Nokia3310 implements Phone {

    @Override
    public void Call() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void SendSMS() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void SendEMail() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void SendFax() {
        // TODO Auto-generated method stub
        
    }

    
}