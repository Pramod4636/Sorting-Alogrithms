import java.util.Iterator;
public class linkedpositionallist<E>  {
    private static class positionnode<E> implements position<E> {
        private E element;                //reference to store element 
        private  positionnode<E> next;    //reference to store next node 
        private positionnode<E> previous; //reference to store previous node
        
    
        public positionnode(E e,positionnode<E> pre,positionnode<E> n) //set all variable value at time of creation node 
        {   
            element=e;
            next=n;
            previous=pre;
        }
    
        public E getelement()          //return element  if list is not empty
        { return element;}
    
        public positionnode<E> getnext()   //gives  next node
        {  return next;}
        
        public positionnode<E> getprevious()  //gives poprevious node
        {  return previous;}
        
        public void setprevious(positionnode<E> node )  //sets prvious node
        { previous=node;}
    
        public void setnext(positionnode<E> node)    //sets next node
        { next =node;}
    
        public void setelement(E e )
        { element=e;}
    }
    
    
    
    private int size;                            //store number of elment in list 
    private positionnode<E> header;             //header sentile to maintain border 
    private positionnode<E> tailer;             //tailer sentile to maintain border 

    public linkedpositionallist()               //constructor to set values at time of creation of object
    {
        header=new positionnode<E>(null, null, null);        
        tailer=new positionnode<E>(null, header, null);
        size=0;
        header.setnext(tailer);
    }
    

   
    public int size()
    { return size;}   

    public boolean isempty()      //true if list is empty otherwise false
    { return size==0;}
    
    //it validate position and return its node   (check given position is exit for list and return node correspondes to that position )
    private positionnode<E> validate(position<E> p) throws IllegalAccessException  
    {   if(!(p instanceof positionnode<E>) )                            
        throw new IllegalArgumentException("Position is not valid .");
        positionnode<E> x = (positionnode<E>) p;     //safe cast 
        if((x.getnext()==null))                      //to identify is position is tailer 
        throw new IllegalAccessException("p is no longer in list");
        return x;                                    //return node 
            
    }

    //it conver node to position 
    private position<E> position(positionnode<E> node)
    {
        if(node== header || node== tailer)   //check node is sentiles
        return null ;
        else
        return node;
    }
    
    
    public position<E> first()        //return first position in list           
    {   if(!isempty())                          
        return position(header.getnext());      //return position if list is not empty
        else
        return null;
    }
    
    
    public position<E> last()                    //return last position in list  
    {   if(!isempty())
        return position(tailer.getprevious());
        else
        return null;
    }
    
            //return position after given position 
    public position<E> after(position<E> p) throws IllegalAccessException   
    {     positionnode<E> tempnode = validate(p);                  //converting positino to node
          return position(tempnode.getnext());                     //return position 
    }

   //return position before given position 
    public position<E> before(position<E> p) throws IllegalAccessException  
    {
        positionnode<E> tempnode= validate(p);                      //converting position to node
        return position(tempnode.getprevious()); 
    }
     //adding new node inbetween 2 node   
     //this class is private for user can only add not see how we are adding  
     private position<E> addbetween(E e,positionnode<E> pre,positionnode<E> suc) throws IllegalAccessException
     { 
       
      positionnode<E> Newnode= new positionnode<E>(e, pre,suc);  //creating newnode and linking
      pre.setnext(Newnode);            //linking newnode next to the previous node             
      suc.setprevious(Newnode);        //linking newnode previous of succesor nod
      ++size;
      return position(Newnode);        //return position of new node    
 
     }
       //add element at front of list 
     public position<E> addfirst(E e) throws IllegalAccessException            
    {   
        return addbetween(e,header,header.getnext() );
    }
     //add element at end of list
    public position<E> addlast(E e ) throws IllegalAccessException               
    {
        return addbetween(e,tailer.getprevious(),tailer );
       
    }
    
   //add element before P and return its new position 
    public position<E> addbefore(position<E> p ,E e) throws IllegalAccessException
    {   positionnode<E> newnode = validate(p);   
        return addbetween(e,newnode.getprevious(),newnode );

    }
  
    //add element after  P and return its new position 
    public position<E> addafter(position<E> p,E e) throws IllegalAccessException
    {   positionnode<E> newnode = validate(p);
        return addbetween(e, newnode,newnode.getnext() );
    }
    
     //set element at given position 
    public E set(position<E> p,E e ) throws IllegalAccessException
    {
        positionnode<E> node =validate(p);    //it convert position to node 
        E ans= node.getelement();            //saving old element for return  
        node.setelement(e);               //new element is set
        return ans;  
    }
    
     //remove  position from list and return removed element 
    public E remove(position<E> p) throws IllegalAccessException
    {
        positionnode<E> node=validate(p);
        node.getprevious().setnext(node.getnext()); //linking previous node to next node of removing node
        node.getnext().setprevious(node.getprevious()); //linking next node to previous node of removing node
        E removed=node.getelement();
        node.setelement(null);
        node.setnext(null);
        node.setprevious(null);
        --size;
        return removed;
    } 
    
    public class PositionIterator implements Iterator<position<E>>   //for iteration thorugh collection of position 
    {       position<E> cursor = first();
            position<E> recent = null;
            @Override
            public boolean hasNext() {     //check next position is exit 
                return (cursor != null);  
            }

            @Override
            public position<E> next() {   //gives next position 
            if(cursor == null)
            {System.out.println("no such element .");
             return null;
            }
            recent = cursor;
            try {
                cursor = after(cursor);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return recent;
        }

        @Override
        public void remove() {      //remove recent position called 
            if(recent == null)  
            {System.out.println("nothing to remove ");}
            try {
                linkedpositionallist.this.remove(recent);
            } catch (IllegalAccessException e) {
               
                e.printStackTrace();
            }
            recent = null;
        }
    }
   
    private class ElementIterator implements Iterator<E>     //to iterate collection of elements in list 
    {
        Iterator<position<E>> positerator = new PositionIterator(); 
        public boolean hasNext() {return positerator.hasNext();}  //check next element is present 
        public E next(){return positerator.next().getelement();}  //return next element 
        public void remove(){ positerator.remove();}   //remove element 

    }
    private class elementiterable implements Iterable<E>   //return elementitrator 
    {
        public Iterator<E> iterator()
        {   
            return  new  ElementIterator();
        }
    }
    private class positioniterable implements Iterable<position<E>>  //return positionitrator
    {
        public Iterator<position<E>> iterator()
        {  return  new PositionIterator();}

    }
    public Iterable<position<E>> positions()      //return positionaliterable
    {
        return new positioniterable();
    }
    public Iterable<E> elements()           //return elementiterable 
    {
        return new elementiterable();
    }
}
