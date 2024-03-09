package Streams;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostcommonlyUsedFunctions {

    public static void main(String ags[]){

        List<Employee> employeeList = new ArrayList<>();
        BigDecimal.valueOf(10000000);
        employeeList.add(new Employee("div","b",BigDecimal.valueOf(10000000),List.of("Teller","KYC")));
        //forEach = It's a terimal operation
       employeeList.stream().forEach(employee -> employee.getSalary().abs());

       //map - Intermediate operation
       List<String> fnames = employeeList.stream().map(Employee::getFname).toList();
        System.out.println("fnames::"+fnames);

        //collect
       Set<Employee> collectEx =  employeeList.stream().map(employee -> new Employee(employee.getFname(),employee.getLname(),
                employee.getSalary().max(BigDecimal.valueOf(100000)),employee.getProjects())).collect(Collectors.toSet());
       //filter - as the name suggest it use to filter out the records , findFirst -> Terminal Operation;

        Optional<BigDecimal> div = employeeList.stream().filter(employee -> employee.getFname().equals("div")).map(Employee::getSalary).findFirst();
//Generally findFirst returns Optional value, if you don't want a optional value you can return null or throw any exeption.

        employeeList.stream().filter(employee -> employee.getFname().equals("div")).map(Employee::getSalary).findFirst().orElseThrow();


        /*flatMap -> It basically flattens up the object means if you have list<String> instead returning
        List of strings , it returns stream of string If you have List<List<Strings>> it returns List<String> so It falttens the object
        In below example till map it's List<Strings>, after doing flatmap it became a string and finally with Joining I seperated using ,*/


       String projects = employeeList.stream().map(Employee::getProjects).flatMap(strings -> strings.stream()).collect(Collectors.joining(","));

       //Short Circuit operations - skip , limit
        //Skips : skips the specificed number of record, limit only returns specified no of elements
        //here skips the first 2 records and after the we are limit the list to 1
          employeeList.stream().skip(2).limit(1).collect(Collectors.toList());

          //Finite Data - > If I have infinite data and convert to finite limit can be used
        Stream.generate(Math::random) //here I have infinite data
                .limit(5)
                .forEach(value -> System.out.println("value::"+value));//here I'm only taking 5 elements

        //sorting :
       List<Employee> sortedList = employeeList.stream().sorted(((o1, o2) -> o1.getFname().compareToIgnoreCase(o2.getFname()))).toList();

       //min, max -> use to compare values
        employeeList.stream().min(Comparator.comparing(Employee::getSalary)).orElseThrow(NoSuchElementException::new);

        //reduce - if I want accumalte everything,In a list I have the salary if I want to accumalate
        // the each slaray into toltal or multiplication or etc I can use reduce.Here first parameter is the value you want to initialize
        //and second parameter is the binary operator

        BigDecimal total = employeeList.stream().map(employee -> employee.getSalary()).reduce(BigDecimal.ZERO,BigDecimal::add);

    }
}
