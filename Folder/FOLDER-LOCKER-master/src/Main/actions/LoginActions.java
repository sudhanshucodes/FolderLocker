package actions;

import Main.LoginBackground;
import Main.actions.LoginScreenOpenThread;
import Main.util.FileOperations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActions {
    public static  void  setCancelButtoAction(){
        LoginBackground.CancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public  static  void setLoginButtunAction(){
      LoginBackground.LoginButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              char[] pass=LoginBackground.PasswordField.getPassword();
              String password=String.valueOf(pass);
              System.out.println(FileOperations.getPasswordFromFile());
              if(password.equals(FileOperations.getPasswordFromFile())){
               //   System.out.println(pass);
                  LoginBackground.wrongPasswordMessage.setVisible(false);
                scrollLoginScreen();
              }
              else{

                //  JOptionPane.showMessageDialog(this, "Wrong Password");
           //       System.out.println("false");
              LoginBackground.wrongPasswordMessage.setVisible(true);

              }
          }
      });
    }
    public  static  void scrollLoginScreen(){
        LoginScreenOpenThread lg=new LoginScreenOpenThread();
        lg.start();
    }
}
