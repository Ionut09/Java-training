package jdbc;

import java.time.LocalDate;
import java.util.List;

public interface SingerRepository {

    void save(Singer singer);

    Singer findById(long id);

    List<Singer> findAllBornAfter(LocalDate startBirthDate);

    void delete(long id);
}
