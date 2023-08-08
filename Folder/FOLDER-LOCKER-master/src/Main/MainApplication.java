package Main;

import Main.dialogPanels.FilePanelDialog;
import Main.util.LocedFileDataList;
import Main.util.RecentDataList;

import javax.swing.*;
import java.awt.*;

public class MainApplication {
    public static JFrame mainWindow;

    public static  void  main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      //  System.out.println("Hello");
        mainWindow =new JFrame("LoCK THE FOLDER");
        mainWindow.setSize(720,422);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
       Dimension dm= Toolkit.getDefaultToolkit().getScreenSize();

        int x=dm.width/2-mainWindow.getWidth()/2;
        int y= dm.height/2-mainWindow.getHeight()/2;
        mainWindow.setLocation(x,y);
        mainWindow.setLayout(null);
        //Set Login Background;
        LoginBackground.setMainBack();

        //set Main PageMaino
        MainPage.setMainPage();

        //Populate Recent File Data
        RecentDataList.populateRecentFiles();

        //new FilePanelDialog();
        //populate lOcked Files data main page
        LocedFileDataList.populatelockedFileData();
        mainWindow.setVisible(true);
    }

}
