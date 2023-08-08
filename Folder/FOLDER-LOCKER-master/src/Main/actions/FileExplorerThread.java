package Main.actions;

import Main.dialogPanels.FilePanelDialog;
import Main.util.FileExplorer;

import javax.swing.*;

public class FileExplorerThread extends Thread {
    public FilePanelDialog filePanelDialog;
    public FileExplorerThread(FilePanelDialog filePanelDialog){
        this.filePanelDialog= filePanelDialog;
    }

    public void run(){
        setFileSystem();
}
    public  void setFileSystem(){
        JScrollPane fc= FileExplorer.getFileExplorerScrollPanel();
        filePanelDialog.fileExplorerPanel.add(fc);
        fc.setSize(250,200);
        fc.setLocation(0,0);
        filePanelDialog.fileExplorerPanel.validate();

    }
}
