/*
 * Пример синхронизации нескольких потоков по объекту монитора
 * @autor Stepan Ushakov and Alexandr Nepretimov
 */

public class App {
    public static void main(String[] args) {
        /*Thread thread = Thread.currentThread();
        System.out.println( thread.getName() );
        System.out.println( thread.getThreadGroup().getName() );

        MyThread myThread1 = new MyThread("A");
        myThread1.start();

        Thread myThread2 = new Thread( new Runnable() {
            @Override
            public void run() {
                System.out.println( "B" );
            }
        } );
        myThread2.start();

        System.out.println("Stop main");*/

        MyCounter counter = new MyCounter();
        MyThread thread1 = new MyThread("A", counter);
        MyThread thread2 = new MyThread("B", counter);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(500 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.myTreadStop();
        thread2.myTreadStop();

        System.out.println("Stop main");
    }
}