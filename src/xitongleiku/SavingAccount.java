package xitongleiku;

public class SavingAccount extends BankAccount{
private double interestRate;  //利率


public SavingAccount() {
super();
}


public SavingAccount(String accountNo, double balance, double interestRate) {
super(accountNo, balance);
this.interestRate = interestRate;
}


public double getInterestRate() {
return interestRate;
}


public void setInterestRate(double interestRate) {
this.interestRate = interestRate;
}


@Override
public String toString() {
return  super.toString() +",利率："+this.interestRate;
}


//付利息
public void payInterest(){
super.setBalance(super.getBalance()+super.getBalance()*this.interestRate);
}



}
