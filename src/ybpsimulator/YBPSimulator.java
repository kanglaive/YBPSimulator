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
public class YBPSimulator extends javax.swing.JFrame {

    int ssbpack, tsdNum, drNum, ssbNum, drpack, tsdpack, monstersNum, spellsNum, trapsNum, extraNum, tributeNum, monsI, spelI, trapI, extrI, tribI, currentFile = 1;
  boolean yetToExist = true;
  BufferedReader br = null;
  InputStream is = null;
  String currentLine;
  InputStreamReader isr = null;
  private ArrayList<String> database = new ArrayList<String>();
  Random rand = new Random();
  
  
    public YBPSimulator() {
        initComponents();
        monstersNum = readNumLines("monsters.txt");
  spellsNum = readNumLines("spells.txt");
  trapsNum = readNumLines("traps.txt");
  extraNum = readNumLines("extra.txt");
  tributeNum = readNumLines("tribute.txt");
  tsdNum = readNumLines("TheShiningDarkness.txt");
  ssbNum = readNumLines("StarStrikeBlast.txt");
  drNum = readNumLines("DuelistRevolution.txt");
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
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textField6 = new java.awt.TextField();
        textField7 = new java.awt.TextField();
        textField8 = new java.awt.TextField();
        jLabel10 = new javax.swing.JLabel();

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

        textField1.setText("17");
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        textField2.setName(""); // NOI18N
        textField2.setText("4");

        textField3.setText("10");

        textField4.setText("9");

        textField5.setText("15");

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
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sealed Play", jPanel2);

        jButton2.setText("Generate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("StarStrike Blast");

        jLabel8.setText("Duelist Revolution");

        jLabel9.setText("The Shining Darkness");

        textField6.setText("0");

        textField7.setText("0");

        textField8.setText("0");

        jLabel10.setText("Number of Packs (5 cards each)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textField8, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(textField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(106, 106, 106))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(54, 54, 54))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jButton2)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FileWriter fw;
     try {
       ssbpack = Integer.parseInt(textField6.getText());
       drpack = Integer.parseInt(textField7.getText());
       tsdpack = Integer.parseInt(textField8.getText());
     } catch (Exception e) {
     }
     try {
       fw = new FileWriter(new File("rand" + currentFile + ".ydk"));
         fw.write("#created by YBPSimulator");
       fw.write(System.lineSeparator());
       fw.write("#main");
       fw.write(System.lineSeparator());
       importFile(new File("StarStrikeBlast.txt"));
       for (int i =0;i<ssbpack*5;i++)
       {
         fw.write(database.get(chooseCard(ssbNum)));
         fw.write(System.lineSeparator());
       }
       importFile(new File("DuelistRevolution.txt"));
       for (int i =0;i<drpack*5;i++)
       {
         fw.write(database.get(chooseCard(drNum)));
         fw.write(System.lineSeparator());
       }
       importFile(new File("TheShiningDarkness.txt"));
       for (int i =0;i<tsdpack*5;i++)
       {
         fw.write(database.get(chooseCard(tsdNum)));
         fw.write(System.lineSeparator());
       }
       fw.write("#extra");
       fw.write(System.lineSeparator());
       importFile(new File("extra.txt"));
       for (int i =0;i<15;i++)
       {
         fw.write(database.get(chooseCard(extraNum)));
         fw.write(System.lineSeparator());
       }
       fw.close();
       } catch (IOException ex) {
        }
       currentFile++;
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(YBPSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YBPSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YBPSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YBPSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YBPSimulator().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private java.awt.TextField textField6;
    private java.awt.TextField textField7;
    private java.awt.TextField textField8;
    // End of variables declaration//GEN-END:variables
}
