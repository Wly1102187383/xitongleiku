package xitongleiku;


public class CheckingAccount extends BankAccount{
private double serviceCharge;  //�����

public CheckingAccount() {
super();
}

public CheckingAccount(String accountNo, double balance, double serviceCharge) {
super(accountNo, balance);
this.serviceCharge = serviceCharge;
}

public double getServiceCharge() {
return serviceCharge;
}

public void setServiceCharge(double serviceCharge) {
this.serviceCharge = serviceCharge;
}

@Override
public String toString() {
return super.toString()+"��serviceCharge=" + serviceCharge  ;
}


//�շ����
public void assessServiceCharge(){
super.setBalance(super.getBalance()-this.serviceCharge);
}





}