package com.ydd.collection.arraylist;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                EmployeeManage em = new EmployeeManage();
                Scanner sr = new Scanner(System.in);
                //制作选项菜单
                while(true){
                        System.out.println("*************************************");
                        System.out.println("公司员工工资管理系统");
                        System.out.println("1、录入新员工");
                        System.out.println("2、根据工号查找员工信息");
                        System.out.println("3、显示所有员工信息");
                        System.out.println("4、根据工号修改员工工资");
                        System.out.println("5、删除指定员工信息");
                        System.out.println("6、按工资排序");
                        System.out.println("7、查看平均工资");
                        System.out.println("0、退出系统");
                        System.out.print("请输入对应的数字进行操作：");
                        int key = sr.nextInt();
                        System.out.println("*************************************");
                        switch(key){
                        case 1:
                                System.out.println("请录入新员工信息");
                                System.out.print("工号：");
                                String empNo = sr.next();
                                System.out.print("姓名：");
                                String name= sr.next();
                                System.out.print("工资：");
                                float salary= sr.nextFloat();
                                Employee emp = new Employee(empNo, name, salary);
                                em.addEmp(emp);
                                System.out.println("录入成功！");
                                break;
                        case 2:
                                System.out.println("请入查找员工工号：");
                                String empNo1 = sr.next();
                                em.showEmpNo(empNo1);
                                break;
                        case 3:
                                System.out.println("公司所有员工信息如下：");
                                em.showAll();
                                break;
                        case 4:
                                System.out.println("请输入工号：");
                                String empNo11=sr.next();
                                System.out.println("将工资修改为：");
                                float newSal=sr.nextFloat();
                                em.updateSalary(empNo11, newSal);
                                break;
                        case 5:
                                System.out.println("请输入要删除人员的工号：");
                                String empNo111=sr.next();
                                em.deletEmp(empNo111);
                                break;
                        case 6:
                                System.out.println("已按薪资高低进行排序如下：");
                                em.sortSalary();
                                break;
                        case 7:
                                System.out.println("显示平均工资及最高、最低工资人员信息如下：");
                                em.Average();
                                break;
                        case 0:
                                System.out.println("已正常退出!");
                                System.exit(0);
                        default:
                                System.out.println("输入错误，请重新输入!");
                                break;                        
                        }
                }
        }

}
