import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class calculator extends JFrame implements ActionListener {
    // create a frame
    static JFrame fm;

    // create a text-field
    static JTextField lb;

    //store operator and operands
    String s0, s1, s2;

    //default constructor
    calculator()
    {
        s0 = s1 = s2 = "";
    }
    //main function
    public static void main(String args[]) {
       //create a frame
        fm = new JFrame("calculator");
        try{
            //set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        //create an object of class
        calculator c = new calculator();

         //create a text-field
         lb =new JTextField(16);

         //set the text-field to non-editable
        lb.setEditable(false);
        //create number buttons and some operators
        JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bs,bd,bm,be,beq,beq1;

        //create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        //equals button
        beq1 =new JButton("=");

        //create operator buttons
        ba =new JButton("+");
        bd =new JButton("/");
        bm =new JButton("*");
        bs =new JButton("-");
        beq =new JButton("C");

        //create a button
        be = new JButton(".");

        //create a panel
        JPanel pl = new JPanel();

        //add action listeners
        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);

        //add elements to panel
        pl.add(lb);
        pl.add(ba);
        pl.add(b1);
        pl.add(b2);
        pl.add(b3);
        pl.add(bs);
        pl.add(b4);
        pl.add(b5);
        pl.add(b6);
        pl.add(bm);
        pl.add(b7);
        pl.add(b8);
        pl.add(b9);
        pl.add(bd);
        pl.add(be);
        pl.add(b0);
        pl.add(beq);
        pl.add(beq1);

        //set background of panel
        pl.setBackground(Color.BLUE);

        //add panel to frame
        fm.add(pl);

        fm.setSize(200,220);
        fm.show();
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        //if the value is a number

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) =='.'){
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 =s0 + s;
            //set the value of text
            lb.setText(s0 + s1 + s2);
        }

        else if (s.charAt(0) == '='){
            double te;

            //store the value in 1st

            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te=(Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("*"))
                te=(Double.parseDouble(s0) * Double.parseDouble(s2));
            else
                te=(Double.parseDouble(s0) / Double.parseDouble(s2));

            //set the value of text
            lb.setText(s0 + s1 + s2 + " = " + te);

            //convert it to string
            s0 = Double.toString(te);
            s1 = s2 = "";
        }
        else {
            //if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            //else evaluate
            else{
                double te;

                //store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = Double.parseDouble(s0) + Double.parseDouble(s2);
                else if (s1.equals("/"))
                    te = Double.parseDouble(s0) / Double.parseDouble(s2);
                else
                    te = Double.parseDouble(s0) * Double.parseDouble(s2);

                //convert it to string
                s0 =Double.toString(te);

                //place the operator
                s1 =s;

                //make operand blank
                s2 = "";
            }
            //set the value of text
            lb.setText(s0 + s1 + s2);
        }
    }
    }
