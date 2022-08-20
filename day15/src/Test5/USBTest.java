package Test5;

public class USBTest {
    public static void main(String[] args) {
        Computer pc1 = new Computer();
        pc1.dataTreansfer(new Flask()); // 接口多態性: USB usb = new Flask()
        pc1.dataTreansfer(new Printer()); // 接口多態性: USB usb = new Printer()

        // 匿名class
        USB device = new USB() {
            @Override
            public void start() {
                System.out.println("啟動裝置");

            }

            @Override
            public void stop() {
                System.out.println("中止裝置");
            }
        };
    }
}

class Computer{
    public void dataTreansfer(USB usb){
        usb.start();
        System.out.println("USB讀取中");
        usb.stop();
    }
}

interface USB{
     final static int WIDTH = 20;
     final static int HEIGHT = 10;
     final static int MAX_SPEED = 1000;
     final static int MIN_SPEED = 1;
     abstract public void start();
     abstract public void stop();
}

class Flask implements USB{
    @Override
    public void start(){
        System.out.println("啟動Flask");
    }

    @Override
    public void stop(){
        System.out.println("中止Flask");
    }

}

class Printer implements USB{
    @Override
    public void start(){
        System.out.println("啟動Printer");
    }

    @Override
    public void stop(){
        System.out.println("中止Printer");
    }
}