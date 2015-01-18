/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class YBPSimulator extends JPanel implements ActionListener{
  JButton gen;
  JLabel monsLabel, spelLabel, trapLabel, extrLabel, tribLabel, label;
  JTextField mons, spel, trap, extr, trib;
  ArrayList<JLabel> BPlabels = new ArrayList<JLabel>();
  ArrayList<JTextField> BPtext = new ArrayList<JTextField>();
  
  
  
  int monstersNum, spellsNum, trapsNum, extraNum, tributeNum, monsI, spelI, trapI, extrI, tribI, currentFile = 1;
  boolean yetToExist = true;
  BufferedReader br = null;
  JComboBox play;

  InputStream is = null;
  String currentLine;
  String[] playTypes = {"Battle Play","Booster Packs"};
  List<String> monstersLines, spellsLines, trapsLines, extraLines, tributeLines;
  InputStreamReader isr = null;
  String[] types = {"# of Monsters", "#of Tributes", "# of Spells","# of Traps","# of ExtraDeck"};
  private ArrayList<String> database = new ArrayList<String>();
  Random rand = new Random();
  Path resourcePath;
  
  public YBPSimulator() {
    super(new FlowLayout());
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
    
    JTabbedPane tabbedPane = new JTabbedPane();
    JComponent sp = makeTextPanel("");
      Icon icon = null;
    tabbedPane.addTab("Sealed Play", icon, sp,"");
    JComponent bp = makeTextPanel("");
    tabbedPane.addTab("Booster Packs", icon, bp,"");
    add(tabbedPane);
    
    for (String type : types) {
      label = new JLabel(type);
//      label.setLocation(10,60+Arrays.asList(types).indexOf(type)*25);
//      label.setSize(100,20);
      sp.add(label);
    }
    
    
    mons = new JTextField("17");
//    mons.setLocation(105,60);
//    mons.setSize(30,20);
    sp.add(mons);
    mons.addActionListener(this);
    BPtext.add(mons);
    
    trib = new JTextField("4");
//    trib.setLocation(105,85);
//    trib.setSize(30,20);
    sp.add(trib);
    trib.addActionListener(this);
    BPtext.add(trib);
    
    spel = new JTextField("10");
//    spel.setLocation(105,110);
//    spel.setSize(30,20);
    sp.add(spel);
    spel.addActionListener(this);
    BPtext.add(spel);
    
    trap = new JTextField("9");
//    trap.setLocation(105,135);
//    trap.setSize(30,20);
    sp.add(trap);
    trap.addActionListener(this);
    BPtext.add(trap);
    
    extr = new JTextField("15");
//    extr.setLocation(105,160);
//    extr.setSize(30,20);
    sp.add(extr);
    extr.addActionListener(this);
    BPtext.add(extr);
    
    gen = new JButton("Generate");
//    gen.setLocation(75, 305);
//    gen.setSize(100, 30);
    sp.add(gen);
    gen.addActionListener(this);
    
  }
  
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
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
  
  @Override
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == gen)
    {
      generate();
    }
   }
   
   public void showBattlePlay() {
       removeAll();
       for (String type : types) {
        label = new JLabel(type);
        label.setLocation(10,60+Arrays.asList(types).indexOf(type)*25);
//        label.setSize(100,20);
        add(label);
        }
       for (JTextField text: BPtext) {
           add(text);
       }
       GUImain();
   }
   
   public void showBoosterPack() {
       removeAll();
       
       GUImain();
   }
   
   public void GUImain() {
       add(gen);
       add(play);
       validate();
       repaint();
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
       monsI = Integer.parseInt(mons.getText());
       spelI = Integer.parseInt(spel.getText());
       trapI = Integer.parseInt(trap.getText());
       tribI = Integer.parseInt(trib.getText());
       extrI = Integer.parseInt(extr.getText());
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
   
   
  private static void createAndShowGUI() {
    
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Yugioh Battle Pack Simulator");
    
//    JComponent yBPSimulator = new YBPSimulator();
//    yBPSimulator.setOpaque(true);
//    frame.setContentPane(yBPSimulator);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setSize(300, 400);
    frame.pack();
    frame.setMinimumSize(new Dimension(350, 250));
    frame.setLocation(650,400);
    frame.setVisible(true);
//    frame.setLocationRelativeTo(null);
    frame.add(new YBPSimulator());
  }
  
 public static void main(String[] args) {
   
    SwingUtilities.invokeLater(() -> {
        createAndShowGUI();
    });
  }
 
// public static void main(String[] args) {
//   
//    SwingUtilities.invokeLater(new Runnable() {
//      @Override
//      public void run() {
//        createAndShowGUI();
//      }
//    });
//  }
}