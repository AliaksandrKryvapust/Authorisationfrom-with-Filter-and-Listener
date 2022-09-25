package groupId.artifactId.controller.web.listeners;

import groupId.artifactId.core.dto.UserDto;
import groupId.artifactId.service.UserService;
import groupId.artifactId.service.api.IUserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDate;

public class DefaultDataInitializer implements ServletContextListener {
    IUserService userService = UserService.getInstance();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    userService.saveAdmin(new UserDto("Admin","Spark","admin", LocalDate.EPOCH));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
