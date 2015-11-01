package hyberExample.persistence;

import hyberExample.entity.User;
import org.hibernate.Session;

public class EnterPoint {

    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User();

   /*     user.setFirstName("Roman");
        user.setLastName("Mayun");

        session.save(user);*/
        User user2 = (User) session.get(User.class, 1);
        System.out.println(user2);
        session.getTransaction().commit();
    }

}