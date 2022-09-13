package spring_crud.entities;

import javax.persistence.*;

@Entity
@Table(name = "coctails")
public class Coctail implements Persistable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "alcohol_volume")
    private double alcoholVolume;

    public Coctail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAlcoholVolume() {
        return alcoholVolume;
    }

    public void setAlcoholVolume(double percentage) {
        this.alcoholVolume = percentage;
    }
}
