import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K,V> {
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
    protected HeapPriorityQueue(Comparator<K> c)
    {   comp=c;}
    //method create empty Priotity queue based on natural ordering of  key      
    protected HeapPriorityQueue()
    { 
        this.comp= new DefaultComparator<>();
    }

    //mehtod to comare two entry 
    protected int compare(PQEntry<K,V> a,PQEntry<K,V> b)
    {
        return comp.compare(a.getkey(), b.getkey());
    }


    //determaning key is valid or not 
    public boolean checkkey(K key) 
    {   try 
        {return comp.compare(key, key)==(0);}
        catch (ClassCastException e) 
        { throw new IllegalArgumentException("Incompatibl key "); }
    }

    //collection of primary entries 
    public ArrayList<PQEntry<K,V>> heap=new ArrayList<PQEntry<K,V>>();
    
    //protected utilities 
    protected int left(int j ){  return (2*j+1);}
    protected int right(int j ){  return (2*j+2);}
    protected int parent(int j ){  return (j-1)/2;}     //truncasting division 
    protected Boolean hasleft(int j) { return left(j)<heap.size();}
    protected Boolean hasright(int j) { return right(j)<heap.size();}
    


    //exchange entry at index i and j 
    public void swap(int i ,int j)
    {
         PQEntry<K,V> temp= heap.get(j);
         heap.set(j,heap.get(i));
         heap.set(i,temp);
    }
    //moves the entry at index j higher ,if necessary to retore the heap property .
    protected void upheap(int j )
    {
        while(j>0)    //continue untile root come 
        {
            int parent=parent(j);
            if(compare(heap.get(parent), heap.get(j))>0)    //if voilate heap property than swap 
            {  swap(parent, j);
                j=parent;    //continue form parent location  
            }
            else
              break;
        }
    }
    //moves the entry at index j lower ,if necessary to retore the heap property .
    protected void downheap(int j)
    {    
        while(hasleft(j))     //continue until leaf node 
        {    
            //finding index of less key entry 
            int leftindex=left(j);
            int smallchildIndex=leftindex;      
            if(hasright(j))
            {
                int rightindex=right(j);
                if(compare(heap.get(leftindex), heap.get(rightindex))>0)
                   smallchildIndex=rightindex;
            }

            //if voilate heaporder property than swap 
            if( compare(heap.get(j), heap.get(smallchildIndex))>0)
            {  swap(j, smallchildIndex);
              j=smallchildIndex;
            }
            else
             break;   //if no voilation than stop downheap . 
        
        }
    }


    public int size()
    { return heap.size();}

    public Boolean isemepty()
    {  return heap.size()==0;}

    public PQEntry<K,V> insert(K ke,V va)
    {
        checkkey(ke);
        PQEntry<K,V> newest=new PQEntry<K,V>(ke,va);
        heap.add(newest);
        upheap(size()-1);
        return newest ;
    }
    
    public PQEntry<K,V> min()
    {
        if(isemepty())return null;
        return heap.get(0);
    }

    public PQEntry<K,V> removemin()
    {
        if(isemepty())return null;
        PQEntry<K,V> ans=heap.get(0);
        swap(0,heap.size()-1);
        heap.remove(heap.size()-1);
        downheap(0);
        return ans;
    }

    public void heapsort(linkedpositionallist<K> Seq,HeapPriorityQueue<K,?> p_queue) throws IllegalAccessException
    {
        int n=Seq.size();
        for (int i=0;i<n;++i)
        {
            K element= Seq.remove(Seq.first());
            p_queue.insert(element, null);
        }
        for(int i=0;i<n;++i)
        {
            K element=p_queue.removemin().getkey();
            Seq.addlast(element);
        }


    }

    

    





}
