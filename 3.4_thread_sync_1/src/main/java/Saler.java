public class Saler implements Runnable {
    Store store;

    public Saler(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.store.put();
        }
    }
}