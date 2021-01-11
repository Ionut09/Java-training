package dates;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User{

    private String name;

    /**
     * All was needed is mapper.registerModule(new JavaTimeModule()); (see WorkingWithDates main method)
     * and in build.gradle I added dependency:
     * compile group: 'com.fasterxml.jackson.datatype', name: 'jackson-datatype-jsr310', version: '2.11.1'
     */
    @JsonFormat(shape = STRING, pattern = "HH:mm:ss'$'MM-dd-yyyy") //you can put any pattern you like here
    private LocalDateTime birthDate;
}
