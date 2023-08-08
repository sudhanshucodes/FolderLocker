package Main;

import actions.LoginActions;

import javax.swing.*;
import java.awt.*;

//import static actions.LoginActions.setWorngPasswordMessage;

public class LoginBackground {
    public static  JLabel loginBackground;
    public  static  JLabel LockCloseImage;
    public static  JLabel LoginImage;
    public static  JButton LoginButton;
    public static  JButton CancelButton;
    public  static  JPasswordField PasswordField;
    public  static  JLabel wrongPasswordMessage;
    public  static void  setMainBack(){
        loginBackground=new JLabel();
        loginBackground.setSize(721,390);
        loginBackground.setLocation(0,0);
        loginBackground.setLayout(null);
        //loginBackground.setBackground(Color.YELLOW);
        //loginBackground.setOpaque(true);
        MainApplication.mainWindow.add(loginBackground);
        ImageIcon loginBackgroundIcon =new ImageIcon(MainApplication.class.getResource("/Resources/login.png"));
        loginBackground.setIcon(loginBackgroundIcon);
        setLockcloseImage();
        setMainLoginScreen();
        setLoginButton();
        setCancleButton();
        setpasswordFeild();
        LoginActions.setCancelButtoAction();
        LoginActions.setLoginButtunAction();
        setWorngPasswordMessage();
    }

    public  static  void setLockcloseImage(){
         LockCloseImage=new JLabel();
        //LockCloseImage.setSize(721,390);
        LockCloseImage.setLocation(0,0);
        LockCloseImage.setLayout(null);
        loginBackground.add(LockCloseImage);
        ImageIcon loginBackgroundIcon =new ImageIcon(MainApplication.class.getResource("/Resources/lockclose.png"));
      //  loginBackground.setIcon(loginBackgroundIcon);
        LockCloseImage.setSize(loginBackgroundIcon.getIconWidth(),loginBackgroundIcon.getIconHeight());

         LockCloseImage.setLocation(230,30);
        LockCloseImage.setIcon(loginBackgroundIcon);

    }
    public  static  void setMainLoginScreen(){
        LoginImage=new JLabel();
        //LockCloseImage.setSize(721,390);
        LoginImage.setLocation(0,0);
        LoginImage.setLayout(null);
        loginBackground.add(LoginImage);
        ImageIcon loginBackgroundIcon =new ImageIcon(MainApplication.class.getResource("/Resources/login2.png"));
        //  loginBackground.setIcon(loginBackgroundIcon);
        LoginImage.setSize(loginBackgroundIcon.getIconWidth(),loginBackgroundIcon.getIconHeight());

        LoginImage.setLocation(107,206);
        LoginImage.setIcon(loginBackgroundIcon);

    }
    public  static void  setLoginButton(){
    LoginButton=new JButton("Login");
    LoginButton.setSize(80,20);
    LoginButton.setLocation(260,97);
    LoginImage.add(LoginButton);
    }
    public  static  void setCancleButton(){
        CancelButton=new JButton("Cancel");
        CancelButton.setSize(80,20);
        CancelButton.setLocation(350,97);
        LoginImage.add(CancelButton);
    }
    public static  void setpasswordFeild(){
        PasswordField=new JPasswordField();
        PasswordField.setLocation(50,61);
        PasswordField.setSize(373,28);
        PasswordField.setBackground(new Color(204,204,204,255));
        PasswordField.setFont(new Font("Arial",Font.PLAIN,25));
        LoginImage.add(PasswordField);

    }
    public  static  void setWorngPasswordMessage(){
        wrongPasswordMessage=new JLabel("Wrong Password");
//        wrongPasswordMessage=new JLable
            wrongPasswordMessage.setSize(120,28);
            wrongPasswordMessage.setFont(new Font("Arial",Font.PLAIN,13));
            wrongPasswordMessage.setLocation(53,93);
            wrongPasswordMessage.setForeground(Color.RED);

            LoginImage.add(wrongPasswordMessage);
        wrongPasswordMessage.setVisible((false));
    }
}
