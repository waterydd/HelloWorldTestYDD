package com.ydd.collection.arraylist;

import java.util.ArrayList;

public class EmployeeManage {
        private ArrayList<Employee> all = null;

        public EmployeeManage() {
                all = new ArrayList<Employee>();
        }
        //加入新员工
        public void addEmp(Employee emp){
                all.add(emp);
        }
        
        //根据工号查看员工信息
        public void showEmpNo(String empNo){
                for(int i=0; i<all.size(); i++){
                        Employee emp = all.get(i);
                        if (emp.getEmpNo().equals(empNo)){
                                System.out.println("找到"+empNo+"号员工：");
                                System.out.println("工号:"+emp.getEmpNo()+"\t姓名:"+emp.getName()+"\t工资:"+emp.getSalary());
                        }else{
                                System.out.println("工号不存在或无此人！");
                        }
                }
        }
        
        //显示所有员工信息
        public void showAll(){
                for(int i=0; i<all.size()-1; i++){      //ArrayList集合类的all大小，控制循环
                        for(int j=1; j<all.size()-i; j++){
                                Employee emp1 = all.get(j-1);
                                Employee emp2 = all.get(j);
                                //使用 compareTo 方法进行 String 类型值比较
                                if (emp1.getEmpNo().compareTo(emp2.getEmpNo()) >0){
                                        all.set(j, emp1);       //交换值，重新写入 all 中
                                        all.set(j-1, emp2);     //交换值，重新写入 all 中
                                }
                        }
                }
                for(Employee emp : all){
                        System.out.println("工号:"+emp.getEmpNo()+"\t姓名:"+emp.getName()+"\t工资:"+emp.getSalary());
                }
        }
        
        //修改员工工资
        public void updateSalary(String empNo, float newSalary){
                for(int i=0; i<all.size(); i++){
                        Employee emp = all.get(i);
                        if (emp.getEmpNo().equals(empNo)){
                                emp.setSalary(newSalary);
                                System.out.println("工资修改成功！");
                        }else{
                                System.out.println("工号不存在，无法操作！");
                        }
                } 
        }
        
        //删除指定员工
        public void deletEmp(String empNo){
                for(int i=0; i<all.size(); i++){
                        Employee emp = all.get(i);
                        if (emp.getEmpNo().equals(empNo)){
                                all.remove(i);
                                System.out.println("指定员工删除成功！");
                        }
                }
        }
        
        //按工资排序
        public void sortSalary(){
                for(int i=0; i<all.size()-1; i++){      //ArrayList集合类的all大小，控制循环
                        for(int j=1; j<all.size()-i; j++){
                                Employee emp1 = all.get(j-1);
                                Employee emp2 = all.get(j);
                                if (emp1.getSalary() < emp2.getSalary()){
                                        all.set(j, emp1);       //交换值，重新写入 all 中
                                        all.set(j-1, emp2);     //交换值，重新写入 all 中
                                }
                        }
                }
                for (Employee emp : all){
                        System.out.println("工号:"+emp.getEmpNo()+"\t姓名:"+emp.getName()+"\t工资:"+emp.getSalary());
                }
        }
                
         //计算平均工资
        public void Average(){
                float sum = 0;
                float average = 0;
                for(int i=0; i<all.size(); i++){
                        Employee emp = all.get(i);
                        sum = sum + emp.getSalary();
                }
                average = sum/all.size();
                System.out.println(all.size()+"人员工的平均工资为："+average);
        }
}
