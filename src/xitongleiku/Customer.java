package xitongleiku;


public class Customer {
private String ssn;
private String name;
private CheckingAccount ca;
private SavingAccount sa;


public Customer(String ssn, String name) {
super();
this.ssn = ssn;
this.name = name;
}
public Customer() {
super();
}
public Customer(String ssn, String name, CheckingAccount ca, SavingAccount sa) {
super();
this.ssn = ssn;
this.name = name;
this.ca = ca;
this.sa = sa;
}
public String getSsn() {
return ssn;
}
public void setSsn(String ssn) {
this.ssn = ssn;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public CheckingAccount getCa() {
return ca;
}
public void setCa(CheckingAccount ca) {
this.ca = ca;
}
public SavingAccount getSa() {
return sa;
}
public void setSa(SavingAccount sa) {
this.sa = sa;
}
@Override
public String toString() {
String info ="";
info =  "身份证号:" + ssn + ", 姓名：" + name + "\n";
info = info + "信用卡信息：\n";
info = info + "卡号:"+this.ca.getAccountNo() + ",余额:"+this.ca.getBalance() + "\n";
info = info + "存储卡信息：\n";
info = info + "卡号:"+this.sa.getAccountNo() + ",余额:"+this.sa.getBalance() + "\n";

return info;
}


//存款
public void save(double money){
this.sa.setBalance(this.sa.getBalance()+money);
}

//取款
public void withDraw(double money){
this.sa.setBalance(this.sa.getBalance() - money);
}

//消费
public void consume(double money){
this.ca.setBalance(this.ca.getBalance() - money);
}

//还款
public void repay(double money){
this.ca.setBalance(this.ca.getBalance() + money);
}


//结算:
public void setter(){
this.sa.payInterest();
this.ca.assessServiceCharge();
}





}