package me.hyunsoo.artofspringbootdata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MysqlRunner implements ApplicationRunner {

    private final JdbcTemplate jdbcTemplate;

    private final DataSource dataSource;

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /**
        try(Connection connection = dataSource.getConnection()) {
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (ID))";
            statement.executeUpdate(sql);
        }
       // jdbcTemplate 을 사용하면, 예외처리 가독성도 좋고, Resource에 대한 처리가 더좋아요
        //기본 jdbc 보다 더 좋다
        jdbcTemplate.execute("INSERT INTO USER VALUES(1, 'HYUNSOO')");**/


        Optional<User> user = userRepository.findById(1L);
        if(user.isPresent()){
            System.out.println(user);
        }else{
            System.out.println("no user like that");
        }


    }
}
