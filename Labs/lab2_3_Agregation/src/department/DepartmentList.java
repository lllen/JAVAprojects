package department;

import java.util.ArrayList;
import java.util.Objects;

public class DepartmentList {
    private ArrayList<Department> departmentList;

    public static DepartmentListBuilder newDepartmentListBuilder(){
        return new DepartmentList().new DepartmentListBuilder();
    }

    //BUILDER inner class
    public class DepartmentListBuilder{
        private ArrayList<Department> departmentList;

        public ArrayList<Department> getDepartmentList() {
            return this.departmentList;
        }

        public void setDepartmentList(ArrayList<Department> departmentList) {
            this.departmentList = departmentList;
        }

        public DepartmentList build(){
            return DepartmentList.this;
        }
    }
    // end of BUILDER

    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentList that = (DepartmentList) o;
        return Objects.equals(departmentList, that.departmentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentList);
    }
}
