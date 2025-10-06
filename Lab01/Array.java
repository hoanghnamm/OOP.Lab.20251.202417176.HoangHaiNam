import java.util.*;

public class Array
{
    void sort(int[] a,int n)
    {
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(a[i]>a[j])
                {
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
    }
    public static void main(String[] agrs)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] num = new int[n];
        int sum=0;
        for(int i =0; i<n;i++)
        {
            System.out.print("a[" +i+"]=");
            num[i]=sc.nextInt();
            sum+=num[i];
        }
        double avg =(double)sum/n;
        Array arr = new Array();
        arr.sort(num,n);
        System.out.println("Sorted array:");
        for(int i=0;i<n;i++)
        {
            System.out.println(num[i]);
        }
        System.out.println("Sum = "+sum);
        System.out.println("Average = "+avg);
        sc.close();
        
    }

}