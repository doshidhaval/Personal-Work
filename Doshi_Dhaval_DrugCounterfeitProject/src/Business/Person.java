/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author Dhaval
 */
public class Person {

    private String fName;
    private String lName;
    private int age;
    private String emailID;
    private int contactNumber;
    private Address address;
    private String id;
    private int ssn;
    private String nationality;
    private String qualification;
    private Date dob;

    @Override
    public String toString() {
        return (fName+" "+lName);
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getNationality() 
    {
        return nationality;
    }

    public void setNationality(String nationality) 
    {
        this.nationality = nationality;
    }

    public String getQualification() 
    {
        return qualification;
    }

    public void setQualification(String qualification) 
    {
        this.qualification = qualification;
    }

    public Date getDob() 
    {
        return dob;
    }

    public void setDob(Date dob) 
    {
        this.dob = dob;
    }
    
    

    public Person()
    {
        address = new Address();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
