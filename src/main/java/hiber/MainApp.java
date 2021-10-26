package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

     userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW", 1996)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Toyota",2020)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Kia",1999)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Mersedes",2012)));
      userService.add(new User("Alina", "Kanybekova", "alina@hmail.com", new Car("Honda",2018)));



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car "+user.getCar());
      }

      System.out.println("-------------------------------------");

      System.out.println(userService.ownerCarByModelSeries("Kia", 1999));
       System.out.println(userService.carByModel("Toyota"));
       System.out.println(userService.carBySeries(2018));



      context.close();
   }
}
