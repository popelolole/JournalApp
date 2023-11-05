package se.kthraven.journalapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.kthraven.journalapp.Model.IJournalService;
import se.kthraven.journalapp.Model.JournalService;
import se.kthraven.journalapp.Persistence.IJournalPersistence;
import se.kthraven.journalapp.Persistence.JournalPersistence;

@Configuration
public class AppConfig {

    @Bean
    public IJournalPersistence IJournalPersistence(){
        return new JournalPersistence();
    }

    @Bean
    public IJournalService IJournalService(){
        return new JournalService();
    }
}
