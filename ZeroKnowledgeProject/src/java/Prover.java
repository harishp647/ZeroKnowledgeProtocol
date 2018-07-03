package java;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prover extends JFrame
                 implements ActionListener
{

 JLabel l1 = new JLabel("n value: "),
        l2 = new JLabel("Random r: "),
        l3 = new JLabel("gcd: "),
        l4 = new JLabel("x-value: "),
        l5 = new JLabel("public key: "),
        l6 = new JLabel("private key: "),
        l7 = new JLabel("Bit Value: "),
        l8 = new JLabel("v key: ");

 JTextField t1 = new JTextField(""),
            t2 = new JTextField(""),
            t3 = new JTextField(""),
            t4 = new JTextField(""),
            t5 = new JTextField(""),
            t6 = new JTextField(""),
            t7 = new JTextField(""),
            t8 = new JTextField("");

 JButton    b1 = new JButton("Read"),
            b2 = new JButton("Generate r"),
            b3 = new JButton("Compute"),
            b4 = new JButton("Compute"),
            b5 = new JButton("Pass x to Arbitrator and Verifier"),
            b6 = new JButton("Read"),
            b7 = new JButton("Read"),
            b8 = new JButton("Read"),
            b9 = new JButton("Send To Verifier"),
            b10 = new JButton("Close");

 public Prover()
 {
   setLayout(null);
   setTitle("Prover");
   add(l1,10,10,100,20);
   add(t1,115,10,100,20);
   add(b1,215,10,150,20);
   add(l2,10,35,100,20);
   add(t2,115,35,100,20);
   add(b2,215,35,150,20);
   add(l3,10,70,100,20);
   add(t3,115,70,100,20);
   add(b3,215,70,150,20);
   add(l4,10,105,100,20);
   add(t4,115,105,100,20);
   add(b4,215,105,150,20);

   add(b5,115,140,250,20);

   add(l5,10,175,100,20);
   add(t5,115,175,100,20);
   add(b6,215,175,150,20);

   add(l6,10,210,100,20);
   add(t6,115,210,100,20);
   add(b7,215,210,150,20);

   add(l7,10,245,100,20);
   add(t7,115,245,100,20);
   add(b8,215,245,150,20);

   add(l8,10,280,100,20);
   add(t8,115,280,100,20);
   add(b9,215,280,150,20);
   add(b10,215,315,150,20);

   t1.setEditable(false);
   t2.setEditable(false);
   t3.setEditable(false);
   t4.setEditable(false);
   t5.setEditable(false);
   t6.setEditable(false);
   t7.setEditable(false);
   t8.setEditable(false);

   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   b5.addActionListener(this);
   b6.addActionListener(this);
   b7.addActionListener(this);
   b8.addActionListener(this);
   b9.addActionListener(this);
   b10.addActionListener(this);

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
    t1.setText(String.valueOf((int)AlgoLib.n));
  else if(e.getSource()==b2)
  {
     java.util.Random r = new java.util.Random();
     t2.setText(String.valueOf(r.nextInt(100)));
  }
  else if(e.getSource()==b3)
   try
   {
     t3.setText(String.valueOf(AlgoLib.GCD(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()))));
   }
   catch(Exception ex)
   {
     System.out.println(ex);
   }
  else if(e.getSource()==b4)
  {
       double r, n, x ;
       r = Integer.parseInt(t2.getText());
       n = Integer.parseInt(t1.getText());
       x = (r * r) % n;
       t4.setText(String.valueOf((int)x));
  }
  else if(e.getSource()==b5)
  {
      AlgoLib.x = Integer.parseInt(t4.getText());
      JOptionPane.showMessageDialog(this,"x value passed","Info", JOptionPane.INFORMATION_MESSAGE);
  }
  else if(e.getSource()==b6)
      t5.setText(String.valueOf(AlgoLib.pubk));
  else if(e.getSource()==b7)
      t6.setText(String.valueOf(AlgoLib.prvk));
  else if(e.getSource()==b8)
  {
    t7.setText(String.valueOf((int)AlgoLib.bit));
    if(AlgoLib.bit == 0 )
    {
      l8.setText("r value");
      t8.setText(t2.getText());
    }
    else
    {
      double y ;
      l8.setText("y value");
      y = (Integer.parseInt(t2.getText()) * AlgoLib.prvk) % AlgoLib.n;
      t8.setText(String.valueOf((int)y));
    }
  }
  else if(e.getSource()==b9)
  {
       AlgoLib.share = Double.parseDouble(t6.getText());
       JOptionPane.showMessageDialog(this,l6.getText() + "=" + AlgoLib.share + " is sent","Info", JOptionPane.INFORMATION_MESSAGE);
  }
  else
   dispose();
 }

 public static void main(String ...a)
 {
  new Prover();
 }
}
