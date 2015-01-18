package ybpsimulator;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Random;
import java.util.List;
import javax.swing.*;
//import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
//import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
//import java.nio.charset.Charset;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
/**
 *
 * @author Taiga Vo
 */
public class YBPFrame extends javax.swing.JFrame {

    int monstersNum, spellsNum, trapsNum, extraNum, tributeNum, monsI, spelI, trapI, extrI, tribI, currentFile = 1;
  boolean yetToExist = true;
  BufferedReader br = null;
  InputStream is = null;
  String currentLine;
  InputStreamReader isr = null;
  private ArrayList<String> database = new ArrayList<String>();
  Random rand = new Random();
  
  
    public YBPFrame() {
        initComponents();
        monstersNum = readNumLines("monsters.txt");
  spellsNum = readNumLines("spells.txt");
  trapsNum = readNumLines("traps.txt");
  extraNum = readNumLines("extra.txt");
  tributeNum = readNumLines("tribute.txt");
  
    while (yetToExist)
  {
    File check = new File("rand" + currentFile + ".ydk");
    if (!check.exists()) {
      yetToExist = false;
    }
    else {
      currentFile += 1;
    }
    
    }
    }
    
  
  public int readNumLines(String file) {
      String line;
      int x = 0;
      try {
      is = getClass().getResourceAsStream("/resources/" + file);
      isr = new InputStreamReader(is);
      br = new BufferedReader(isr);
      while ((line = br.readLine()) != null) {
          x++;
      }
      
      br.close();
      isr.close();
      is.close();
      } catch (Exception e) {
          
      }
      
      return x;
  }
  
  public int chooseCard(int x) {
    int pick = rand.nextInt(x);
    return pick;
  }
  
   
   public void importFile(File filename) {
       try {
           is = getClass().getResourceAsStream("/resources/" + filename);
           isr = new InputStreamReader(is);
           br = new BufferedReader(isr);
       } catch (Exception e) {
           
       }
       
     database.clear();
    try {
//      br = new BufferedReader(new FileReader(filename));
      currentLine = br.readLine();
      database.add(currentLine);
      while ((currentLine = br.readLine()) != null) {
        database.add(currentLine);
      }
      isr.close();
      is.close();
    } catch (IOException e) {
        
    } finally {
      try {
        if (br != null)br.close();
      } catch (IOException ex) {
        
      }
    }
   }
   
   public void generate() {
     FileWriter fw;
     try {
       monsI = Integer.parseInt(textField1.getText());
       spelI = Integer.parseInt(textField2.getText());
       trapI = Integer.parseInt(textField3.getText());
       tribI = Integer.parseInt(textField4.getText());
       extrI = Integer.parseInt(textField5.getText());
     } catch (Exception e) {
     }
     try {
       fw = new FileWriter(new File("rand" + currentFile + ".ydk"));
         fw.write("#created by YBPSimulator");
       fw.write(System.lineSeparator());
       fw.write("#main");
       fw.write(System.lineSeparator());
       importFile(new File("monsters.txt"));
       for (int i =0;i<monsI;i++)
       {
         fw.write(database.get(chooseCard(monstersNum)));
         fw.write(System.lineSeparator());
       }
       importFile(new File("tribute.txt"));
       for (int i =0;i<tribI;i++)
       {
         fw.write(database.get(chooseCard(tributeNum)));
         fw.write(System.lineSeparator());
       }
       importFile(new File("spells.txt"));
       for (int i =0;i<spelI;i++)
       {
         fw.write(database.get(chooseCard(spellsNum)));
         fw.write(System.lineSeparator());
       }
       importFile(new File("traps.txt"));
       for (int i =0;i<trapI;i++)
       {
         fw.write(database.get(chooseCard(trapsNum)));
         fw.write(System.lineSeparator());
       }
       fw.write("#extra");
       fw.write(System.lineSeparator());
       importFile(new File("extra.txt"));
       for (int i =0;i<extrI;i++)
       {
         fw.write(database.get(chooseCard(extraNum)));
         fw.write(System.lineSeparator());
       }
       fw.close();
       } catch (IOException ex) {
        }
       currentFile++;
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textField1 = new java.awt.TextField();
        textField2 = new java.awt.TextField();
        textField3 = new java.awt.TextField();
        textField4 = new java.awt.TextField();
        textField5 = new java.awt.TextField();
        jPanel3 = new javax.swing.JPanel();
        StarStrikeBlast = new java.awt.Checkbox();
        checkbox2 = new java.awt.Checkbox();
        checkbox3 = new java.awt.Checkbox();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab1", jPanel1);

        jLabel1.setText("jLabel1");
        jTabbedPane3.addTab("tab1", jLabel1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Monsters");

        jLabel3.setText("Spells");

        jLabel4.setText("Traps");

        jLabel5.setText("Tributes");

        jLabel6.setText("ExtraDeck");

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textField1.setText("textField1");
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        textField2.setText("textField2");

        textField3.setText("textField3");

        textField4.setText("textField4");

        textField5.setText("textField5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                                .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jButton1)))
                .addGap(109, 109, 109))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sealed Play", jPanel2);

        StarStrikeBlast.setLabel("checkbox1");

        checkbox2.setLabel("checkbox2");

        checkbox3.setLabel("checkbox3");

        jButton2.setText("Generate");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StarStrikeBlast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(checkbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(checkbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StarStrikeBlast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Booster Pack", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       FileWriter fw;
     try {
       monsI = Integer.parseInt(textField1.getText());
       spelI = Integer.parseInt(textField2.getText());
       trapI = Integer.parseInt(textField3.getText());
       tribI = Integer.parseInt(textField4.getText());
       extrI = Integer.parseInt(textField5.getText());
     } catch (Exception e) {
     }
     try {
       fw = new FileWriter(new File("rand" + currentFile + ".ydk"));
         fw.write("#created by YBPSimulator");
       fw.write(System.lineSeparator());
       fw.write("#main");
       fw.write(System.lineSeparator());
       importFile(new File("monsters.txt"));
       for (int i =0;i<monsI;i++)
       {
         fw.write(database.get(chooseCard(monstersNum)));
         fw.write(System.lineSeparator());
       }
       importFile(new File("tribute.txt"));
       for (int i =0;i<tribI;i++)
       {
         fw.write(database.get(chooseCard(tributeNum)));
         fw.write(System.lineSeparator());
       }
       importFile(new File("spells.txt"));
       for (int i =0;i<spelI;i++)
       {
         fw.write(database.get(chooseCard(spellsNum)));
         fw.write(System.lineSeparator());
       }
       importFile(new File("traps.txt"));
       for (int i =0;i<trapI;i++)
       {
         fw.write(database.get(chooseCard(trapsNum)));
         fw.write(System.lineSeparator());
       }
       fw.write("#extra");
       fw.write(System.lineSeparator());
       importFile(new File("extra.txt"));
       for (int i =0;i<extrI;i++)
       {
         fw.write(database.get(chooseCard(extraNum)));
         fw.write(System.lineSeparator());
       }
       fw.close();
       } catch (IOException ex) {
        }
       currentFile++;
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(YBPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YBPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YBPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YBPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YBPFrame().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox StarStrikeBlast;
    private java.awt.Checkbox checkbox2;
    private java.awt.Checkbox checkbox3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    private java.awt.TextField textField5;
    // End of variables declaration//GEN-END:variables
}
