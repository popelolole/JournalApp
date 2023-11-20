package se.kthraven.journalapp.config;

import org.aspectj.bridge.IMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import se.kthraven.journalapp.Model.*;
import se.kthraven.journalapp.Persistence.*;

@Configuration
public class AppConfig {

    @Bean
    public IMessageService IMessageService(){return new MessageService();}
    @Bean
    public IMessagePersistence IMessagePersistence(){return new MessagePersistence();}
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
