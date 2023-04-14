import java.util.Objects;

public class Employee {
    private final String name;
    private int department;
    private int salary;
    private int id;

    private static int count = 0;





    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = count++;

    }

    @Override
    public String toString() {
        return id + ". " + name + ", " + department + ", " + salary;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o ) return true;
        if (o == null || getClass() != o.getClass() || this.hashCode() != o.hashCode()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return id + department + salary + name.hashCode();
    }
}
