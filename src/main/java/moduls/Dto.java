package moduls;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class Dto {
    @CsvBindByName(column = "id")
    private BigDecimal Id;
    @CsvBindByName(column = "name")
    private String Name;
    @CsvBindByName(column = "gender")
    private Genders Gender;
    @CsvBindByName(column = "BirtDate")
    private String DayOfBirt;
    @CsvBindByName(column = "Salary")
    private Integer Salary;
    @CsvBindByName(column = "Division")
    private String division;
}
