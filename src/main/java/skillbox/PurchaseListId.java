package skillbox;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class PurchaseListId implements Serializable {


    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    public PurchaseListId() { }

    public PurchaseListId(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object instance) {
        if (instance == null)
            return false;

        if (!(instance instanceof PurchaseListId))
            return false;

        final PurchaseListId other = (PurchaseListId) instance;
        if (!(studentName).equals(other.getStudentName()))
            return false;

        if (!(courseName).equals(other.getCourseName()))
            return false;

        return true; }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.studentName != null ? (this.studentName).hashCode() : 0);
        hash = 47 * hash + (this.courseName != null ? (this.courseName).hashCode() : 0);
        return hash;
    }





}
