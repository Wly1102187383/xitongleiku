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
info =  "���֤��:" + ssn + ", ������" + name + "\n";
info = info + "���ÿ���Ϣ��\n";
info = info + "����:"+this.ca.getAccountNo() + ",���:"+this.ca.getBalance() + "\n";
info = info + "�洢����Ϣ��\n";
info = info + "����:"+this.sa.getAccountNo() + ",���:"+this.sa.getBalance() + "\n";

return info;
}


//���
public void save(double money){
this.sa.setBalance(this.sa.getBalance()+money);
}

//ȡ��
public void withDraw(double money){
this.sa.setBalance(this.sa.getBalance() - money);
}

//����
public void consume(double money){
this.ca.setBalance(this.ca.getBalance() - money);
}

//����
public void repay(double money){
this.ca.setBalance(this.ca.getBalance() + money);
}


//����:
public void setter(){
this.sa.payInterest();
this.ca.assessServiceCharge();
}





}