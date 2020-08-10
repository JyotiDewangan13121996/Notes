import java.util.Scanner;

class Complex
{
    private int real;
    private int imag;
    public int getReal() 
    {
        return this.real;
    }
    public void setReal(int real) 
    {
        this.real = real;
    }
    public int getImag() 
    {
        return this.imag;
    }
    public void setImag(int imag) 
    {
        this.imag = imag;
    }
    public void acceptRecord( )
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter real number :   ");
        this.real = sc.nextInt();
        System.out.print("Enter imag number :   ");
        this.imag = sc.nextInt();
    }
    public void printRecord( )
    {
        System.out.println("Real Number :   "+this.real);
        System.out.println("Imag Number :   "+this.imag);
    }
}
class Program
{
   public static void main(String[] args) 
   {
       Complex c1 = new Complex( );
      c1.acceptRecord( );
      c1.printRecord( );
   }
}