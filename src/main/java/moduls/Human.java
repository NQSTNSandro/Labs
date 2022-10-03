package moduls;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
@Table(name = "Humans")
public class Human {
    @javax.persistence.Id
    @Column(name = "id")
    private BigDecimal Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "BirtDate")

    private String DayOfBirt;
    @Column(name = "Salary")
    private Integer Salary;

    /*private Division division;*/
    @Column(name = "Gender")
    private Genders gender;

    @Override
    public String toString() {
        return "Human[id=" + Id + ",name=" + Name + ",BirtDate=" + DayOfBirt + ",Salary=" + Salary + "]";
    }
}
