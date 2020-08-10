import java.util.Scanner;

class Program
{
    public static void main(String[] args) 
    {
        Scanner  sc = new Scanner(System.in);
        System.out.print("Name  :   ");
        String name = sc.nextLine();
        System.out.print("Empid :   ");
        int empid = sc.nextInt();
        System.out.print("Salary    :   ");
        float salary = sc.nextFloat();
        System.out.printf("%-15s%-5d%-8.2f\n",name, empid, salary);
    }
}