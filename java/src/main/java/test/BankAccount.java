package test;

final class BankAccount {
    private double balanceAmount;  // Total amount in bank account
    private static final Object lock = new Object();

    BankAccount(double balance) {
        this.balanceAmount = balance;
    }

    // Deposits the amount from this object instance
    // to BankAccount instance argument ba
    private void depositAmount(BankAccount ba, double amount) throws InterruptedException {
        synchronized (lock) {
            System.out.println("Synchronized lock : " + Thread.currentThread().getName());
            Thread.sleep(100);
//            synchronized (ba) {
//                System.out.println("Synchronized BA : " + Thread.currentThread().getName());

                if (amount > balanceAmount) {
                    throw new IllegalArgumentException(
                            "Transfer cannot be completed"
                    );
                }
                ba.balanceAmount += amount;
                this.balanceAmount -= amount;
//            }
        }
    }

    public static void initiateTransfer(final BankAccount first,
                                        final BankAccount second, final double amount, String tName) {

        Thread transfer = new Thread(new Runnable() {
            public void run() {
                try {
                    first.depositAmount(second, amount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        transfer.setName(tName);
        transfer.start();
    }

    public static void main(String[] args) {
        BankAccount a = new BankAccount(5000);
        BankAccount b = new BankAccount(6000);
        BankAccount.initiateTransfer(a, b, 1000, "t1"); // starts thread 1
        BankAccount.initiateTransfer(b, a, 1000, "t2"); // starts thread 2
    }
}