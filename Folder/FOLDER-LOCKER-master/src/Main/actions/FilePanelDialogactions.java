package Main.actions;

import Main.MainPage;
import Main.dialogPanels.FilePanelDialog;
import Main.util.Arrayman;
import Main.util.FileExplorer;
import Main.util.FileOperations;
import Main.util.LocedFileDataList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FilePanelDialogactions {
    public  static  void setAddButtonAction(FilePanelDialog dialogObject){
        dialogObject.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //get selected Files from recent List
                int[] selectedrows=  dialogObject.recentTable.getSelectedRows();
                for ( int rowNum: selectedrows) {
                   String rowval =(String) dialogObject.recentTable.getValueAt(rowNum,0);
                   //
                    if(!isRowExist(rowval,dialogObject)){
                        dialogObject.lockListTableModel.addRow(new Object[]{rowval});
                    }
                }
                //get Seleceted Fr om file Exp
                String  filePath= FileExplorer.getSelectedFile();
                if(!isRowExist(filePath,dialogObject)){
                    dialogObject.lockListTableModel.addRow(new Object[]{filePath});
                }
            }
        });

    }
    public  static boolean isRowExist(String rowValue,FilePanelDialog dialogObject){
     Vector<Vector>data=dialogObject.lockListTableModel.getDataVector();
     for(Vector vactorValue:data){
        if( vactorValue.get(0).equals(rowValue)){
            return true;
        }
     }
     return  false;
    }
    public  static  void setRemoveButtonAction(FilePanelDialog dialogObject){
        dialogObject.removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int[] rows= dialogObject.lockListTable.getSelectedRows();
              Arrayman.reverseArray(rows);
                for (int row:rows){
                   dialogObject.lockListTableModel.removeRow(row);
                }
            }
        });
    }
    public  static  void setCancelButtonAction(FilePanelDialog dialogObject){
     dialogObject.cancelButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             dialogObject.filePanelDialog.dispose();
         }
     });
    }
    public  static  void  setOkButtonAction(FilePanelDialog dialogObject){
        dialogObject.okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Vector<Vector> data= dialogObject.lockListTableModel.getDataVector();
                List<String>files=new ArrayList<>();
                for (Vector d:data) {
                    System.out.println(d.get(0));
                    String  value=d.get(0).toString();
                    if(FileOperations.hideFileFromSystem(value)) {
                        MainPage.tableModel.addRow(new Object[]{value, "Active"});
                        files.add(value);
                    }
                    }
                LocedFileDataList.appendLockedFiles(files);
                dialogObject.filePanelDialog.dispose();
            }
        });

    }

}
