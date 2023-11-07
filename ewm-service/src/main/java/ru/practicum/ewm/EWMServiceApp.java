package ru.practicum.ewm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.practicum.ewm.category.controller.CategoryAdminController;
import ru.practicum.ewm.category.controller.CategoryPublicController;
import ru.practicum.ewm.compilation.controller.CompilationAdminController;
import ru.practicum.ewm.compilation.controller.CompilationPublicController;
import ru.practicum.ewm.event.controller.EventAdminController;
import ru.practicum.ewm.event.controller.EventPrivateController;
import ru.practicum.ewm.event.controller.EventPublicController;
import ru.practicum.ewm.request.controller.RequestPrivateController;
import ru.practicum.ewm.user.controller.UserAdminController;

@SpringBootApplication
@ComponentScan(basePackageClasses = CategoryAdminController.class)
@ComponentScan(basePackageClasses = CategoryPublicController.class)
@ComponentScan(basePackageClasses = CompilationAdminController.class)
@ComponentScan(basePackageClasses = CompilationPublicController.class)
@ComponentScan(basePackageClasses = EventAdminController.class)
@ComponentScan(basePackageClasses = EventPrivateController.class)
@ComponentScan(basePackageClasses = EventPublicController.class)
@ComponentScan(basePackageClasses = RequestPrivateController.class)
@ComponentScan(basePackageClasses = UserAdminController.class)
public class EWMServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(EWMServiceApp.class, args);
    }

}
