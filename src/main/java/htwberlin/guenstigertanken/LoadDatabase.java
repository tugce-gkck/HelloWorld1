package htwberlin.guenstigertanken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {

    Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void reCreate() {


        jdbcTemplate.execute("DROP TABLE Tanken;");

        jdbcTemplate.execute("CREATE TABLE Tanken(" +
                "id SERIAL,"+
                "date timestamp with time zone NOT NULL,"+
                "name VARCHAR(255)," +
                "city varchar(255) NOT NULL,"+
                "distance DECIMAL(15,2),"+
                "price DECIMAL(15,2)," +
                "wc BOOLEAN," +
                "restaurant BOOLEAN," +
                "carwash BOOLEAN," +
                "primary key (id, date));");

        /*List<Tanken> tanken = new ArrayList<>();
        tanken.add(new Tanken("2021-05-17 15:07:00","Aral", "Berlin", 4,1.1,true,true,true));
        tanken.add(new Tanken("2021-05-17 15:07:00","Shell", "Hamburg", 10.2,1.09,true,false,false));
        tanken.add(new Tanken("2021-05-17 15:07:00","Hem", "Frankfurt", 34,1.3,true,false,true));

        for(Tanken entry: tanken){
            // Uses JdbcTemplate's update
            jdbcTemplate.update("INSERT INTO Tanken(date, name, city, distance, price, wc, restaurant, carwash) VALUES (?,?,?,?,?,?,?,?)", entry.getDate(), entry.getName(), entry.getCity(), entry.getDistance(), entry.getPrice(), entry.isWc(), entry.isRestaurant(),entry.isCarwash());
        }*/

    }
    @Bean
    CommandLineRunner initDatabase(TankenRepository repository, UserRepository user) {

        /*jdbcTemplate.execute("DROP TABLE Tanken;");

        jdbcTemplate.execute("CREATE TABLE Tanken(" +
                "id SERIAL,"+
                "date timestamp with time zone NOT NULL,"+
                "name VARCHAR(255)," +
                "city varchar(255) NOT NULL,"+
                "reporter varchar(40) NOT NULL,"+
                "distance DECIMAL(15,2),"+
                "price DECIMAL(15,2)," +
                "wc BOOLEAN," +
                "restaurant BOOLEAN," +
                "carwash BOOLEAN," +
                "primary key (id, date));");

        jdbcTemplate.execute("CREATE TABLE Users(" +
                "username VARCHAR(40) NOT NULL UNIQUE PRIMARY KEY ,"+
                "password VARCHAR(40) NOT NULL);");
                 */
        user.deleteAll();
        user.save(new User("tugce","passwort"));

        repository.deleteAll();
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now());
        repository.save(new Tanken(ts,"Total", "Berlin","tugce", 4,1.01,true,true,true));
        repository.save(new Tanken(ts,"Shell", "Berlin","tugce", 5,1.50,true,false,false));
        repository.save(new Tanken(ts,"Esso", "Berlin","tugce", 4.7,1.18,true,false,true));
        repository.save(new Tanken(ts,"Total", "Hamburg","tugce", 52,1.22,true,true,false));
        repository.save(new Tanken(ts,"Aral", "Hamburg","tugce", 53.9,1.11,true,false,false));
        repository.save(new Tanken(ts,"Agip", "Hamburg","tugce", 52.6,1.32,false,false,false));
        repository.save(new Tanken(ts,"Total", "Dresden","tugce", 75.3,1.91,true,false,true));
        repository.save(new Tanken(ts,"Aral", "Dresden","tugce", 74.2,1.64,true,true,false));
        repository.save(new Tanken(ts,"Aral", "Frankfurt","tugce", 135.7,1.71,true,false,true));
        repository.save(new Tanken(ts,"Esso", "München","tugce", 130.5,1.01,false,false,false));
        repository.save(new Tanken(ts,"Total", "München","tugce", 132.6,1.12,true,true,true));
        repository.save(new Tanken(ts,"Aral", "München","tugce", 133.9,1.00,true,false,false));
        repository.save(new Tanken(ts,"Shell", "München","tugce", 140,1.80,false,false,false));

        return args -> {
        };
    }

}
