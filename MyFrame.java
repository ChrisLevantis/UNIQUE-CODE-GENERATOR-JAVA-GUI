import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    RandomCode raCode = new RandomCode();

    int numOfLettersInt;
    int numOfCodesInt;

    JPanel row1, row2, row3, row4, row5;

    TextField numOfCodes;
    TextField numOfLetters;
    JButton genButton;

    MyFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,2));
        this.setSize(260,130);
        this.setResizable(false);

        row1 = new JPanel(); // that will go fourth...
        //row1.setBackground(Color.BLACK);
        row2 = new JPanel(); // that will go last...
        //row2.setBackground(Color.RED);
        row3 = new JPanel(); // that will go second...
        //row3.setBackground(Color.GREEN);
        row4 = new JPanel(); // that will go first...
        //row4.setBackground(Color.BLUE);
        row5 = new JPanel(); // that will go third...
        //row5.setBackground(Color.YELLOW);

        numOfCodes = new TextField();
        numOfCodes.setPreferredSize(new Dimension(100,20));
        numOfLetters = new TextField();
        numOfLetters.setPreferredSize(new Dimension(100,20));


        genButton = new JButton("Generate");
        genButton.setFocusable(false);
        genButton.addActionListener(this);

        // Strings
        row4.add(new JLabel("Number of codes"));
        row4.add(new JLabel("Number of letters"));

        row3.add(numOfCodes);
        row3.add(numOfLetters);
        row2.add(genButton);

        this.add(row4);
        this.add(row3);
        this.add(row2);



        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        numOfLettersInt = Integer.valueOf(numOfLetters.getText());
        numOfCodesInt = Integer.valueOf(numOfCodes.getText());
        String FINAL_RESULT = "";

        if(numOfLettersInt < 4) // we want the letters to be >= with 4...
        {
            JOptionPane.showMessageDialog(null, "The number of the letters must be at least 4, Try again");
            return;
        }

        if (e.getSource() == genButton)
        {
            for (int i = 1;i <= numOfCodesInt;i++)
            {
                FINAL_RESULT = FINAL_RESULT + raCode.generateCode(numOfLettersInt) + "   ";
            }

            numOfCodesInt = 0;
            JOptionPane.showMessageDialog(null, FINAL_RESULT);
        }
    }
}
