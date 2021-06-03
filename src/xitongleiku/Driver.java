package xitongleiku;

import java.util.Scanner;

public class Driver {
private static Customer customer = null;

public static void main(String[] args) {
int choice = menu();
while (choice != 8) {
switch (choice) {
case 1:
create();
break;
case 2:
save();
break;
case 3:
withDraw();
break;
case 4:
consume();
break;
case 5:
repay();
break;
case 6:
setter();
break;
case 7:
queryBalance();
break;
default:
System.out.println("�˳��ɹ���");
}
choice = menu();

}
System.out.println("��ӭ�´�ʹ�ã�");

}

public static int menu() {
int choice = 0;

System.out.println("====��ӭʹ��WTU����======");
System.out.println("1.����");
System.out.println("2.���");
System.out.println("3.ȡ��");
System.out.println("4.����");
System.out.println("5.����");
System.out.println("6.����");
System.out.println("7.��ѯ���");
System.out.println("8.�˳�");
System.out.println("������ѡ��(1-8):");
Scanner scan = new Scanner(System.in);
choice = scan.nextInt();

return choice;
}

public static int subMenu() {
int choice = 0;

System.out.println("====��ӭʹ��WTU���п���======");
System.out.println("1.�洢��");
System.out.println("2.���ÿ�");
System.out.println("3.����");
System.out.println("������ѡ��(1-3):");
Scanner scan = new Scanner(System.in);
choice = scan.nextInt();

return choice;
}

public static void create() {
Scanner scan = new Scanner(System.in);
String choose = "";
if (customer != null) {
System.out.println("�˿���Ϣ�Ѵ��ڣ��Ƿ����£�y/n����");
choose = scan.nextLine();
if (choose.equalsIgnoreCase("n")) {
return;
}
}

System.out.print("���������֤�ţ�");
String ssn = scan.nextLine();
System.out.print("������������");
String name = scan.nextLine();

customer = new Customer(ssn, name);

int choice = subMenu();
while (choice != 3) {
switch (choice) {
case 1:createSavingAccount();break;
case 2:createCheckingAccount();break;
default:
System.out.println("ѡ����Ч��������ѡ��");
}
choice = subMenu();

}

}

public static void createSavingAccount() {
Scanner scan = new Scanner(System.in);
String choose = "";
if(customer.getSa()!=null){
System.out.println("�洢���Ѵ��ڣ��Ƿ�����(y/n):");
choose = scan.nextLine();
if(choose.equalsIgnoreCase("n")){
return;
}
}
System.out.println("������洢�����ţ�");
String accountNo = scan.nextLine();
System.out.println("������������:");
double interestRate = scan.nextDouble();
SavingAccount sa = new SavingAccount(accountNo,0,interestRate);
customer.setSa(sa);
System.out.println("�洢�������ɹ�����Ϣ����:");
System.out.println(customer.getSa().toString());
}

public static void createCheckingAccount() {
Scanner scan = new Scanner(System.in);
String choose = "";
if(customer.getCa()!=null){
System.out.println("�����Ѵ��ڣ��Ƿ�����(y/n):");
choose = scan.nextLine();
if(choose.equalsIgnoreCase("n")){
return;
}
}
System.out.println("������洢�����ţ�");
String accountNo = scan.nextLine();
System.out.println("����������:");
double serviceCharge = scan.nextDouble();
CheckingAccount ca = new CheckingAccount(accountNo,0,serviceCharge);
customer.setCa(ca);
System.out.println("���ÿ������ɹ�����Ϣ����:");
System.out.println(customer.getCa().toString());
}

// ���
public static void save() {
if (customer == null) {
System.out.println("�ù˿���δ����");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("����������:");
double money = scan.nextDouble();
customer.save(money);
System.out.println("���ɹ����洢�����Ϊ:" + customer.getSa().getBalance());

}

// ȡ��
public static void withDraw() {
if (customer == null) {
System.out.println("�ù˿���δ����");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("������ȡ���:");
double money = scan.nextDouble();

if (money > customer.getSa().getBalance()) {
System.out.println("�ܱ�Ǹ��������");
return;
}

customer.withDraw(money);
System.out.println("ȡ��ɹ����洢�����Ϊ:" + customer.getSa().getBalance());

}

// ����
public static void consume() {
if (customer == null) {
System.out.println("�ù˿���δ����");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("���������ѽ��:");
double money = scan.nextDouble();
customer.consume(money);
System.out.println("���ѳɹ������ÿ����Ϊ:" + customer.getCa().getBalance());
}

// ����
public static void repay() {
if (customer == null) {
System.out.println("�ù˿���δ����");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("�����뻹����:");
double money = scan.nextDouble();
customer.repay(money);
System.out.println("����ɹ������ÿ����Ϊ:" + customer.getCa().getBalance());
}

// ����:
public static void setter() {
if (customer == null) {
System.out.println("�ù˿���δ����");
return;
}
customer.setter();
System.out.println("�洢�����Ϊ��" + customer.getSa().getBalance());
System.out.println("���ÿ����Ϊ��" + customer.getCa().getBalance());
}

public static void queryBalance() {
if (customer == null) {
System.out.println("�ù˿���δ����");
return;
}
System.out.println(customer.getSa().toString());
System.out.println(customer.getCa().toString());
}

}