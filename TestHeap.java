import java.util.Scanner;
import java.sql.Struct;
import java.util.Iterator;
import comparator1.Student;
import java.util.Comparator;

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
    public static class DecreasingComparatorString implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if( ((o1.toLowerCase()).compareTo(o2.toLowerCase())==0))
            {
                return 0;
            }
            if((o1.toLowerCase()).compareTo(o2.toLowerCase())>0)
            return -1;
            return 1;
        }
    }
    public static class IncreasingComparatorString implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if( ((o1.toLowerCase()).compareTo(o2.toLowerCase())==0))
            {
                return 0;
            }
            if((o1.toLowerCase()).compareTo(o2.toLowerCase())>0)
            return 1;
            return -1;
        }
    }
    public static class DecreasingComparatorInteger implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1==o2)
            return 0;
            if(o1>o2)
            return -1;
            return 1;
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
        IncreasingComparatorString com_incresing_str=new IncreasingComparatorString();
        DecreasingComparatorInteger com_decresing_int=new DecreasingComparatorInteger();
        DecreasingComparatorString com_decreasing_str=new DecreasingComparatorString();
        linkedpositionallist<Student> Seq=new linkedpositionallist<Student>();
        linkedpositionallist<Student> Seq2=new linkedpositionallist<Student>();
        HeapPriorityQueue<Integer,Student> increasing_heap_int=new HeapPriorityQueue<Integer,Student>();
        HeapPriorityQueue<String,Student> increasing_heap_string=new HeapPriorityQueue<String,Student>(com_incresing_str);
        HeapPriorityQueue<Integer,Student> decreasing_heap_int=new HeapPriorityQueue<Integer,Student>(com_decresing_int);
        HeapPriorityQueue<String,Student> decreasing_heap_string=new HeapPriorityQueue<String,Student>(com_decreasing_str);
     
        
        System.out.println("\nEnter Student Information : ");
        for (int i=0;i<n;++i)
        {    
            System.out.print("Studnet "+ (i+1)+" : ");
            System.out.println("\nRegestrationId\tName\tAdress\tGrade  : ");
            rgid=scan.nextInt();
            scan.nextLine();
            name=scan.nextLine();
            adress=scan.nextLine();
            grade=scan.nextLine();
            Student s= new Student(rgid, name, adress, grade);
            Seq.addlast(s);

        }
    do{

        System.out.println("\n\t**************************  Data Before Sorting  ***********************");
        display(Seq);
    
        System.out.print("1.Incresing\t2.Decreasing Select Option : ");
        n=scan.nextInt();
        switch(n)
        {
            case 1 : 
            System.out.println("\nSorting Opetion 1.By RegestrationId\t2.By Name\t3. By Adress\t4. By Grade  ");
            System.out.print("Select Opetion : ");
            n=scan.nextInt();
            switch(n)
            {
                case 1 : 
                Seq2=Seq;
                System.out.println("********** After increasing Sorting by Regestration Id  **********");
                HeapsortByRgId(Seq2,increasing_heap_int);
                display(Seq2);
                break;
                
                case 2 : 
                Seq2=Seq;
                System.out.println("********** After increasing Sorting by Name  **********");
                HeapsortByName(Seq2,increasing_heap_string);
                display(Seq2);
                break;
                
                case 3 : 
                Seq2=Seq;
                System.out.println("********** After increasing Sorting by Adress **********");
                HeapsortByAdress(Seq2, increasing_heap_string);
                display(Seq2);
                break;

                case 4 : 
                Seq2=Seq;
                System.out.println("********** After increasing Sorting by Regestration Id  **********");
                HeapsortByGrade(Seq2,increasing_heap_string );
                display(Seq2);
                break;

                default :
                System.out.println("NO such option .select proper option");
                
                
            }
            break;

            case 2 : 
            System.out.println("Sorting Opetion 1.By RegestrationId\t2.By Name\t3. By Adress\t4. By Grade  ");
            System.out.print("Select Opetion : ");
            n=scan.nextInt();
            switch(n)
            {
                case 1 : 
                Seq2=Seq;
                System.out.println("********** After Decreasing Sorting by RegestrationId **********");
                HeapsortByRgId(Seq,decreasing_heap_int);
                display(Seq2);
                break;

                case 2 : 
                Seq2=Seq;
                System.out.println("********** After Decreasing Sorting by Name  **********");
                HeapsortByName(Seq2,decreasing_heap_string);
                display(Seq2);
                break;

                case 3 : 
                Seq2=Seq;
                System.out.println("********** After Decreasing Sorting by Adress  **********");
                HeapsortByAdress(Seq,decreasing_heap_string );
                display(Seq2);
                break;
                
                case 4 : 
                Seq2=Seq;
                System.out.println("********** After Decreasing Sorting by Grade  **********");
                HeapsortByGrade(Seq, decreasing_heap_string);
                display(Seq2);
                break;

                default :
                System.out.println("NO such option .select proper option");
                
                

        


            }

            default :
                System.out.println("NO such option .select proper option");
                

        }
        System.out.print("Enter 1 for continue \tEnter 0 for Exit slect operation : ");
        n=scan.nextInt();


       }while(n==1);
    }


}
