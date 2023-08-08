package Main.util;

import Main.model.LockedListModel;
import Main.model.PasswordModel;
import Main.model.RecentListModel;

import java.io.*;
import java.util.BitSet;
import java.util.List;


public class FileOperations {
    public  static String hideFileCommand = "attrib +R +A +S +H +O +I +X +P +U ";
    public  static String unhideCommand="attrib -R -A -S -H -O -I -X -P -U ";
    public  static  String getPasswordFromFile(){

        try {
            File passDir=new File("C:/ProjectedFolderApp");
            if(passDir.exists()) {
                File passFile=new File("C:/ProjectedFolderApp/password.log");
                ObjectInputStream inStream=new ObjectInputStream(new FileInputStream(passFile));
                PasswordModel passwordModel=(PasswordModel) inStream.readObject();
                return  passwordModel.getPassword();
            }
            else{

                passDir.mkdir();
                File passFile=new File("C:/ProjectedFolderApp/password.log");
                passFile.createNewFile();
                PasswordModel passwordModel=new PasswordModel("abc");
                ObjectOutputStream outStream=new ObjectOutputStream(new FileOutputStream(passFile));
                outStream.writeObject(passwordModel);
                return  passwordModel.getPassword();
            }
           // return  null;

        }catch (Exception e ){
        e.printStackTrace();

        }
        return  null;

    }


    public  static  void saveLockedListData(List<String>locedlist){
        ObjectOutputStream outStream =null;
        try {
            File lockedFile = new File("C:/ProjectedFolderApp1/lockedFiles.log");
            if (lockedFile.exists()) {
                LockedListModel lockedListModel = new LockedListModel(locedlist);
                outStream = new ObjectOutputStream(new FileOutputStream(lockedFile));
                outStream.writeObject(lockedListModel);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            if(outStream!=null){
                try {
                    outStream.close();
                }catch ( Exception e){
                    e.printStackTrace();
                }
            }

        }

    }
    public  static  void saveRecentListData(List<String>locedlist){
        ObjectOutputStream outStream =null;
        try {
            File recentFile= new File("C:/ProjectedFolderApp/recentFiles.log");
            if (recentFile.exists()) {
                RecentListModel recentListModel = new RecentListModel(locedlist);
                outStream = new ObjectOutputStream(new FileOutputStream(recentFile));
                outStream.writeObject(recentListModel);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            if(outStream!=null){
                try {
                    outStream.close();
                }catch ( Exception e){
                    e.printStackTrace();
                }
            }

        }

    }
    public  static  LockedListModel getLockedListData(){
        ObjectOutputStream outStream =null;
        ObjectInputStream inStream=null;
        try {
          File passDir=new File("C:/ProjectedFolderApp1");
          File lockedFile = new File("C:/ProjectedFolderApp1/lockedFiles.log");
        //    File lockedFile = new File(passDir.getParentFile(), "lockedFiles.log");
            if (!lockedFile.exists()) {
                passDir.mkdir();
                lockedFile.createNewFile();
                LockedListModel lockedListModel = new LockedListModel();
                outStream = new ObjectOutputStream(new FileOutputStream(lockedFile));
                outStream.writeObject(lockedListModel);
                return lockedListModel;
            } else {
                inStream = new ObjectInputStream(new FileInputStream(lockedFile));
                LockedListModel lockedListModel = (LockedListModel) inStream.readObject();
                return lockedListModel;
            }
        }

        catch(Exception e){
            e.printStackTrace();
        }finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return  null;
    }

    public  static RecentListModel getRecentListData(){
        ObjectOutputStream outStream =null;
        ObjectInputStream inStream=null;
        try {
            File recentFile = new File("C:/ProjectedFolderApp/recentFiles.log");
            if (!recentFile.exists()) {
                recentFile.createNewFile();
                RecentListModel recentListModel = new RecentListModel();
                outStream = new ObjectOutputStream(new FileOutputStream(recentFile));
                outStream.writeObject(recentListModel);
                return recentListModel;
            } else {
                inStream = new ObjectInputStream(new FileInputStream(recentFile));
                RecentListModel recentListModel = (RecentListModel) inStream.readObject();
                return recentListModel;
            }
        }

        catch(Exception e){
            e.printStackTrace();
        }finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return  null;
    }

    public  static Boolean hideFileFromSystem(String filePath){
        String newFilePath=hideFileCommand+"\""+filePath+"\"";
        try {
            Runtime.getRuntime().exec(newFilePath);
            return true;
        } catch (IOException e) {
          e.printStackTrace();
        }
        return false;

    }
    public  static Boolean unhideFileFromSystem(String filePath){
        String newFilePath=unhideCommand+"\""+filePath+"\"";
        try {
            Runtime.getRuntime().exec(newFilePath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

}
