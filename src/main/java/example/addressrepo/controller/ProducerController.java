package example.addressrepo.controller;

import example.addressrepo.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/producer")
public class ProducerController {
    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String message){
        kafkaProducerService.sendMessage(topic, message);
        return "Message sent to Kafka!";
    }
}
