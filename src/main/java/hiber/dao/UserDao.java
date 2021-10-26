package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User ownerCarByModelSeries(String model, int series);
   User carBySeries(int series);
   User carByModel(String model);


}
