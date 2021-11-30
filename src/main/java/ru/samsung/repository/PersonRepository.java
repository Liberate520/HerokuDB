package ru.samsung.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.samsung.Entity.Person;

import java.util.List;

@Component
public class PersonRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createPerson(String name, String ip){
        return jdbcTemplate.update("INSERT INTO \"ROOMS\" (\"PLAYER\", \"IP\") VALUES(?)", name, ip);
    }

    public int updatePerson(Person person){
        return jdbcTemplate.update("UPDATE \"ROOMS\" SET \"PLAYER\" = ? WHERE \"ID\" = ?", person.getName(), person.getId());
    }

    public int deletePerson(Integer id){
        return jdbcTemplate.update("DELETE FROM \"ROOMS\" WHERE \"ID\" = ?",id);
    }

    public Person getPerson(Integer id){
        return jdbcTemplate.queryForObject("SELECT * FROM \"ROOMS\" WHERE \"ID\"=?", new PersonMapper(), id);
    }

    public List<Person> getPersons(){
        return jdbcTemplate.query("SELECT * FROM \"ROOMS\"", new PersonMapper());
    }
}
