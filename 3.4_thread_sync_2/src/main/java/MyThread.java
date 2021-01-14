public class MyThread extends Thread {

    private String name;
    private MyCounter counter;
    private boolean work;

    public MyThread(String name, MyCounter counter) {
        this.name = name;
        this.counter = counter;
        work = true;
    }

    @Override
    public void run() {

        while (work) {
            synchronized (counter) {

                System.out.println(name + " " + counter.incValue());
                counter.notify();
                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void myTreadStop() {
        work = false;
    }

}