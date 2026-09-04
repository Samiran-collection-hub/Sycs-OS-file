import javax.swing.*;

public class test1 {
    JFrame frame;
    test1(){
        frame=new JFrame("first way");
        JButton button=new JButton("let's see");
        button.setBounds(200, 150, 90, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,600);
    }
    public static void main(String[] args) {
        new test1();
    }
}
