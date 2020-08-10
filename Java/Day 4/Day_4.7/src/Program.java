import static java.lang.System.out;
//import static java.lang.Math.*;
import static java.lang.Math.PI;
import static java.lang.Math.pow;
class Program
{
    public static void main( String[] args )
    {
        float radius = 10.0f;
        //float area = ( float )( Math.PI * Math.pow(radius, 2) );
        float area = ( float )( PI * pow(radius, 2) );
        out.println("Area    :   "+area);
    }
}