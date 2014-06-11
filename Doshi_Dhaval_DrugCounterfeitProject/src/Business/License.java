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
public class License {
    private boolean isLicensed;
    private Date issueDate;
    private Date expiryDate;

    public boolean isLicensed() {
        return isLicensed;
    }

    public void setLicense(boolean license) {
        this.isLicensed = license;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }


}
