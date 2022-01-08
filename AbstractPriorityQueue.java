import java.util.Comparator;

//Priority queue class  <------Start-------> 
public abstract class AbstractPriorityQueue<K,V> {
    
    //nested Entry class   <-------Start------->         
    protected static class PQEntry<K,V>{       //generic  K -> type of key   V -> type of value 
        K key;
        V value;
        protected PQEntry(K key_para,V value_para)    //constructor set value key and value  
        {
            key=key_para;
            value=value_para;
        }
        
        //methods of entry class 
        K getkey()        
        { return key;}
        V getvalue()
        { return value;}
        void setkey(K k)
        { key =k;}
        void setvalue(V v)
        { value=v;}

    }
    
    
    //<------------------------DefaultComparatorclass------------------------------>
    public class DefaultComparator<K> implements Comparator<K>{

        @Override
        public int compare(K a,K b) throws ClassCastException {
            return ((Comparable<K> )a).compareTo(b);

        }

    }


    //Constructors for creating empty Priority queue by selction comparator passed by user  
    Comparator<K> comp; 
    //method create empty Priotity queue using given comparator to order key      
    protected AbstractPriorityQueue(Comparator<K> c)
    {   comp=c;}
    //method create empty Priotity queue based on natural ordering of  key      
    protected AbstractPriorityQueue()
    { 
        this.comp= new DefaultComparator<>();
    }

    //mehtod to comare two entry 
    protected int compare(PQEntry<K,V> a,PQEntry<K,V> b)
    {
        return comp.compare(a.getkey(), b.getkey());
    }


    //determaning key is valid or not 
    public int checkkey(K key) 
    {   try {
            return (comp.compare(key, key)==0;)
        } catch (Exception e) {
        
    }

    }








    
}
