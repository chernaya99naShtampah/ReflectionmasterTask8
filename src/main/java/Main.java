import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Human human = new Human("v", "v", "v", 45);

        Student student = new Student("g", "j", "c", 13, "sfdg");

        Human h = new Student("g", "j", "c", 13, "sfdg");

        Worker worker1 = new Worker("a", "f", "a", 12, "dfh", 45);
        Worker worker2 = new Worker("a", "f", "a", 12, "dfh", 12);

        System.out.println(human);

        ReflectionDemo demo = new ReflectionDemo();

        List<?> list = new ArrayList<>(Arrays.asList(student, human, worker1, worker2, h));

        System.out.println(demo.findObject(list));

        DerivedOne one = new DerivedOne("fgd", "bv", "fd", 12, "df");

        DerivedTwo two = new DerivedTwo("sdfg", "df", "sdg", 45, "dfsdg");

        System.out.println(demo.getNamesOfOpenMethods(worker1.getClass()));
        System.out.println(demo.getNameSuperClass(two.getClass()));

        List<Class<?>> l = new ArrayList<>(Arrays.asList(one.getClass(), two.getClass()));

        System.out.println(demo.getCountExecute(l));
        System.out.println(demo.getSetAndGet(worker1.getClass()));
    }
}
