import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import skillbox.*;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        System.out.println("Test Course");

        Course course = session.get(Course.class, 3);

        System.out.println(course.getTeacher().getName() + " " + course.getName() + " " + course.getDescription() + " " + course.getType());

        System.out.println("через Student");

        course.getStudents().forEach(s -> System.out.println(s.getName() + " " + s.getAge()));

        System.out.println("через Subscription");

        course.getSubscriptions().forEach(s-> System.out.println(s.getStudent().getName() + " " + s.getCourse().getName()  + " " + s.getSubscriptionDate()));

        System.out.println("Test Student");

        Student student = session.get(Student.class, 6);

        System.out.println("через Course");

        student.getCourses().forEach(s -> System.out.println(s.getName() + " " + s.getDescription() + " " + s.getTeacher().getName()));

        System.out.println(student.getName() + " " + student.getAge() + " " + student.getId());

        System.out.println("через Subscription");

        student.getSubscriptions().forEach(s-> System.out.println(s.getStudent().getName() + " " + s.getCourse().getName()  + " " + s.getSubscriptionDate()));

        System.out.println("Test Teacher");

        Teacher teacher = session.get(Teacher.class, 10);

        System.out.println(teacher.getName() + " " + teacher.getAge() + " " + teacher.getId() + " " + teacher.getSalary());

        teacher.getCourses().forEach(c -> System.out.println(c.getName()));

        System.out.println("Test Subscription");

        SubscriptionId subscriptionId = new SubscriptionId (2, 11);

        Subscription subscription =  session.get(Subscription.class, subscriptionId);

        System.out.println(subscription.getCourse().getName() + " " + subscription.getStudent().getName() + " " + subscription.getSubscriptionDate());

        System.out.println(subscription.getSubscriptionId().getStudentId() + " " + subscription.getSubscriptionId().getCourseId() + " " + subscription.getSubscriptionDate());

        System.out.println("Test PurchaseList");

        PurchaseListId purchaseListId = new PurchaseListId("Квасников Емельян", "Рекламная графика");
        PurchaseList purchaseList = session.get(PurchaseList.class, purchaseListId);

        System.out.println(purchaseListId.getCourseName() + " " +  purchaseList.getPrice()  + " " +  purchaseList.getSubscriptionDate());



        sessionFactory.close();

    }
}
