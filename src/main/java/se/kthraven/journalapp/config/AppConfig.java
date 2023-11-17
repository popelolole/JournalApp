package se.kthraven.journalapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import se.kthraven.journalapp.Model.CustomUserDetailsService;
import se.kthraven.journalapp.Model.IJournalService;
import se.kthraven.journalapp.Model.JournalService;
import se.kthraven.journalapp.Persistence.IJournalPersistence;
import se.kthraven.journalapp.Persistence.IUserPersistence;
import se.kthraven.journalapp.Persistence.JournalPersistence;
import se.kthraven.journalapp.Persistence.UserPersistence;

@Configuration
public class AppConfig {

    @Bean
    public IUserPersistence IUserPersistence(){
        return new UserPersistence();
    }

    @Primary
    @Bean
    public IJournalPersistence IJournalPersistence(){
        return new JournalPersistence();
    }

    @Bean
    public IJournalService IJournalService(){
        return new JournalService();
    }
}
