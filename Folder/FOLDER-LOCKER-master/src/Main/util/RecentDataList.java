package Main.util;

import Main.MainPage;
import Main.model.LockedListModel;
import Main.model.RecentListModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecentDataList {
    private   static List<String>recentFiles=new ArrayList<>();
    public  static  List<String>getRecentFiles(){
        return recentFiles;
    }
    public  static  void populateRecentFiles(){

        RecentListModel recentListModel=FileOperations.getRecentListData();
        if(recentListModel==null ||recentListModel.getRecentlist()==null || recentListModel.getRecentlist().size()==0)
        {
            return;
        }
        recentFiles.addAll(recentListModel.getRecentlist());

    }
    public  static  void appendRecentFiles(List<String> files){
        if(files.size()==0){
            return;
        }
        recentFiles.addAll(files);
        FileOperations.saveRecentListData(recentFiles);
    }
}
