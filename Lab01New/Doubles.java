import java.util.*;
public class Doubles
{
    public static void main(String[] agrs)
    {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter 1st number: ");
    double a = sc.nextDouble();
    System.out.println("Enter 2nd number:");
    double b = sc.nextDouble();
    double sum = a+b;
    double sub = a-b;
    double mul =a*b;
    System.out.println("Sum = "+sum);
    System.out.println("Subtraction = "+sub);
    System.out.println("Multiplication = "+mul);
    double div = a/b;
    if(div == Double.POSITIVE_INFINITY || div == Double.NEGATIVE_INFINITY)
        System.out.println("Division : Cannot divide zero !");
    else
    System.out.println("Division = "+div);
    
    sc.close();
    }
}