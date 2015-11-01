package reflectSerializer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.List;

@XmlRootElement(name="employee")
@XmlType(propOrder = {"firstName","lastName","socialSecurityNumber",
                        "department", "position","hireDate","salary","supervisor","phoneNumbers"})
public class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private String department;
    private String position;
    private Date hireDate;

    private Double salary;
    private Employee supervisor;
    private List<String> phoneNumbers;

    public Employee() {
    }

    public Employee(String firstName, String lastName,
                    String socialSecurityNumber, String department, String position,
                    Date hireDate, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.department = department;
        this.position = position;
        this.hireDate = hireDate;

        this.salary = salary;

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @XmlElement
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getDepartment() {
        return department;
    }

    @XmlElement
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    @XmlElement
    public void setPosition(String position) {
        this.position = position;

    }

    public Date getHireDate() {
        return hireDate;
    }

    @XmlElement
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    @XmlElement
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    @XmlElement
    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public List<String > getPhoneNumbers() {
        return phoneNumbers;

    }
    @XmlElement(name="phoneNumber")
    @XmlElementWrapper
    public void setPhoneNumbers(List<String > phoneNumbers) {
        this.phoneNumbers = phoneNumbers;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", supervisor=" + supervisor +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
