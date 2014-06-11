/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Dhaval
 */
public class Address {
    private String line1;
    private String line2;
    private int zip;
    private String state;

     public String getLine1 ()
    {
        return line1;
    }
      public String getLine2 ()
    {
        return line2;
    }
       
       public String getState ()
    {
        return state;
    }
    public void setLine1 (String line1)
    {
           this.line1=line1;
    }

    public void setLine2 (String line2)
    {
           this.line2=line2;
    }

    public int getZip() 
    {
        return zip;
    }

    public void setZip(int zip) 
    {
        this.zip = zip;
    }
    
    public void setState (String state)
    {
           this.state = state;
    }

}
