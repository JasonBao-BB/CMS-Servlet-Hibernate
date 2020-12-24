package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAConnection {
    public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("mySQL");

    public static EntityManager getConnect(){
        return FACTORY.createEntityManager();
    }

    //Test
    public static void main(String[] args) {

        EntityManager manager = JPAConnection.getConnect();

        System.out.println(manager);

    }

}
