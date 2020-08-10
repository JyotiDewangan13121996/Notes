class Employee
{
    private String name;
    private int empid;
    private String department;
    private String designation;
    private float salary;
    public Employee( )
    {
        this("",0,"","",0);
    }
    public Employee( String name, int empid, String department, String designation, float salary )
    {
        this.name = name;
        this.empid = empid;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }
    public void printRecord( )
    {
        System.out.println("Name    :   "+this.name);
        System.out.println("Empid   :   "+this.empid);
        System.out.println("Department  :   "+this.department);
        System.out.println("Designation :   "+this.designation);
        System.out.println("Salary  :   "+this.salary);  
    }
    public String toString( )
    {
        return String.format("%-15s%-5d%-10.2f",this.name, this.empid, this.salary);
        //return this.name+" "+this.empid+" "+this.salary;
        //return this.name+" "+this.empid+" "+this.department+" "+this.designation+" "+this.salary;
    }
}
class Program
{
   public static void main(String[] args) 
   {
        Employee emp = new Employee("Abc",1241,"Sales","manager",85000);
        String str = emp.toString( ); 
        System.out.println(str);
   }
}