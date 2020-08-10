class Program
{
    public static void main(String[] args) 
    {
        String name = "Amit Pol";
        int empid = 1536;
        float salary = 35000.45f;
        System.out.printf("%-15s%-5d%-10.2f\n",name,empid,salary);
        
        name = "Prashant Lad";
        empid = 4;
        salary = 135000.45f;
        System.out.printf("%-15s%-5d%-10.2f\n",name,empid,salary);
    }
}