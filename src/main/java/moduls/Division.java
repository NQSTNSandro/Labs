package moduls;


import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Divisions")
public class Division {
    @javax.persistence.Id
    @Column(name = "id")
    private Integer Id;
    @Column(name = "Division")
    private String division;

    @Override
    public String toString() {
        return "Id=" + Id + ",Division=" + division;
    }


}
