public class Store {
    private String sName;
    private Integer prodCount;

    public Store(String sName, Integer prodCount) {
        this.sName = sName;
        if(prodCount <= 0){
            Throwable nullProductThtow = new Throwable("Ошибка, товаров должно быть больше 0");
            try {
                throw nullProductThtow;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("Объект sName: " + sName + " не был создан");
            }
            return;
        }
        this.prodCount = prodCount;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getProdCount() {
        return prodCount;
    }

    public void setProdCount(Integer prodCount) {
        this.prodCount = prodCount;
    }

    public synchronized void get(){
        if (this.prodCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.prodCount--;
        System.out.println("Взяли 1 товар");
        System.out.println("Осталось " + getProdCount() + " товаров");
        notify();
    }

    public synchronized void put(){
        if (this.prodCount >= 8) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.prodCount++;
        System.out.println("Положили 1 товар");
        System.out.println("Осталось " + getProdCount() + " товаров");
        notify();
    }
}