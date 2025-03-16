
public class Employee {

    private int employeeId;
    private String employeeName;
    private int salary;
    private String location;
    private String role;

    Employee(String name){
        this.employeeName = name;
    }

    Employee(int id, String name){
        this.employeeId = id;
        this.employeeName = name;
    }

    void display(){
        System.out.println("Name of the employee : " + employeeName + " with id : " + employeeId);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
