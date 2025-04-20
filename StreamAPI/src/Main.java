public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");


        Thread t1 = new Thread(()->{
            for(int i=0; i<100; i++) {
                System.out.println("This is thread T1");
            }
        });
        Thread t2 = new Thread(()->{
            for (int i=0; i<100; i++){
                System.out.println("Thread T2");
            }
        });

        t1.start();
        t2.start();

    }
}