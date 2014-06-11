/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class UserAccountDirectory {
    ArrayList<UserAccount> uList;

    public UserAccountDirectory() {
        uList = new ArrayList<>();
    }
    public UserAccount newUserAccount()
    {
        UserAccount u = new UserAccount();
        uList.add(u);
        return u;
    }

    public ArrayList<UserAccount> getuList() {
        return uList;
    }

    public UserAccount authenticate(String userName, String password)
    {
        for(UserAccount p : uList)
        {
            if(userName.equalsIgnoreCase(p.getUserName())&& password.equalsIgnoreCase(p.getPassword()))
            {
                    return p;
            }
        }

        return null;
    }

     public UserAccount search(UserAccount user)
    {
        for(UserAccount p : uList)
        {
            if(p == user)
            {
                    return p;
            }
        }
        return null;
    }


}
