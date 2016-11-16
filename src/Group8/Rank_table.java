/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author myComputer
 */
public class Rank_table extends javax.swing.JFrame {

    private UserInfo p1,p2;
    /**
     * Creates new form Rank_table
     */
    private  List<UserInfo> user_List = new ArrayList<>();
    
    public class PlayerInfo
    {
    public int score;
    public String name;
    
        public PlayerInfo(String name, int score)
        {
            this.name = name;
            this.score = score;
        }
    }
    
    
    public Rank_table() {
        initComponents();
    }
    
    public Rank_table(UserInfo userinfo1, UserInfo userinfo2) {
        this.p1 = userinfo1;
        this.p2 = userinfo2;
        initComponents();
    }
    
    public ArrayList TopTen()
    {
    ArrayList<PlayerInfo> list = new ArrayList<PlayerInfo>();
    for(int i =0; i<user_List.size(); i++)
        {
            PlayerInfo player = new PlayerInfo(user_List.get(i).getUsername(), user_List.get(i).getScore());
            list.add(player);
        }
    
    return list;
    }
    public void addRowtoJtable()
    {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    ArrayList<PlayerInfo> list = TopTen();
    Object rowData[]=new Object[2];
    for(int i =0; i<list.size();i++)
    {
    rowData[0]=list.get(i).name;
    rowData[1]=list.get(i).score;
    model.addRow(rowData);
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Count Move"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Return");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setText("LeaderBoard");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        MenuGUI s = new MenuGUI(p1,p2);
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rank_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rank_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rank_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rank_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rank_table().setVisible(true);
            }
        });
    }
    
    //all functions here
    public void FileReader()
    {
    		String fileName = "Rank.data";
		List<String> list = new ArrayList<>();
               
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);
                for(int i=0; i<list.size();i++)
                {
                String[] details = (list.get(i)).split(",");
                String username=details[0];
                int score = Integer.parseInt(details[1]);
                UserInfo player = new UserInfo();
                player.setUsername(username);
                player.setScore(score);
                user_List.add(player);
                }
                
                Sort_list(user_List, user_List.size());

                
    
    }
    
    public void Sort_list(List<UserInfo> user_List, int count)
    {
    int i,j;
    UserInfo temp = new UserInfo();
         for(i=0; i<count; i++)
    {
        for(j=0; j<(count-i - 1); j++)
        {
            if(user_List.get(j).getScore() > user_List.get(j+1).getScore())
             {
                 temp.setUsername(user_List.get(j).getUsername());
                 temp.setScore(user_List.get(j).getScore());
                 user_List.get(j).setUsername(user_List.get(j+1).getUsername());
                 user_List.get(j).setScore(user_List.get(j+1).getScore());
                 user_List.get(j+1).setUsername(temp.getUsername());
                 user_List.get(j+1).setScore(temp.getScore());
             }

        }
    }
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
