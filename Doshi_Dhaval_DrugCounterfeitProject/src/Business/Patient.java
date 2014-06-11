/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Dhaval
 */
public class Patient extends Person
{
    private String idNo;
    private String doctorName;
    private String dateOfLastVisit;
    private String nextAppointment;
    private String allergies;
    private String currentlyOnMedication;

    public String getIdNo() {
        return idNo;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDateOfLastVisit() {
        return dateOfLastVisit;
    }

    public String getNextAppointment() {
        return nextAppointment;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getCurrentlyOnMedication() {
        return currentlyOnMedication;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDateOfLastVisit(String dateOfLastVisit) {
        this.dateOfLastVisit = dateOfLastVisit;
    }

    public void setNextAppointment(String nextAppointment) {
        this.nextAppointment = nextAppointment;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setCurrentlyOnMedication(String currentlyOnMedication) {
        this.currentlyOnMedication = currentlyOnMedication;
    }




}
