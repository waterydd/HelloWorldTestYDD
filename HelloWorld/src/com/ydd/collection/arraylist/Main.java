package com.ydd.collection.arraylist;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                EmployeeManage em = new EmployeeManage();
                Scanner sr = new Scanner(System.in);
                //����ѡ��˵�
                while(true){
                        System.out.println("*************************************");
                        System.out.println("��˾Ա�����ʹ���ϵͳ");
                        System.out.println("1��¼����Ա��");
                        System.out.println("2�����ݹ��Ų���Ա����Ϣ");
                        System.out.println("3����ʾ����Ա����Ϣ");
                        System.out.println("4�����ݹ����޸�Ա������");
                        System.out.println("5��ɾ��ָ��Ա����Ϣ");
                        System.out.println("6������������");
                        System.out.println("7���鿴ƽ������");
                        System.out.println("0���˳�ϵͳ");
                        System.out.print("�������Ӧ�����ֽ��в�����");
                        int key = sr.nextInt();
                        System.out.println("*************************************");
                        switch(key){
                        case 1:
                                System.out.println("��¼����Ա����Ϣ");
                                System.out.print("���ţ�");
                                String empNo = sr.next();
                                System.out.print("������");
                                String name= sr.next();
                                System.out.print("���ʣ�");
                                float salary= sr.nextFloat();
                                Employee emp = new Employee(empNo, name, salary);
                                em.addEmp(emp);
                                System.out.println("¼��ɹ���");
                                break;
                        case 2:
                                System.out.println("�������Ա�����ţ�");
                                String empNo1 = sr.next();
                                em.showEmpNo(empNo1);
                                break;
                        case 3:
                                System.out.println("��˾����Ա����Ϣ���£�");
                                em.showAll();
                                break;
                        case 4:
                                System.out.println("�����빤�ţ�");
                                String empNo11=sr.next();
                                System.out.println("�������޸�Ϊ��");
                                float newSal=sr.nextFloat();
                                em.updateSalary(empNo11, newSal);
                                break;
                        case 5:
                                System.out.println("������Ҫɾ����Ա�Ĺ��ţ�");
                                String empNo111=sr.next();
                                em.deletEmp(empNo111);
                                break;
                        case 6:
                                System.out.println("�Ѱ�н�ʸߵͽ����������£�");
                                em.sortSalary();
                                break;
                        case 7:
                                System.out.println("��ʾƽ�����ʼ���ߡ���͹�����Ա��Ϣ���£�");
                                em.Average();
                                break;
                        case 0:
                                System.out.println("�������˳�!");
                                System.exit(0);
                        default:
                                System.out.println("�����������������!");
                                break;                        
                        }
                }
        }

}
