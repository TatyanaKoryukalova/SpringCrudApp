package spring_crud.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Persistable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //    @Column(name = "name")
    private String name;
    //    @Column(name = "sex")
//    private String sex;
//    @Column(name = "age")
    private int age;
    //    @Column(name = "weight")
    private int weight;

    //todo
    public User() {
    }

    public User(Integer id, String name, int age, int weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public User(String name, int age, int weight) {
        this.name = name;
//        this.sex = sex;
        this.age = age;
        this.weight = weight;
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

//    public String getSex() {
//        return sex;
//    }

//    public void setSex(String sex) {
//        this.sex = sex;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("[id: %s, name: %s, age: %s, weight: %s]", id, name, age, weight);
    }
}
