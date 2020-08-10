class Complex
{
    private int real;
    private int imag;
    public Complex( )
    {
        this( 10, 20 ); //Constructor Chaining
    }
    public Complex( int real, int imag )
    {
        this.real = real;
        this.imag = imag;
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
        Complex c1 = new Complex( 10, 20 );
   }
}