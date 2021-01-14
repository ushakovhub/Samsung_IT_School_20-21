/*
 * Пример синхронизации нескольких потоков по методам
 * @autor Stepan Ushakov
 */

public class App {
    public static void main(String[] args) {
        Store store1 = new Store("App stor", 2);

        // 1 вариант запуска потоков
        Thread trader = new Thread(new Trader(store1));
        Thread saler =  new Thread(new Saler(store1));
        trader.start();
        saler.start();

        // 2 вариант запуска потоков
	    /*
        Trader trader = new Trader(store1);
        Saler saler = new Saler(store1);

        new Thread(trader).start();
        new Thread(saler).start();
        */
    }
}