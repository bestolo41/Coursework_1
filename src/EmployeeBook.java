import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook(int size) {
        this.employees = new Employee[size];
    }

    public Employee[] getEmployees() {
        return employees;
    }


    public void printEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public void addNewEmployee(String name, int departmentNum, int salary) {
        Employee newEmployee = new Employee(name, departmentNum, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return;
            }
        }
    }

    public void removeEmployee(String name) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getName().equalsIgnoreCase(name)) {
                employees[i] = null;
                return;
            }
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
    }


    public int countSalarySum() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum = sum + employees[i].getSalary();
            }
        }
        return sum;
    }

    public Employee findEmployeeWithMinSalary() {
        int min = Integer.MAX_VALUE;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    public Employee findEmployeeWithMaxSalary() {
        int max = Integer.MIN_VALUE;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    public double calcAverageSalary() {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) count++;
        }
        double average = (double) countSalarySum() / count;
        return average;
    }

    public void getNamesOfEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getName());
            }
        }
    }

    public void salaryIndexing(int percentage) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() + (employees[i].getSalary() * percentage / 100));
            }
        }
    }

    public Employee findEmpWithMinSalInDep(int departmentNum) {
        int min = Integer.MAX_VALUE;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNum && employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    public Employee findEmpWithMaxSalInDep(int departmentNum) {
        int max = Integer.MIN_VALUE;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNum && employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    public int countSalarySumInDep(int departmentNum) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNum) {
                sum = sum + employees[i].getSalary();
            }
        }
        return sum;
    }

    public double calcAverageSalaryInDep(int departmentNum) {
        int quantityEmpInDep = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNum) {
                quantityEmpInDep += 1;
            }
        }
        double average = (double) countSalarySumInDep(departmentNum) / quantityEmpInDep;
        return average;
    }

    public void salaryIndexingInDep(int departmentNum, int percentage) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNum) {
                employees[i].setSalary(employees[i].getSalary() + (employees[i].getSalary() * percentage / 100));
            }
        }
    }

    public void printEmployeesInDep(int departmentNum) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNum) {
                System.out.println(employees[i].getId() + ". " + employees[i].getName() + ", " + employees[i].getSalary());
            }
        }
    }

    public void findEmpsWithSalLess(int value) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < value) {
                System.out.println(employees[i]);
            }
        }
    }

    public void findEmpsWithSalMore(int value) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > value) {
                System.out.println(employees[i]);
            }
        }
    }

    public void setEmployeeDepartment(String name, int newDepartmentNum) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getName().equalsIgnoreCase(name)) {
                employees[i].setDepartment(newDepartmentNum);
                return;
            }
        }
    }

    public void setEmployeeSalary(String name, int newSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getName().equalsIgnoreCase(name)) {
                employees[i].setSalary(newSalary);
                return;
            }
        }
    }

    public void printNamesByDepartments() {                     //берем отдел из массива с отделами и по нему ищем сотрудников.
        for (int i = 0; i < SaveDepartments().length; i++) {
            if (SaveDepartments()[i] != 0) {
            System.out.println("Отдел " + SaveDepartments()[i]);
            for (int j = 0; j < employees.length; j++) {
                if (employees[j] != null && employees[j].getDepartment() == SaveDepartments()[i]) {
                    System.out.println(employees[j].getName());
                }
            }
            }
        }
    }

    private int[] SaveDepartments() {                 //ищем и сохраняем в массив неповторяющиеся отделы, мы же можем не знать сколько всего и какие отделы есть
        int[] departments = new int[employees.length];       //их количество не может быть больше количества сотрудников, поэтому размер массива равно размер книги.
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (!repeatedOrNot(departments, employees[i].getDepartment())) {    //если номер отдела уже записан в массив, то второй раз его не записываем.
                    departments[i] = employees[i].getDepartment();
                }
            }
        }
        return departments;
    }

    private static boolean repeatedOrNot(int[] array, int value) {  //метод для определения повторяется номер отдела в массиве или нет.
        boolean equals = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || this.hashCode() != o.hashCode()) return false;
        EmployeeBook that = (EmployeeBook) o;
        if (this.employees.length != that.employees.length) return false;
        boolean equals = false;
        for (int i = 0; i < employees.length; i++) {
            if (this.employees[i].equals(that.employees[i])) {
                equals = true;
            } else return false;
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }

    @Override
    public String toString() {
        String list = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                list = list + employees[i].toString() + "\n";
            }
        }
        return list;
    }
}

