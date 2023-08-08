package Main;

import Main.actions.MainPageActions;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainPage {
    public static JLabel mainGround;
    public static JLabel topGround;
    public static JLabel leftTopGroundImage;
    public static JLabel midGroundSupporter;
    public static JLabel midGround;
    public static DefaultTableModel tableModel;

    public static JLabel bottomGround;
    public static JButton registerButton;
    public static JButton addButton, addInnerButton;
    public static JButton unlockButton;
    public static JButton lockexitButton;

    public static JTable table;

    public static void setMainPage() {
        mainGround = new JLabel();
        mainGround.setSize(713, 390);
        mainGround.setBackground(Color.cyan);
        mainGround.setOpaque(true);
        mainGround.setLayout(null);
        mainGround.setVisible(false);
        MainApplication.mainWindow.add(mainGround);
        setTopGround();
        setLeftTopGroundImage();
        setMidGroundSupporter();
        setmidGround();
        setTable();
        setBottomGround();
        setRegisterButton();
        setAddInnerButton();
        setAddButton();
        setUnlockButton();
        setlockexitButton();

        MainPageActions.setAddButtonActions();
        MainPageActions.setUnlockButtonAction();
        MainPageActions.setlockexitButtonAction();
    }

    public static void setTopGround() {
        topGround = new JLabel();
        topGround.setLayout(null);
        topGround.setLocation(0, 0);
        topGround.setSize(713, 40);
        topGround.setBackground(Color.darkGray);
        topGround.setOpaque(true);
        mainGround.add(topGround);
    }

    public static void setLeftTopGroundImage() {
        ImageIcon leftTopGroundImageIcon = new ImageIcon(MainApplication.class.getResource("/Resources/lockopen.png"));

        leftTopGroundImage = new JLabel();
        leftTopGroundImage.setLocation(10, 4);
        leftTopGroundImage.setSize(leftTopGroundImageIcon.getIconWidth(), leftTopGroundImageIcon.getIconHeight());
        leftTopGroundImage.setIcon(leftTopGroundImageIcon);
        topGround.add(leftTopGroundImage);
    }

    public static void setMidGroundSupporter() {
        midGroundSupporter = new JLabel();
        midGroundSupporter.setLocation(0, 40);
        midGroundSupporter.setSize(713, 350);
        midGroundSupporter.setLayout(null);
        midGroundSupporter.setBackground(new Color(233, 239, 236, 255));
        midGroundSupporter.setOpaque(true);
        midGroundSupporter.setBorder(new LineBorder(new Color(10, 10, 10), 2));
        mainGround.add(midGroundSupporter);
    }

    public static void setmidGround() {
        midGround = new JLabel();
        midGround.setLocation(3, 3);
        midGround.setSize(707, 284);
        midGround.setLayout(null);
        midGround.setBackground(Color.WHITE);
        midGround.setOpaque(true);
        //midGroundSupporter.setBorder(new LineBorder(new Color(10,10,10),2));
        midGroundSupporter.add(midGround);

    }

    public static void setTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Path");
        tableModel.addColumn("Status");
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane sc = new JScrollPane(table);
        sc.setSize(702, 278);
        sc.setLocation(3, 3);
        sc.getViewport().setBackground(new Color(233,239,236,255));
        midGround.add(sc);
        table.setBackground(new Color(233, 239, 236, 255));

        table.getColumnModel().getColumn(0).setPreferredWidth(480);
        table.setRowHeight(38);
        table.getTableHeader().setBackground(Color.LIGHT_GRAY);
        table.getTableHeader().setReorderingAllowed(false);
        table.setShowVerticalLines(false);
        //  table.setRowSelectionAllowed(true);
        table.setFocusable(false);
        //table.setSelectionBackground(new Color(87,255,152,115));
        table.setSelectionBackground(Color.gray);

    }

    public static void setBottomGround() {
        bottomGround = new JLabel();
        bottomGround.setLocation(3, 287);
        bottomGround.setSize(707, 60);
        bottomGround.setLayout(null);
        bottomGround.setBackground(Color.GRAY);
        bottomGround.setOpaque(true);
        //midGroundSupporter.setBorder(new LineBorder(new Color(10,10,10),2));
        midGroundSupporter.add(bottomGround);

    }

    public static void setRegisterButton() {
        registerButton = new JButton("Register");
        registerButton.setSize(100, 30);
        registerButton.setLocation(10, 17);
        //registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(63, 187, 73, 255));
        registerButton.setFont(new Font("Arial", Font.BOLD, 12));
        registerButton.setFocusable(false);
        bottomGround.add(registerButton);


    }

    public static void setAddButton() {
        addButton = new JButton();
        addButton.setSize(105, 32);
        addButton.setLocation(300, 15);
        addButton.setFocusable(false);
        ImageIcon addIcon = new ImageIcon(MainApplication.class.getResource("/Resources/ADD.png"));
        addButton.setIcon(addIcon);
        addButton.setContentAreaFilled(false);
        bottomGround.add(addButton);
    }

    public static void setUnlockButton() {
        unlockButton = new JButton();
        unlockButton.setSize(105, 32);
        unlockButton.setLocation(410, 15);
        unlockButton.setFocusable(false);
        ImageIcon unlockIcon = new ImageIcon(MainApplication.class.getResource("/Resources/unlockImage.png"));
        unlockButton.setIcon(unlockIcon);
        unlockButton.setContentAreaFilled(false);
        bottomGround.add(unlockButton);
    }

    public static void setlockexitButton() {
        lockexitButton = new JButton();
        lockexitButton.setSize(105, 32);
        lockexitButton.setLocation(580, 15);
        lockexitButton.setFocusable(false);
        ImageIcon lockexitIcon = new ImageIcon(MainApplication.class.getResource("/Resources/lockexit.png"));
        lockexitButton.setIcon(lockexitIcon);
        lockexitButton.setContentAreaFilled(false);
        bottomGround.add(lockexitButton);

    }

    public static void setAddInnerButton() {
        addInnerButton = new JButton();
        addInnerButton.setSize(50, 30);
        addInnerButton.setLocation(350, 17);
        addInnerButton.setFocusable(false);
        ImageIcon innerIcon = new ImageIcon(MainApplication.class.getResource("/Resources/combo.png"));
        addInnerButton.setIcon(innerIcon);
        addInnerButton.setContentAreaFilled(false);
        bottomGround.add(addInnerButton);
    }
}
