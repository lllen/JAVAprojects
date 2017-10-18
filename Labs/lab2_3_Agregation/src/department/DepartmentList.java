package department;

import java.util.ArrayList;

public class DepartmentList {
    private ArrayList<Department> departmentList;

    DepartmentList(DepartmentListBuilder departmentListBuilder){
        this.departmentList=departmentListBuilder.getDepartmentList();
    }

    public static class DepartmentListBuilder{
        private ArrayList<Department> departmentList;

        public ArrayList<Department> getDepartmentList() {
            return this.departmentList;
        }

        public void setDepartmentList(ArrayList<Department> departmentList) {
            this.departmentList = departmentList;
        }

        public DepartmentList build(){
            return new DepartmentList(this);
        }
    }
    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }
    public double getAverageSalary(){
        double averageSalary=0;
        for(int i=0;i<this.departmentList.size();i++){
            averageSalary+=this.departmentList.get(i).getAverageSalary();
        }
        return averageSalary/this.departmentList.size();
    }
    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
