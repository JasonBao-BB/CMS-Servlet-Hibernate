package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Increment a value by delta and return the new value.
 *
 * @param delta the amount the value should be incremented by
 * @return the post-incremented value
 **/
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GenericGenerator(strategy = "increment", name = "inc")
    @GeneratedValue(generator = "inc")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(){

    }

    public Employee(String firstName, String lastName, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
