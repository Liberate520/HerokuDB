package ru.samsung.repository;

import org.springframework.jdbc.core.RowMapper;
import ru.samsung.Entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setIp(rs.getString("ip"));
        return person;
    }
}
