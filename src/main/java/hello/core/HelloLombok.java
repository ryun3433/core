package hello.core;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();

        System.out.println("helloLombok = " + helloLombok);
        
        helloLombok.setAge(11);
        int age = helloLombok.getAge();
        System.out.println("age = " + age);
    }
}
