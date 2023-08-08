package Main.util;

import Main.MainPage;
import Main.model.LockedListModel;

import java.util.ArrayList;
import java.util.List;

public class LocedFileDataList {
    public static List<String> lockedfiles=new ArrayList<>();
    public  static  void appendLockedFiles(List<String> files){
    if(files.size()==0){
        return;
    }
    lockedfiles.addAll(files);
    FileOperations.saveLockedListData(lockedfiles);
    }
    public  static  void populatelockedFileData(){
        LockedListModel lockedListModel=FileOperations.getLockedListData();
        if(lockedListModel==null ||lockedListModel.getLockedList()==null || lockedListModel.getLockedList().size()==0)
        {
            return;
        }
        lockedfiles.addAll(lockedListModel.getLockedList());
        for (String data:lockedfiles) {
            MainPage.tableModel.addRow(new  Object[]{data,"Active"});
        }
    }
    public  static  void removeLockedFiles(List<String> files){
        if(files.size()==0){
            return;
        }
        lockedfiles.removeAll(files);
        FileOperations.saveLockedListData(lockedfiles);
    }

    }


