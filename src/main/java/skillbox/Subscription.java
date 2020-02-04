package skillbox;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "Subscriptions")
public class Subscription implements Serializable  {

    @EmbeddedId
    private SubscriptionId subscriptionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    private Course course;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    private Student student;

    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;

    private  Subscription () {}

    public Subscription(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.subscriptionId = new SubscriptionId(student.getId(), course.getId());

    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubscriptionId getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(SubscriptionId subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

}
