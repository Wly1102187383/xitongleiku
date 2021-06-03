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
System.out.println("退出成功！");
}
choice = menu();

}
System.out.println("欢迎下次使用！");

}

public static int menu() {
int choice = 0;

System.out.println("====欢迎使用WTU银行======");
System.out.println("1.开户");
System.out.println("2.存款");
System.out.println("3.取款");
System.out.println("4.消费");
System.out.println("5.还款");
System.out.println("6.结算");
System.out.println("7.查询余额");
System.out.println("8.退出");
System.out.println("请输入选择(1-8):");
Scanner scan = new Scanner(System.in);
choice = scan.nextInt();

return choice;
}

public static int subMenu() {
int choice = 0;

System.out.println("====欢迎使用WTU银行开户======");
System.out.println("1.存储卡");
System.out.println("2.信用卡");
System.out.println("3.返回");
System.out.println("请输入选择(1-3):");
Scanner scan = new Scanner(System.in);
choice = scan.nextInt();

return choice;
}

public static void create() {
Scanner scan = new Scanner(System.in);
String choose = "";
if (customer != null) {
System.out.println("顾客信息已存在，是否重新（y/n）？");
choose = scan.nextLine();
if (choose.equalsIgnoreCase("n")) {
return;
}
}

System.out.print("请输入身份证号：");
String ssn = scan.nextLine();
System.out.print("请输入姓名：");
String name = scan.nextLine();

customer = new Customer(ssn, name);

int choice = subMenu();
while (choice != 3) {
switch (choice) {
case 1:createSavingAccount();break;
case 2:createCheckingAccount();break;
default:
System.out.println("选择无效，请重新选择！");
}
choice = subMenu();

}

}

public static void createSavingAccount() {
Scanner scan = new Scanner(System.in);
String choose = "";
if(customer.getSa()!=null){
System.out.println("存储卡已存在，是否重新(y/n):");
choose = scan.nextLine();
if(choose.equalsIgnoreCase("n")){
return;
}
}
System.out.println("请输入存储卡卡号：");
String accountNo = scan.nextLine();
System.out.println("请输入存款利率:");
double interestRate = scan.nextDouble();
SavingAccount sa = new SavingAccount(accountNo,0,interestRate);
customer.setSa(sa);
System.out.println("存储卡开卡成功，信息如下:");
System.out.println(customer.getSa().toString());
}

public static void createCheckingAccount() {
Scanner scan = new Scanner(System.in);
String choose = "";
if(customer.getCa()!=null){
System.out.println("信用已存在，是否重新(y/n):");
choose = scan.nextLine();
if(choose.equalsIgnoreCase("n")){
return;
}
}
System.out.println("请输入存储卡卡号：");
String accountNo = scan.nextLine();
System.out.println("请输入服务费:");
double serviceCharge = scan.nextDouble();
CheckingAccount ca = new CheckingAccount(accountNo,0,serviceCharge);
customer.setCa(ca);
System.out.println("信用卡开卡成功，信息如下:");
System.out.println(customer.getCa().toString());
}

// 存款
public static void save() {
if (customer == null) {
System.out.println("该顾客尚未开户");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("请输入存款金额:");
double money = scan.nextDouble();
customer.save(money);
System.out.println("存款成功，存储卡余额为:" + customer.getSa().getBalance());

}

// 取款
public static void withDraw() {
if (customer == null) {
System.out.println("该顾客尚未开户");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("请输入取金额:");
double money = scan.nextDouble();

if (money > customer.getSa().getBalance()) {
System.out.println("很抱歉，余额不够！");
return;
}

customer.withDraw(money);
System.out.println("取款成功，存储卡余额为:" + customer.getSa().getBalance());

}

// 消费
public static void consume() {
if (customer == null) {
System.out.println("该顾客尚未开户");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("请输入消费金额:");
double money = scan.nextDouble();
customer.consume(money);
System.out.println("消费成功，信用卡余额为:" + customer.getCa().getBalance());
}

// 还款
public static void repay() {
if (customer == null) {
System.out.println("该顾客尚未开户");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("请输入还款金额:");
double money = scan.nextDouble();
customer.repay(money);
System.out.println("还款成功，信用卡余额为:" + customer.getCa().getBalance());
}

// 结算:
public static void setter() {
if (customer == null) {
System.out.println("该顾客尚未开户");
return;
}
customer.setter();
System.out.println("存储卡余额为：" + customer.getSa().getBalance());
System.out.println("信用卡余额为：" + customer.getCa().getBalance());
}

public static void queryBalance() {
if (customer == null) {
System.out.println("该顾客尚未开户");
return;
}
System.out.println(customer.getSa().toString());
System.out.println(customer.getCa().toString());
}

}