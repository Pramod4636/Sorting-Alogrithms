import java.util.Scanner;
import java.sql.Struct;
import java.util.Iterator;
import comparator1.Student;

public class TestHeap 
{     public static void HeapsortByRgId(linkedpositionallist<Student> Seq,HeapPriorityQueue<Integer,Student> p_queue) throws      IllegalAccessException
    {
        int n=Seq.size();
        for (int i=0;i<n;++i)
        {
            Student element= Seq.remove(Seq.first());
            p_queue.insert(element.getregid(), element);
        }
        for(int i=0;i<n;++i)
        {
            Student element=p_queue.removemin().getvalue();
            Seq.addlast(element);
        }


    }

    public static void HeapsortByName(linkedpositionallist<Student> Seq,HeapPriorityQueue<String,Student> p_queue) throws      IllegalAccessException
    {
        int n=Seq.size();
        for (int i=0;i<n;++i)
        {
            Student element= Seq.remove(Seq.first());
            p_queue.insert(element.getname(), element);
        }
        for(int i=0;i<n;++i)
        {
            Student element=p_queue.removemin().getvalue();
            Seq.addlast(element);
        }


    }
    public static void HeapsortByAdress(linkedpositionallist<Student> Seq,HeapPriorityQueue<String,Student> p_queue) throws      IllegalAccessException
    {
        int n=Seq.size();
        for (int i=0;i<n;++i)
        {
            Student element= Seq.remove(Seq.first());
            p_queue.insert(element.getadress(), element);
        }
        for(int i=0;i<n;++i)
        {
            Student element=p_queue.removemin().getvalue();
            Seq.addlast(element);
        }


    }
    public static void HeapsortByGrade(linkedpositionallist<Student> Seq,HeapPriorityQueue<String,Student> p_queue) throws      IllegalAccessException
    {
        int n=Seq.size();
        for (int i=0;i<n;++i)
        {
            Student element= Seq.remove(Seq.first());
            p_queue.insert(element.getgrade(), element);
        }
        for(int i=0;i<n;++i)
        {
            Student element=p_queue.removemin().getvalue();
            Seq.addlast(element);
        }


    }

    
    public static class Student   //Studnet class to store Student information 
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
        System.out.println("\tID\t\t\tName\t\t\tAdress\t\t\tGrade ");
        while(itr.hasNext())
        {
           st= (Student)itr.next();
           System.out.println("\t"+st.getregid() +"\t\t\t"+st.getname()+"\t\t\t"+st.getadress()+"\t\t\t"+st.getgrade());
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
        HeapPriorityQueue<Integer,Student> increasing_heap=new HeapPriorityQueue<Integer,Student>();
        HeapPriorityQueue<Integer,Student> decreasing_heap=new HeapPriorityQueue<Integer,Student>();
        
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
        System.out.println("\t**************************  Data Before Sorting  ***********************");
        display(Seq);
        HeapsortByRgId(Seq,heap_increasing);
        System.out.println("**********Student Data After Sorting by Regestration Id*************");
        display(Seq);



    
    }
}
