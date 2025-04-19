package model.inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SS")
public class ScholarshipStudent extends Student{

    private double ScholarshipValue;

    public ScholarshipStudent(){

    }

    public ScholarshipStudent(Long registration, String name, double scholarshipValue) {
        super(registration, name);
        ScholarshipValue = scholarshipValue;
    }

    public double getScholarshipValue() {
        return ScholarshipValue;
    }

    public void setScholarshipValue(double scholarshipValue) {
        ScholarshipValue = scholarshipValue;
    }
    
}
