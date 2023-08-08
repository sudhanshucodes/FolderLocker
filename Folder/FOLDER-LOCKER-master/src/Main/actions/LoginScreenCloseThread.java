package Main.actions;

import Main.LoginBackground;
import Main.MainPage;

public class LoginScreenCloseThread extends  Thread{
    public  void run(){
        MainPage.mainGround.setVisible(false);
        for (int i = 715; i >=1; i--) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LoginBackground.loginBackground.setLocation(i,0);
        }
        System.exit(0);

    }
}
