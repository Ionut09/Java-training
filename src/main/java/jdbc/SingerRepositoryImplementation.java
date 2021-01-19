package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.PagedResultsControl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingerRepositoryImplementation implements SingerRepository {

    public static void main(String... args) {
        SingerRepository repo = new SingerRepositoryImplementation();
        Singer singer = Singer.builder()
                              .firstName("Elvis")
                              .lastName("Presley")
                              .birthDate(LocalDate.of(1950, 6, 20))
                              .build();
        repo.save(singer);

        Singer singer1 = repo.findById(1);
        System.out.println(singer1);

        repo.findAllBornAfter(LocalDate.of(1940, 1, 1))
            .forEach(System.out::println);
    }

    @Override
    public void save(Singer singer) {
        try (Connection connection = getConnection()) {
//            statement.execute("insert into singer (firstName, lastName, birthDate ) values ("+singer.getFirstName() +","
//                    +singer.getLastName() +","+singer.")")

            String insertStatement = "insert into singer (firstName, lastName, birthDate ) values (?, ? , ?)";
            var preparedStatement = connection.prepareStatement(insertStatement);

            preparedStatement.setString(1, singer.getFirstName());
            preparedStatement.setString(2, singer.getLastName());
            preparedStatement.setDate(3, Date.valueOf(singer.getBirthDate()));

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0) {
                throw new RuntimeException("Insert failed");
            }
        } catch (SQLException ex) {
//            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Singer findById(long id) {
        try (Connection connection = getConnection()) {

            String query = "select * from singer where id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Singer.builder()
                             .id(resultSet.getLong("id"))
                             .firstName(resultSet.getString("firstName"))
                             .lastName(resultSet.getString("lastName"))
                             .birthDate(resultSet.getDate("birthDate").toLocalDate())
                             .build();
            } else {
                throw new RuntimeException("Select failed");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Singer> findAllBornAfter(LocalDate startBirthDate) {
        try (Connection connection = getConnection()) {
            //native queries
            String query = "SELECT * FROM singer WHERE birthDate > ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, Date.valueOf(startBirthDate));

            ResultSet resultSet = preparedStatement.executeQuery();

            var singers = new ArrayList<Singer>();

            while (resultSet.next()) {
                var singer = Singer.builder()
                                   .id(resultSet.getLong("id"))
                                   .firstName(resultSet.getString("firstName"))
                                   .lastName(resultSet.getString("lastName"))
                                   .birthDate(resultSet.getDate("birthDate").toLocalDate())
                                   .build();
                singers.add(singer);
            }
            return singers;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(long id) {

    }

//    java.sql

    //docker run -d -p 3321:3306 --name=mysql-server-local --env="MYSQL_ROOT_PASSWORD=secret-pass" mysql
    private Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3321/spotify",
                                        "root",
                                        "secret-pass");
    }
}
