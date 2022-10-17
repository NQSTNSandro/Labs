package moduls;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
@Table(name = "Humans")
@Entity
public class Human {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Key")
    private Long Key;
    @Column(name = "Id", unique = true)
    private BigDecimal Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "BirtDate")
    private String DayOfBirt;
    @Column(name = "Salary")
    private Integer Salary;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Division_id", referencedColumnName = "id")
    private Division division;
    @Column(name = "Gender")
    private Genders gender;
    @Override
    public String toString() {
        return "Human[id=" + Id + ",name=" + Name + ",BirtDate=" + DayOfBirt + ",Salary=" + Salary + ",Gender=" + gender + "]";
    }
}
