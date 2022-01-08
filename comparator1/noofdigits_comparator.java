package comparator1;
import java.util.Comparator;

public class noofdigits_comparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.length()<o2.length())
        return -1;
        else if(o1.length()>o2.length())
        return 1;
        return 0;
    
    
    }
    public static void main(String[] args) {
        String a="Pramod";
        String  b="abc";
        noofdigits_comparator obj=new noofdigits_comparator();
        System.out.println(obj.compare(a, b));
        System.out.println(obj.compare( b,a));
    }
    
}
