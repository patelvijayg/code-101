import java.util.*;
import java.util.stream.Collectors;

public class Template_Stream {
    public static void main(String[] args) {
        List<Integer> l2= Arrays.asList(1,2,3,4,5,6,7);
        List<Long> l3=l2.stream().map(i-> new Long(i)).collect(Collectors.toList());
        System.out.println("");
    }


}
