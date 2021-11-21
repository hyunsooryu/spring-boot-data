package me.hyunsoo.artofspringbootdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//슬라이싱 테스트를 할때는 반드시, 인메모리 데이터 베이스가 필요합니다.

// H2 와 같은 DB가 꼭 필요합니다.

@DataJpaTest
class AcountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    void dependencyInjectionTest() throws SQLException {
        System.out.println(dataSource.getConnection().getMetaData().getUserName());
        System.out.println(dataSource.getConnection().getMetaData().getURL());
    }

    @Test
    void accountMakingTest(){
        Account account = new Account();
        account.setUsername("hyunsoo");
        account.setPassword("100825asa!");
        Account savedAccount = accountRepository.save(account);

        assertThat(savedAccount).isNotNull();

        Optional<Account> existAccount = accountRepository.findByUsername(account.getUsername());

        assertThat(existAccount).isNotEmpty();

        existAccount.ifPresent(account1->{
            System.out.println(account1);
        });

    }

}