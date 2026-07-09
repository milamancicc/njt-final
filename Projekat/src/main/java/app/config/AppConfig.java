/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.config;


import app.repository.SportistaRepository;
import app.repository.SportistaVezbaRepository;
import app.repository.TrenerRepository;
import app.repository.VezbaRepository;
import app.service.SportistaService;
import app.service.SportistaVezbaService;
import app.service.TrenerService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author PC
 */
@Configuration
@EnableWebMvc
@ComponentScan("app")
public class AppConfig {
    
    @Bean
     public DataSource dataSource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/mim");
        datasource.setUsername("root");
        datasource.setPassword("");
        return datasource;
     }
    
    @Bean
     public JdbcTemplate getJdbcTemplate(DataSource ds){
         return new JdbcTemplate(ds);
     }
     
     @Bean(value = "sportista-service")
     public SportistaService createSportistaService(@Qualifier(value="sportista-repository") SportistaRepository sr,
             @Qualifier(value = "trener-repository") TrenerRepository tr){
         return new SportistaService(sr, tr);
     }
     
     @Bean(value = "trener-service")
     public  TrenerService createTrenerService(@Qualifier(value="trener-repository") TrenerRepository tr){
         return new TrenerService(tr);
     }
     @Bean(value = "sportistaVezbe-service")
     public  SportistaVezbaService createSportistaVezbaService(@Qualifier(value="sportistaVezba-repository") SportistaVezbaRepository svr,
             @Qualifier(value="sportista-repository") SportistaRepository sr,
             @Qualifier(value = "vezba-repository") VezbaRepository vr){
         return new SportistaVezbaService(svr, sr, vr);
     }
    
}
