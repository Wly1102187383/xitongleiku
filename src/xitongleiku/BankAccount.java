package xitongleiku;

public class BankAccount {
private String accountNo;
private double balance;
public BankAccount(String accountNo, double balance) {
super();
this.accountNo = accountNo;
this.balance = balance;
}
public BankAccount() {
super();
}
public String getAccountNo() {
return accountNo;
}
public void setAccountNo(String accountNo) {
this.accountNo = accountNo;
}
public double getBalance() {
return balance;
}
public void setBalance(double balance) {
this.balance = balance;
}
@Override
public String toString() {
return "ø®∫≈:" + accountNo + ", ”‡∂Ó:" + balance ;
}



}