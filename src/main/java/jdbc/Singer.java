package jdbc;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Singer {

    private long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private Album album;
}
