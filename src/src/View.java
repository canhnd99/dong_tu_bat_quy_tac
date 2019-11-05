package src;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class View extends JFrame {

    public static final int WID = 800;
    public static final int HEI = 600;

    JLabel lbHeader, lbV1, lbV2, lbV3, lbMeaning;
    JTextField txtSearch, txtV1, txtV2, txtV3, txtMeaning;
    JTable table;
    JScrollPane scrollPane;
    JComboBox cbox;

    DataController data;
    Map<String, Word> wordMap;

    public View(String title) throws HeadlessException {
        super(title);

        lbHeader = new JLabel("Irregular Verbs");
        lbHeader.setBounds(320, 15, 200, 20);
        lbHeader.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbHeader);

        /*-------------------------------*/
        txtSearch = new JTextField();
        txtSearch.setBounds(30, 60, 150, 30);
        add(txtSearch);

        /*-------------------------------*/
        lbV1 = new JLabel("Infinitive:");
        lbV1.setBounds(30, 130, 150, 30);
        add(lbV1);

        txtV1 = new JTextField();
        txtV1.setBounds(30, 160, 150, 30);
        add(txtV1);

        /*-------------------------------*/
        lbV2 = new JLabel("Past Simple:");
        lbV2.setBounds(30, 210, 150, 30);
        add(lbV2);

        txtV2 = new JTextField();
        txtV2.setBounds(30, 240, 150, 30);
        add(txtV2);

        /*-------------------------------*/
        lbV3 = new JLabel("Past Participle:");
        lbV3.setBounds(30, 290, 150, 30);
        add(lbV3);

        txtV3 = new JTextField();
        txtV3.setBounds(30, 320, 150, 30);
        add(txtV3);

        /*-------------------------------*/
        lbMeaning = new JLabel("Meaning:");
        lbMeaning.setBounds(30, 370, 150, 30);
        add(lbMeaning);

        txtMeaning = new JTextField();
        txtMeaning.setBounds(30, 400, 150, 30);
        add(txtMeaning);

        /*-------------------------------*/
        String[] cols = {"Infinitive", "Past Simple", "Past Participle", "Meaning"};
        data = new DataController();
        String[][] rows;
        try {
            rows = data.readData();
            table = new JTable(rows, cols);
            scrollPane = new JScrollPane(table);
            scrollPane.setBounds(200, 60, 560, 485);
            add(scrollPane);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

        /*-------------------------------*/
        loadDataToMap();

        /*-------------------------------*/
        txtSearch.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String searchWord = txtSearch.getText();
                    if (wordMap.containsKey(searchWord)) {
                        txtV1.setText(wordMap.get(searchWord).getV1());
                        txtV2.setText(wordMap.get(searchWord).getV2());
                        txtV3.setText(wordMap.get(searchWord).getV3());
                        txtMeaning.setText(wordMap.get(searchWord).getMeaning());
                    } else {
                        JOptionPane.showMessageDialog(null, "Not Found!");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setLayout(null);
        setVisible(true);
        setSize(WID, HEI);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loadDataToMap() {
        wordMap = new HashMap<>();
        try {
            ArrayList<Word> list = data.getListWords();
            for (int i = 0; i < list.size(); i++) {
                String v = list.get(i).getV1();
                String s = "";
                for (int j = 0; j < v.length(); j++) {
                    int c = (int) v.charAt(j);
                    if (c >= 65 && c <= 122) {
                        s += v.charAt(j);
                    }
                }
                wordMap.put(s, list.get(i));
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static void main(String[] args) {
        new View("Dictionary App");
    }
}
