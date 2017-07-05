package com.ydd.collection.arraylist;

public class Employee {
        private String empNo;
        private String name;
        private float salary;
        public Employee(String empNo, String name, float salary) {
                this.empNo = empNo;
                this.name = name;
                this.salary = salary;
        }
        public String getEmpNo() {
                return empNo;
        }
        public void setEmpNo(String empNo) {
                this.empNo = empNo;
        }
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public float getSalary() {
                return salary;
        }
        public void setSalary(float salary) {
                this.salary = salary;
        }
        

}
