import javax.swing.JOptionPane;
public class Cal 
{
    public static void main(String[] args)
    {
        String stra,strb;
        double a,b;
        stra = JOptionPane.showInputDialog(null,"Please input the first number:","Input the first number",JOptionPane.INFORMATION_MESSAGE);
        strb = JOptionPane.showInputDialog(null,"Please input the second number:","Input the second number",JOptionPane.INFORMATION_MESSAGE);
        a = Double.parseDouble(stra);       
        b = Double.parseDouble(strb);

        double sum = a+b;
        double sub = a-b;
        double mul = a*b;
        if(b!= 0)
        {
            double div = a/b;
            String strNotification = "The result of addition is: " + sum + "\n" +
                                     "The result of subtraction is: " + sub + "\n" +
                                     "The result of multiplication is: " + mul + "\n" +
                                     "The result of division is: " + div;
            JOptionPane.showMessageDialog(null,strNotification,"Calculation Results",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        else
        {
            String strNotification = "The result of addition is: " + sum + "\n" +
                                     "The result of subtraction is: " + sub + "\n" +
                                     "The result of multiplication is: " + mul + "\n" +
                                     "Division by zero is undefined.";
            JOptionPane.showMessageDialog(null,strNotification,"Calculation Results",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

    }
}