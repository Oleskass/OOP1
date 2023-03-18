package homework.hw7_hashcode;

import java.util.Objects;

public class Employee {
    /*
     * Создать класс Сотрудник (Employee) с полями:
     * Имя, Фамилия (String)
     * Название отдела (String)
     * Зарплата (double)
     * Реализовать equals и hashCode, который работает только с именем и фамилией
     */

    String name;
    String surname;
    String department;
    double salary;

    public Employee(String name, String surname, String department, double salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee worker = (Employee) o;
        return name == worker.name && surname == worker.surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

}
