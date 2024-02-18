import org.hibernateJPA.Message;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    public void storeLoadTests() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateJPA");

        try {
            EntityManager entityManager = emf.createEntityManager();

            // * --- Transaction (1) starts --- * //
            entityManager.getTransaction().begin();

            Message message = new Message();
            message.setText("Hello World");

            entityManager.persist(message);
            entityManager.getTransaction().commit();
            // * --- Transaction (1) ends --- * //

            // * --- Transaction (2) starts --- * //
            entityManager.getTransaction().begin();

            List<Message> messageList = entityManager.createQuery("Select m from Message m", Message.class).getResultList();
            messageList.get(messageList.size() - 1).setText("Hello World from JPA!");

            entityManager.getTransaction().commit();
            // * --- Transaction (2) ends --- * //

            assertAll(
                    () -> assertEquals(1, messageList.size()),
                    () -> assertEquals("Hello World from JPA!", messageList.get(messageList.size() - 1).getText())
            );

        } finally {
            emf.close();
        }
    }
}
