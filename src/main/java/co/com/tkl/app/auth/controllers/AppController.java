package co.com.tkl.app.auth.controllers;

import co.com.tkl.app.auth.entities.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class AppController {

    @GetMapping("list")
    public List<Message> list() {
        return Collections.singletonList(new Message("Test list"));
    }

    @PostMapping("/create")
    public Message create(@RequestBody Message message) {
        log.info("Message created: {}", message.getText());
        return message;
    }

    @GetMapping("/authorized")
    public Map<String, String> authorized(@RequestParam(name = "code") String code) {
        log.info("Code: {}", code);
        return Collections.singletonMap("code", code);
    }
}
