package Main.model;

import java.io.Serializable;

public class PasswordModel implements Serializable {
    String password;
    private  static  final long serialVersionUID= 1L;

    public PasswordModel(String password) {
        this.password = password;
    }
    public  PasswordModel(){

    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
