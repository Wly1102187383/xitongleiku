package xitongleiku;

public class SavingAccount extends BankAccount{
private double interestRate;  //����


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
return  super.toString() +",���ʣ�"+this.interestRate;
}


//����Ϣ
public void payInterest(){
super.setBalance(super.getBalance()+super.getBalance()*this.interestRate);
}



}
