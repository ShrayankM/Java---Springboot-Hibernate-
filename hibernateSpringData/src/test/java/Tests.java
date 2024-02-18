import org.hibernateSpringData.Message;
import org.hibernateSpringData.SpringDataConfiguration;
import org.hibernateSpringData.repositories.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringDataConfiguration.class })
public class Tests
{
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void storeLoadMessage() {
        Message message = new Message();
        message.setText("Hello World from Spring Data JPA");

        messageRepository.save(message);

        List<Message> messageList = (List<Message>) messageRepository.findAll();

        assertAll(
                () -> assertEquals(1, messageList.size()),
                () -> assertEquals("Hello World from Spring Data JPA", messageList.get(messageList.size() - 1).getText())
        );
    }

}
