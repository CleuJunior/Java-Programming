/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

class BankAccount {

    private int balance;
    private boolean isOpen;

    public void open() { isOpen = true; }
    public void close() { isOpen = false; }

    public int getBalance() throws BankAccountActionInvalidException {
        if(!isOpen) throw new BankAccountActionInvalidException("Account closed");
        return balance;
    }

    public synchronized void deposit(int depositAmount) throws BankAccountActionInvalidException {
        if(!isOpen) throw new BankAccountActionInvalidException("Account closed");
        if(depositAmount < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        balance += depositAmount;
    }

    public synchronized void withdraw(int withdrawAmount) throws BankAccountActionInvalidException {
        if(!isOpen) throw new BankAccountActionInvalidException("Account closed");
        if(withdrawAmount < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        if(balance == 0 ) throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        if(withdrawAmount > balance) throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        balance -= withdrawAmount;
    }

}