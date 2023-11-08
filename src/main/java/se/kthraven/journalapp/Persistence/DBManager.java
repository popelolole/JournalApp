package se.kthraven.journalapp.Persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBManager {
    private static EntityManagerFactory emf;

    protected static void init() {
        emf = Persistence.createEntityManagerFactory("journalappPU");
    }

    public static void close(){
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }

    public static EntityManager getEntityManager() {
        if(emf == null)
            init();
        return emf.createEntityManager();
    }
}
