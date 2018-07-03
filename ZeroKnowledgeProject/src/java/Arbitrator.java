package java;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Arbitrator extends JFrame
                 implements ActionListener
{

 JLabel l1 = new JLabel("Enter p value: "),
        l2 = new JLabel("Enter q value: "),
        l3 = new JLabel("n-value: "),
        l4 = new JLabel("x-value: "),
        l5 = new JLabel("public key: "),
        l6 = new JLabel("private key: ");

 JTextField t1 = new JTextField(""),
            t2 = new JTextField(""),
            t3 = new JTextField(""),
            t4 = new JTextField(""),
            t5 = new JTextField(""),
            t6 = new JTextField("");

 JButton    b1 = new JButton("Generate n"),
            b2 = new JButton("Pass To Prover"),
            b3 = new JButton("Read"),
            b4 = new JButton("Generate"),
            b5 = new JButton("Generate"),
            b6 = new JButton("Pass Public Key To Verifier and Prover"),
            b7 = new JButton("Pass Private Key To Prover"),
            b8 = new JButton("Close");

 public Arbitrator()
 {
   setLayout(null);
   setTitle("Arbitrator");
   add(l1,10,10,100,20);
   add(t1,115,10,100,20);
   add(l2,10,35,100,20);
   add(t2,115,35,100,20);
   add(b1,215,35,150,20);
   add(l3,10,70,100,20);
   add(t3,115,70,100,20);
   add(b2,215,70,150,20);
   add(l4,10,105,100,20);
   add(t4,115,105,100,20);
   add(b3,215,105,150,20);
   add(l5,10,140,100,20);
   add(t5,115,140,100,20);
   add(b4,215,140,150,20);
   add(l6,10,175,100,20);
   add(t6,115,175,100,20);
   add(b5,215,175,150,20);
   add(b6,150,210,250,20);
   add(b7,150,245,250,20);
   add(b8,215,280,150,20);

   t3.setEditable(false);
   t4.setEditable(false);
   t5.setEditable(false);
   t6.setEditable(false);

   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   b5.addActionListener(this);
   b6.addActionListener(this);
   b7.addActionListener(this);
   b8.addActionListener(this);

   setBounds(20,20,400,400);
   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   setVisible(true);
 }

 public void add(JComponent c,int x,int y,int w,int h)
 {
  c.setBounds(x,y,w,h);
  add(c);
 }

 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource()==b1)
    t3.setText(String.valueOf(Integer.parseInt(t1.getText())*Integer.parseInt(t2.getText())));
  else if(e.getSource()==b2)
  {
        AlgoLib.n = Integer.parseInt(t3.getText());
        JOptionPane.showMessageDialog(this,"n value passed","Info", JOptionPane.INFORMATION_MESSAGE);
  }
  else if(e.getSource()==b3)
     t4.setText(String.valueOf((int)AlgoLib.x));
  else if(e.getSource()==b4)
     t5.setText(String.valueOf((int)(AlgoLib.x*AlgoLib.x % AlgoLib.n)));
  else if(e.getSource()==b5)
   try
   {
     t6.setText(String.valueOf(Math.sqrt(1 / (AlgoLib.x*AlgoLib.x % AlgoLib.n)) % AlgoLib.n));
   }
   catch(Exception ep)
   {
     System.out.println(ep);
   }
  else if(e.getSource()==b6)
  {
        AlgoLib.pubk = Integer.parseInt(t5.getText());
        JOptionPane.showMessageDialog(this,"Key passed to verifier","Info", JOptionPane.INFORMATION_MESSAGE);
  }
  else if(e.getSource()==b7)
  {                              
      AlgoLib.prvk = Double.parseDouble(t6.getText());
      JOptionPane.showMessageDialog(this,"Key passed to verifier","Info", JOptionPane.INFORMATION_MESSAGE);
  }
  else
   dispose();
 }

 public static void main(String ...a)
 {
  new Arbitrator();
 }
}
