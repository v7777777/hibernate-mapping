package skillbox;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class SubscriptionId implements Serializable {

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "course_id")
    private Integer courseId;

    private SubscriptionId() { }

    public SubscriptionId(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


    @Override
    public boolean equals(Object instance) {
        if (instance == null)
            return false;

        if (!(instance instanceof SubscriptionId))
            return false;

        final SubscriptionId other = (SubscriptionId) instance;
        if (!((Integer)studentId).equals(other.getStudentId()))
            return false;

        if (!((Integer)courseId).equals(other.getCourseId()))
            return false;

        return true; }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + ((Integer)this.studentId != null ? ((Integer)this.studentId).hashCode() : 0);
        hash = 47 * hash + ((Integer)this.courseId != null ? ((Integer)this.courseId).hashCode() : 0);
        return hash;
    }

}


