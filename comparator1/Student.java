package comparator1;
//natural ordering 
public class Student implements Comparable<Student>{  
    int rollno;  
    String name;  
    int age;  
    Student(int rollno,String name,int age){  
    this.rollno=rollno;  
    this.name=name;  
    this.age=age;  
    }  
      
    public int compareTo(Student st){  
    if(age==st.age)  
    return 0;  
    else if(age>st.age)  
    return 1;  
    else  
    return -1;  
    }
    public static void main(String[] args) {
        Student obj1=new Student(10,"pramod",19);
        Student obj2=new Student(20,"prasad",23);
        System.out.println(obj1.compareTo(obj2));
        
    }
    
    }  
