import java.util.Scanner;
import java.sql.Struct;
import java.util.Iterator;
import comparator1.Student;

public class TestHeap 
{   public static class Student   //Studnet class to store Student information 
    {
        int RegId;
        String Name;
        String Adress;
        String Grade;

        public Student(int id,String name,String adress,String grad)
        {
            RegId=id;
            Name=name;
            Adress=adress;
            Grade=grad;
        }

        //Methods of Student class 
        public int getregid()
        { return RegId;}
        public String getname()
        { return Name;}
        public String getadress()
        { return Adress;}
        public String getgrade()
        { return Grade;}
        

    }
    public static void display(linkedpositionallist<Student> s)
    {   Iterator<Student> itr;
        Student st;
        itr=s.elements().iterator();
        System.out.println("\t************************** Student Data ***********************");
        System.out.println("\t\tID\t\tName\t\tAdress\t\tGrade ");
        
        while(itr.hasNext())
        {
           st= (Student)itr.next();
           System.out.println("\t"+st.getregid() +"\t\t"+st.getname()+"\t\t"+st.getadress()+"\t\t"+st.getgrade());
        }
    }
    public static void main(String[] args) throws IllegalAccessException
    {   
        System.out.println("\t***************** Welcome To Heap Sorting of Student Data  *********");
        System.out.print("Enter Number of Student : ");
        int n,rgid;
        String name,adress,grade;
        Scanner scan=new Scanner(System.in);  
        n=scan.nextInt();
        linkedpositionallist<Student> Seq=new linkedpositionallist<Student>();
        System.out.println("\nEnter Student Information : ");
        for (int i=0;i<n;++i)
        {    
            System.out.print("Studnet "+ (i+1)+" : ");
            System.out.print("\nRegestrationId\tName\tAdress\tGrade  : ");
            rgid=scan.nextInt();
            scan.nextLine();
            name=scan.nextLine();
            adress=scan.nextLine();
            grade=scan.nextLine();
            Student s= new Student(rgid, name, adress, grade);
            Seq.addlast(s);

        }
        display(Seq);



    
    }
}
