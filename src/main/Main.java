package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener {

  private static final long serialVersionUID = 1L;

  JFileChooser fc;
  JButton buttonScan;
  JButton buttonGen;

  // metodo costruttore
  public Main() {

    // imposta layout finestra
    this.getContentPane().setLayout(new FlowLayout());

    buttonScan = new JButton("Scegli codice QR da scannerizzare");
    buttonGen = new JButton("Digita testo da codificare in codice QR");

    // aggiung i bottoni che mi servono
    add(buttonScan);
    add(buttonGen);

    // aggiunge l'ascolto dell'azione
    buttonScan.addActionListener(this);
    buttonGen.addActionListener(this);

    fc = new JFileChooser();
  }

  public void actionPerformed(ActionEvent ae) {

    // indico cosa succede se premo il bottone per generare il codice
    if (ae.getSource() == buttonGen) {
      TextField.mainTextField();
      TextField textField = new TextField();
      String txt = TextField.txt;
      textField.actionPerformed(ae);
      System.out.println("stampo txt preso da TextField: " + txt);
    } else {
      System.out.println("file");
    }

    // indico cosa succede se premo il bottone per scannerizzare
    if (ae.getSource() == buttonScan) {
      int returnVal = fc.showOpenDialog(Main.this);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        try {
          String decodedText = Reader.decodeQRCode(file);
          System.out.println(decodedText);
        } catch (IOException e) {
          // blocco per gestire l'eccezione
          e.printStackTrace();
          System.out.println("arrivo 2 ");
        }
      }
    }
  }

  private static void createAndShowGUI() {

    // crea la finestra

    JFrame frame = new Main();

    // mostra la finestra

    frame.pack();

    frame.setVisible(true);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public static void main(String[] args) {

    javax.swing.SwingUtilities.invokeLater(new Runnable() {

      public void run() {

        createAndShowGUI();

      }

    });
  }

}
