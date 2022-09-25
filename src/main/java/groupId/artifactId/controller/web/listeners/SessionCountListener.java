package groupId.artifactId.controller.web.listeners;

import groupId.artifactId.service.UserService;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import static groupId.artifactId.service.StatisticService.decrSessionCounter;
import static groupId.artifactId.service.StatisticService.incrSessionCounter;

@WebListener
public class SessionCountListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getName().equals("login")) {
            incrSessionCounter();
        }
    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if (event.getName().equals("login")) {
            decrSessionCounter();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        UserService userService = UserService.getInstance();
        userService.validateDestination((String) event.getValue());
    }
}
