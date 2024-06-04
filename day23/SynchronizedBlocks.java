package day23;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + balance);
        }
    }

    public synchronized void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to withdraw " + amount + ". Insufficient balance.");
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class BankCustomer implements Runnable {
    private final BankAccount account;

    public BankCustomer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            depositAndWithdraw();
        }
    }

    private void depositAndWithdraw() {
        int depositAmount = (int) (Math.random() * 100);
        account.deposit(depositAmount);

        int withdrawAmount = (int) (Math.random() * 100);
        account.withdraw(withdrawAmount);

        try {
            Thread.sleep(100); // Simulate time taken for operations
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SynchronizedBlocks {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread customer1 = new Thread(new BankCustomer(account), "Customer 1");
        Thread customer2 = new Thread(new BankCustomer(account), "Customer 2");

        customer1.start();
        customer2.start();

        try {
            customer1.join();
            customer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}