package servises;

import com.opencsv.bean.CsvToBeanBuilder;
import moduls.Dto;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DtoService {
    /**
     * путь к файлу
     */
    private static final String file = "C:\\Users\\serge\\IdeaProjects\\Labs\\src\\main\\resources\\foreign_names.csv";

    /**
     *
     * @return HashMap, где ключами являются дивизионы, а значениями люди относящиеся к этим дивизионам.
     */
    public Map<String, List<Dto>> func() {
        List<Dto> dtos;
        try (FileReader fileReader = new FileReader(file)) {
            dtos = new CsvToBeanBuilder<Dto>(fileReader).withType(Dto.class)
                    .withSeparator(';').build().parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, List<Dto>> map = new HashMap<>();
        for (Dto dto : dtos) {
            List<Dto> list = map.get(dto.getDivision());
            if (list == null)
                list = new ArrayList<>();
            list.add(dto);
            map.put(dto.getDivision(), list);

        }
        return map;

    }
}
