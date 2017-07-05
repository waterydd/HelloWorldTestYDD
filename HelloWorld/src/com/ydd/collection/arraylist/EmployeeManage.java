package com.ydd.collection.arraylist;

import java.util.ArrayList;

public class EmployeeManage {
        private ArrayList<Employee> all = null;

        public EmployeeManage() {
                all = new ArrayList<Employee>();
        }
        //������Ա��
        public void addEmp(Employee emp){
                all.add(emp);
        }
        
        //���ݹ��Ų鿴Ա����Ϣ
        public void showEmpNo(String empNo){
                for(int i=0; i<all.size(); i++){
                        Employee emp = all.get(i);
                        if (emp.getEmpNo().equals(empNo)){
                                System.out.println("�ҵ�"+empNo+"��Ա����");
                                System.out.println("����:"+emp.getEmpNo()+"\t����:"+emp.getName()+"\t����:"+emp.getSalary());
                        }else{
                                System.out.println("���Ų����ڻ��޴��ˣ�");
                        }
                }
        }
        
        //��ʾ����Ա����Ϣ
        public void showAll(){
                for(int i=0; i<all.size()-1; i++){      //ArrayList�������all��С������ѭ��
                        for(int j=1; j<all.size()-i; j++){
                                Employee emp1 = all.get(j-1);
                                Employee emp2 = all.get(j);
                                //ʹ�� compareTo �������� String ����ֵ�Ƚ�
                                if (emp1.getEmpNo().compareTo(emp2.getEmpNo()) >0){
                                        all.set(j, emp1);       //����ֵ������д�� all ��
                                        all.set(j-1, emp2);     //����ֵ������д�� all ��
                                }
                        }
                }
                for(Employee emp : all){
                        System.out.println("����:"+emp.getEmpNo()+"\t����:"+emp.getName()+"\t����:"+emp.getSalary());
                }
        }
        
        //�޸�Ա������
        public void updateSalary(String empNo, float newSalary){
                for(int i=0; i<all.size(); i++){
                        Employee emp = all.get(i);
                        if (emp.getEmpNo().equals(empNo)){
                                emp.setSalary(newSalary);
                                System.out.println("�����޸ĳɹ���");
                        }else{
                                System.out.println("���Ų����ڣ��޷�������");
                        }
                } 
        }
        
        //ɾ��ָ��Ա��
        public void deletEmp(String empNo){
                for(int i=0; i<all.size(); i++){
                        Employee emp = all.get(i);
                        if (emp.getEmpNo().equals(empNo)){
                                all.remove(i);
                                System.out.println("ָ��Ա��ɾ���ɹ���");
                        }
                }
        }
        
        //����������
        public void sortSalary(){
                for(int i=0; i<all.size()-1; i++){      //ArrayList�������all��С������ѭ��
                        for(int j=1; j<all.size()-i; j++){
                                Employee emp1 = all.get(j-1);
                                Employee emp2 = all.get(j);
                                if (emp1.getSalary() < emp2.getSalary()){
                                        all.set(j, emp1);       //����ֵ������д�� all ��
                                        all.set(j-1, emp2);     //����ֵ������д�� all ��
                                }
                        }
                }
                for (Employee emp : all){
                        System.out.println("����:"+emp.getEmpNo()+"\t����:"+emp.getName()+"\t����:"+emp.getSalary());
                }
        }
                
         //����ƽ������
        public void Average(){
                float sum = 0;
                float average = 0;
                for(int i=0; i<all.size(); i++){
                        Employee emp = all.get(i);
                        sum = sum + emp.getSalary();
                }
                average = sum/all.size();
                System.out.println(all.size()+"��Ա����ƽ������Ϊ��"+average);
        }
}
