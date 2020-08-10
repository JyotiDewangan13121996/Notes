class Program
{
    public static void main(String[] args) 
    {
        int num1 = Integer.parseInt( args[ 0 ] ) ;
        float num2 = Float.parseFloat( args[ 1 ] );
        double num3 = Double.parseDouble( args[ 2 ] );
        double result = num1 + num2 + num3;
        System.out.println("Result  :   "+result);
    }
}