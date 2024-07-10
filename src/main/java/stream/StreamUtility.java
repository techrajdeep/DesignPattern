package stream;

import builder.version1.Computer;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtility {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,3, 5, 8,11, 5,20,32,0,45,34,99);
        list.stream().forEach(a-> System.out.println(a));

        // Intermediate operations
        //1.map
        List<Integer> list1=list.stream().map(a->a*a).collect(Collectors.toList());
        System.out.println(list1);
        //2.filter
        List<Integer> oddList= list.stream().filter(a->a%2==1).collect(Collectors.toList());
        System.out.println(oddList);
        //3. sorted
        List<Integer> sortedList= list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);


        List<Integer> reverseSortedList= list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseSortedList);

        List<Employee> empList=Arrays.asList( Employee.builder().setName("rajdeep").setId(1).build(),
                Employee.builder().setName("tubai").setId(2).build(),
                Employee.builder().setName("abc").setId(3).build(),
                Employee.builder().setName("def").setId(4).build());
        List<Employee> sortedByIdEmpList=empList.stream().sorted((e1,e2)->Integer.compare(e1.getId(),e2.getId())).collect(Collectors.toList());
        System.out.println(sortedByIdEmpList);

        List<Employee> sortedByNameEmpList=empList.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
        System.out.println(sortedByNameEmpList);

        // terminal methods
        //1. collect() , 2. forEach()
        // 3. reduce
        Integer value= list.stream().reduce(0,(integer, integer2) -> (integer+integer2)).intValue();
        System.out.println(value);



    }


}
