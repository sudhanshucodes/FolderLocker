package Main.actions;

import Main.MainPage;
import Main.dialogPanels.FilePanelDialog;
import Main.util.Arrayman;
import Main.util.FileOperations;
import Main.util.LocedFileDataList;
import Main.util.RecentDataList;
import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainPageActions {
    public  static void setAddButtonActions(){
        MainPage.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FilePanelDialog();
            }
        });
    }
    public static  void setUnlockButtonAction(){
        MainPage.unlockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rows= MainPage.table.getSelectedRows();
                Arrayman.reverseArray(rows);
                List<String> datalist=new ArrayList<>();
                for (int row:rows){
                   String value=(String) MainPage.table.getValueAt(row,0);
                  if(FileOperations.unhideFileFromSystem(value)){
                   datalist.add(value);
                   MainPage.tableModel.removeRow(row);}
                }
                RecentDataList.appendRecentFiles(datalist);
                LocedFileDataList.removeLockedFiles(datalist);

            }
        });
    }
    public  static  void setlockexitButtonAction(){
        MainPage.lockexitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginScreenCloseThread lct =new LoginScreenCloseThread();
                lct.sleep();
            }
        });
    }

}
