package Main.dialogPanels;

import Main.actions.FileExplorerThread;
import Main.actions.FilePanelDialogactions;
import Main.util.FileExplorer;
import Main.util.RecentDataList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FilePanelDialog {
     public   JDialog filePanelDialog;
     public JLabel recentFilePanel;
    public JLabel lockListP;
    public  JLabel recentPanelHeading;
    public JLabel lockListPanel;
    public  JLabel fileExplorerPanel;
    public DefaultTableModel recentTableModel;

    public JTable recentTable;
    public  DefaultTableModel lockListTableModel;

    public   JTable lockListTable;

     public JButton addButton;
     public JButton removeButton;
    public JButton okButton;
    public JButton cancelButton;

    public FilePanelDialog()
    {
        filePanelDialog=new JDialog();
        filePanelDialog.setTitle("Add File");
        filePanelDialog.setSize(720,435);

        Dimension dm= Toolkit.getDefaultToolkit().getScreenSize();
        int x=dm.width/2-filePanelDialog.getWidth()/2;
        int y= dm.height/2-filePanelDialog.getHeight()/2;
        filePanelDialog.setLocation(x,y);
        filePanelDialog.setAlwaysOnTop(true);
        filePanelDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        filePanelDialog.setResizable(false);
        filePanelDialog.setLayout(null);

        setRecentPanelHeading();
        setResetFilePanel();
        setRecentTable();
        populateRecentTable();
        setLockListPanelPanel();
        setLockListP();
        setLockListTable();
     //   populateLockListTable();
        setAddButton();
        FilePanelDialogactions.setAddButtonAction(this);
        setRemoveButton();
        FilePanelDialogactions.setRemoveButtonAction(this);
        setOkButton();
        FilePanelDialogactions.setOkButtonAction(this);
        setCancelButton();
        FilePanelDialogactions.setCancelButtonAction(this);
        setFileExplorerPanel();

         setFileSystem();
        filePanelDialog.setVisible(true);


    }
    public  void setResetFilePanel(){
        recentFilePanel=new JLabel();
        recentFilePanel.setSize(250,100);
        recentFilePanel.setLocation(10,40);
        recentFilePanel.setBackground(new Color(250,255,255,255));
        recentFilePanel.setOpaque(true);
        recentFilePanel.setLayout(null);
        recentFilePanel.setBorder(new LineBorder(new Color(10,10,10),1));
        filePanelDialog.add(recentFilePanel);
    }
    public  void setRecentTable(){
        recentTableModel = new DefaultTableModel();
        recentTableModel.addColumn("Recent Path");
      //  tableModel.addColumn("Status");
        recentTable = new JTable(recentTableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane sc = new JScrollPane(recentTable);
        sc.setSize(244, 94);
        sc.setLocation(3, 3);
        recentFilePanel.add(sc);
        recentTable.setBackground(new Color(233, 239, 236, 255));

        //recentTable.getColumnModel().getColumn(0).setPreferredWidth(480);
        recentTable.setRowHeight(20);
        recentTable.getTableHeader().setBackground(new Color(250,255,255,255));
        recentTable.getTableHeader().setReorderingAllowed(false);
        recentTable.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
        recentTable.setShowVerticalLines(false);
        //  table.setRowSelectionAllowed(true);
        recentTable.setFocusable(false);
        sc.setViewportBorder(new LineBorder(new Color(200,200,200,200),1));
        //table.setSelectionBackground(new Color(87,255,152,115));
     //   recentTable.setSelectionBackground(Color.gray);

        //recentTableModel.addRow(new Object[]{"a.txt"});
    }
    public void populateRecentTable(){
        for(String fileString:RecentDataList.getRecentFiles()){
            recentTableModel.addRow(new Object[]{fileString});
        }
    }
    public   void setRecentPanelHeading(){
        recentPanelHeading =new JLabel("Recent Unlocked File");
        filePanelDialog.add(recentPanelHeading);
        recentPanelHeading.setSize(200,30);
        recentPanelHeading.setLocation(10,10);


    }
    public   void setLockListPanelPanel(){
        lockListPanel =new JLabel("Lock File Path");
        filePanelDialog.add(lockListPanel);
        lockListPanel.setSize(200,30);
        lockListPanel.setLocation(420,10);



    }
    public  void setLockListP(){
        lockListP=new JLabel();
        lockListP.setSize(283,310);
        lockListP.setLocation(410,40);
        lockListP.setBackground(new Color(250,255,255,255));
        lockListP.setOpaque(true);
        lockListP.setLayout(null);
        lockListP.setBorder(new LineBorder(new Color(10,10,10),1));
        filePanelDialog.add(lockListP);
    }
    public  void setLockListTable(){
        lockListTableModel = new DefaultTableModel();
        lockListTableModel.addColumn("Lock Files");
        //  tableModel.addColumn("Status");
        lockListTable = new JTable(lockListTableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane sc = new JScrollPane(lockListTable);
        sc.setSize(277, 304);
        sc.setLocation(3, 3);
        sc.getViewport().setBackground(new Color(250,255,255,255));
        lockListP.add(sc);
        lockListTable.setBackground(new Color(250, 255, 255, 255));

        //recentTable.getColumnModel().getColumn(0).setPreferredWidth(480);
        lockListTable.setRowHeight(30);
        lockListTable.getTableHeader().setBackground(new Color(250,255,255,255));
        lockListTable.getTableHeader().setReorderingAllowed(false);
        lockListTable.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
        lockListTable.setShowVerticalLines(false);
        //  table.setRowSelectionAllowed(true);
        lockListTable.setFocusable(false);
        sc.setViewportBorder(new LineBorder(new Color(200,200,200,200),1));
        //table.setSelectionBackground(new Color(87,255,152,115));
        //   recentTable.setSelectionBackground(Color.gray);



    }
    public  void setAddButton(){
        addButton=new JButton("Add ->");
        addButton.setSize(100,35);
        addButton.setLocation(290,180);
        addButton.setBackground(new Color(250,255,255,255));
        addButton.setFocusable(false);
        filePanelDialog.add(addButton);


    }
    public  void setRemoveButton(){
        removeButton=new JButton("Remove <-");
        removeButton.setSize(100,35);
        removeButton.setLocation(290,230);
        removeButton.setBackground(new Color(250,255,255,255));
        removeButton.setFocusable(false);
        filePanelDialog.add(removeButton);


    }
    public  void setOkButton(){
        okButton=new JButton("OK");
        okButton.setSize(100,35);
        okButton.setLocation(495,360);
        okButton.setBackground(new Color(250,255,255,255));
        okButton.setFocusable(false);
        filePanelDialog.add(okButton);


    }
    public  void setCancelButton(){
        cancelButton=new JButton("Cancel");
        cancelButton.setSize(100,35);
        cancelButton.setLocation(600,360);
        cancelButton.setBackground(new Color(250,255,255,255));
        cancelButton.setFocusable(false);
        filePanelDialog.add(cancelButton);


    }
    public  void setFileExplorerPanel(){
        fileExplorerPanel=new JLabel();
        fileExplorerPanel.setSize(250,200);
        fileExplorerPanel.setLocation(10,150);
        fileExplorerPanel.setBackground(new Color(250,255,255,255));
        fileExplorerPanel.setOpaque(true);
        fileExplorerPanel.setLayout(null);
        fileExplorerPanel.setBorder(new LineBorder(new Color(10,10,10),1));
        filePanelDialog.add(fileExplorerPanel);

    }
    public  void setFileSystem(){
        FileExplorerThread flt=new FileExplorerThread(this);
        flt.start();

    }
}
