package java;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Verifier extends JFrame
                 implements ActionListener
{

 JLabel l1 = new JLabel("Public Key: "),
        l2 = new JLabel("x value: "),
        l3 = new JLabel("Bit Value: "),
        l4 = new JLabel("Share: "),
        l5 = new JLabel("Verification x: ");

 JTextField t1 = new JTextField(""),
            t2 = new JTextField(""),
            t3 = new JTextField(""),
            t4 = new JTextField("");

 JRadioButton r1 = new JRadioButton("1"),
              r2 = new JRadioButton("0");

 JButton    b1 = new JButton("Read"),
            b2 = new JButton("Read"),
            b3 = new JButton("Send"),
            b4 = new JButton("Read and Verify"),
            b5 = new JButton("Close");

 ButtonGroup bg = new ButtonGroup();

 public Verifier()
 {
   setLayout(null);
   setTitle("Verifier");
   bg.add(r1);
   bg.add(r2);

   add(l1,10,10,100,20);
   add(t1,115,10,100,20);
   add(b1,215,10,150,20);

   add(l2,10,35,100,20);
   add(t2,115,35,100,20);
   add(b2,215,35,150,20);

   add(l3,10,70,100,20);
   add(r1,115,70,40,20);
   add(r2,155,70,40,20);
   add(b3,215,70,150,20);

   add(l4,10,105,100,20);
   add(t3,115,105,100,20);
   add(b4,215,105,150,20);

   add(l5,10,140,100,20);
   add(t4,115,140,100,20);
   add(b5,215,140,150,20);

   t1.setEditable(false);
   t2.setEditable(false);
   t3.setEditable(false);
   t4.setEditable(false);

   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   b5.addActionListener(this);

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
     t1.setText(String.valueOf(AlgoLib.pubk));
  else if(e.getSource()==b2)
     t2.setText(String.valueOf(AlgoLib.x));
  else if(e.getSource()==b3)
  {
   if(r1.isSelected())
   {
     AlgoLib.bit = 1;
     l3.setText("y value");
   }
   else
   {
     AlgoLib.bit = 0;
     l3.setText("r value");
   }
   JOptionPane.showMessageDialog(this,AlgoLib.bit + " sent","Info", JOptionPane.INFORMATION_MESSAGE);
  }   
  else if(e.getSource()==b4)
  {
       double x;
       t2.setText(String.valueOf((int)AlgoLib.share));
       if( r1.isSelected())
           x = ((AlgoLib.share * AlgoLib.share) * AlgoLib.pubk) % AlgoLib.n;
       else
           x = (AlgoLib.share * AlgoLib.share) % AlgoLib.n;
       x = Math.ceil(x);
       t3.setText(String.valueOf(x));

       if( AlgoLib.x == x )
          JOptionPane.showMessageDialog(this,"The Prover is Authenticated","Info", JOptionPane.INFORMATION_MESSAGE);
       else
          JOptionPane.showMessageDialog(this,"The Prover is Denied","Info", JOptionPane.ERROR_MESSAGE);
  }
  else
   dispose();
 }

 public static void main(String ...a)
 {
  new Verifier();
 }
}
