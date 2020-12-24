package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Increment a value by delta and return the new value.
 *
 * @param delta the amount the value should be incremented by
 * @return the post-incremented value
 **/
@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "department_id")
    @GenericGenerator(strategy = "increment", name = "inc")
    @GeneratedValue(generator = "inc")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    //SQL 查询一个部门里面所有的员工
    @OneToMany(mappedBy = "department")
    List<Employee> employees = new ArrayList<>();

    public Department(){

    }

    public Department(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
