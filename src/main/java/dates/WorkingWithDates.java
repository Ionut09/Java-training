package dates;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.time.LocalTime.now;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import static java.time.format.DateTimeFormatter.ofPattern;

public class WorkingWithDates {

    /**
     * all classes from java.time package are immutable, and have private constructors
     * time without timezones: {@link java.time.LocalDate}, java.time.LocalDateTime, java.time.LocalTime}
     * time with timezones: {@link java.time.ZonedDateTime}
     * conversion String -> any java.time object we use {@link java.time.format.DateTimeFormatter}
     */
    public static void main(String... args) throws JsonProcessingException {
        //creating dates
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2020, Month.DECEMBER, 25);

        LocalTime nowTime = now();
        LocalTime time = LocalTime.of(22, 8, 20);

        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime christmas = LocalDateTime.of(2020, Month.DECEMBER, 25, 8, 20);
        LocalDateTime dateTime1 = LocalDateTime.of(date, time);


        //compare them
        System.out.format("isAfter: %s%n", christmas.isAfter(LocalDateTime.now()));
        System.out.format("isBefore: %s%n", christmas.isBefore(LocalDateTime.now()));
        System.out.format("isEqual: %s%n", christmas.isEqual(LocalDateTime.now()));
        System.out.format("truncated LocalDateTime: %s%n", LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));

        //formatting
        var now1 = LocalDateTime.now();
        System.out.format("formatted LocalDateTime in yyyy-MM-dd HH:mm:ss format: %s%n", now1.format(ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.format("formatted LocalDateTime in ISO_LOCAL_DATE_TIME format: %s%n ", now1.format(ISO_DATE_TIME));

        //periods
        Duration duration = Duration.between(christmas, now1);
        System.out.format("Duration: %s%n", duration);
        System.out.format("Duration toDays: %s%n", duration.toDays());
        System.out.format("Duration toHours: %s%n", duration.toHours());
        System.out.format("Duration toMinutes: %s%n", duration.toMinutes());


        //adding and substracting
        duration = duration.plusDays(2);
        duration = duration.plusHours(2);
        System.out.format("Duration: %s%n", duration);

        var localTime = time.plusMinutes(15);
        var aWeekAfter = dateTime1.plusWeeks(1);
        var christmas8AClock = christmas.minusMinutes(20);

        //parsing dates from String
        var parsedDateTime = LocalDateTime.parse("2021-01-11T17:36:36");
        System.out.format("parsed dateTime: %s%n", parsedDateTime);

        var formatter = ofPattern("HH:mm:ss'$'MM-dd-yyyy");
        var parsedDateTime1 = LocalDateTime.parse("17:36:36$11-01-2020", formatter);

        System.out.format("parsed dateTime: %s%n", parsedDateTime1.format(formatter));

        var user = new User("John Doe", parsedDateTime1);
        var mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        var userJson = mapper.writeValueAsString(user);

        /**
         * replaceAll is just for making the json pretty
         */
        System.out.println("userJson = " + userJson.replaceAll("\\{","\\{\n\t")
                                                   .replaceAll(",",",\n\t")
                                                   .replaceAll("\\}","\n\\}")
        );
    }
}

