package queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.TextMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Queue_Consumer {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "activeMQQueue")
    private Queue queue;

    @Test
    public void receiveMessage() throws Exception {
        TextMessage receiveMessage = (TextMessage) jmsTemplate.receive(queue);
        String text = receiveMessage.getText();
        System.out.println("Queue_Consumer has received the message :" + text + " from producer");

    }
}
