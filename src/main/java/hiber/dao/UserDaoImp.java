package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User ownerCarByModelSeries(String model, int series) {
        List<User> users = sessionFactory.openSession().createQuery("from User").getResultList();
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getCar().getModel().equals(model) && users.get(i).getCar().getSeries() == series) {
                System.out.println("Метод иштеди");
                user = users.get(i);
            }
        }
        return user;
    }

    @Override
    public User carBySeries(int series) {
        List<User> users = sessionFactory.openSession().createQuery("from User").getResultList();
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getCar().getSeries() == series) {
                System.out.println("-----");
                user = users.get(i);
            }
        }
        return user;
    }

    @Override
    public User carByModel(String model) {
        List<User> users = sessionFactory.openSession().createQuery("from User").getResultList();
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getCar().getModel().equals(model)){
                user = users.get(i);
            }
        }
        return user;
    }
}