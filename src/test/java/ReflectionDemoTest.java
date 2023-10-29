import org.junit.Test;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ReflectionDemoTest
{
    @Test
    public void testFindObject1() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 45);

        Student student = new Student("Dmitriev", "Dmitrii", "Dmitrievich", 18, "mathematics");

        Human h = new Student("Sergeev", "Sergei", "Sergeevich", 19, "psychology");

        Worker worker1 = new Worker("Artemov", "Artem", "Artemovich", 45, "manager", 50);
        Worker worker2 = new Worker("Andreev", "Andrei", "Andreevich", 30, "layer", 60);

        List<?> list = new ArrayList<>(Arrays.asList(human, student, h, worker1, worker2));

        assertEquals(5, demo.findObject(list));
    }

    @Test
    public void testFindObject2() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 45);

        Student student = new Student("Dmitriev", "Dmitrii", "Dmitrievich", 18, "mathematics");

        Human h = new Student("Sergeev", "Sergei", "Sergeevich", 19, "psychology");

        Testing test = new Testing();

        List<?> list = new ArrayList<>(Arrays.asList(human, student, h, test));

        assertEquals(3, demo.findObject(list));
    }

    @Test
    public void testFindObject3() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        List<?> list = new ArrayList<>();

        assertEquals(0, demo.findObject(list));
    }

    @Test(expected = Exception.class)
    public void testFindObject4() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        demo.findObject(null);
    }

    @Test
    public void testGetNamesOfOpenMethods1() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 45);

        List<String> list = new LinkedList<>(Arrays.asList("setStatic", "setParam", "getVoid", "getStatic", "setInt", "getParam", "equals", "toString", "hashCode", "compare", "compare", "execute", "setName", "getPatronymic", "setAge", "getAge", "getSurname", "setSurname", "setPatronymic", "equals", "getClass", "notify", "notifyAll", "wait", "wait", "wait", "thenComparing", "thenComparing", "thenComparing", "reversed", "thenComparingInt", "thenComparingLong", "thenComparingDouble"));

        assertTrue(demo.getNamesOfOpenMethods(human.getClass()).containsAll(list));
    }

    @Test
    public void testGetNamesOfOpenMethods2() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Student student = new Student("Dmitriev", "Dmitrii", "Dmitrievich", 18, "mathematics");

        List<String> list = new LinkedList<>(Arrays.asList("setStatic", "setParam", "getVoid", "getStatic", "setInt", "getParam", "toString", "setFaculty", "getFaculty", "getName", "equals", "hashCode", "compare", "compare", "execute", "setName", "setAge", "getAge", "getPatronymic", "setPatronymic", "getSurname", "setSurname", "equals", "getClass", "notify", "notifyAll", "wait", "wait", "wait", "thenComparing", "thenComparing", "thenComparing", "reversed", "thenComparingInt", "thenComparingLong", "thenComparingDouble"));

        assertTrue(demo.getNamesOfOpenMethods(student.getClass()).containsAll(list));
    }

    @Test
    public void testGetNamesOfOpenMethods3() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Worker worker = new Worker("Artemov", "Artem", "Artemovich", 45, "manager", 50);

        List<String> list = new LinkedList<>(Arrays.asList("setStatic", "setParam", "getVoid", "getStatic", "setInt", "getParam", "toString", "getPay", "setPay", "getWork", "setWork", "getName", "equals", "hashCode", "compare", "compare", "execute", "setName", "getPatronymic", "setAge", "getSurname", "setSurname", "setPatronymic", "getAge", "equals", "getClass", "notify", "notifyAll", "wait", "wait", "wait", "thenComparing", "thenComparing", "thenComparing", "reversed", "thenComparingInt", "thenComparingLong", "thenComparingDouble"));

        assertTrue(demo.getNamesOfOpenMethods(worker.getClass()).containsAll(list));
    }

    @Test(expected = Exception.class)
    public void testGetNamesOfOpenMethods4() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Student student = new Student("Dmitriev", "Dmitrii", "Dmitrievich", 18, "mathematics");

        demo.getNamesOfOpenMethods(null);
    }

    @Test
    public void testGetNameSuperClass1() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 45);

        List<String> list = new ArrayList<>(Arrays.asList("java.lang.Object"));

        assertEquals(list, demo.getNameSuperClass(human.getClass()));
    }

    @Test
    public void testGetNameSuperClass2() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Student student = new Student("Dmitriev", "Dmitrii", "Dmitrievich", 18, "mathematics");

        List<String> list = new ArrayList<>(Arrays.asList("Human", "java.lang.Object"));

        assertEquals(list, demo.getNameSuperClass(student.getClass()));
    }

    @Test
    public void testGetNameSuperClass3() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        DerivedTwo derived = new DerivedTwo("Dmitriev", "Dmitrii", "Dmitrievich", 20, "mathematics");

        List<String> list = new ArrayList<>(Arrays.asList("DerivedOne", "Student", "Human", "java.lang.Object"));

        assertEquals(list, demo.getNameSuperClass(derived.getClass()));
    }

    @Test(expected = Exception.class)
    public void testGetNameSuperClass4() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        demo.getNameSuperClass(null);
    }

    @Test
    public void testGetCountExecute1() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 45);
        Student student = new Student("Dmitriev", "Dmitrii", "Dmitrievich", 18, "mathematics");
        DerivedTwo derived = new DerivedTwo("Dmitriev", "Dmitrii", "Dmitrievich", 20, "mathematics");

        List<Class<?>> list = new ArrayList<>(Arrays.asList(human.getClass(), student.getClass(), derived.getClass()));

        assertEquals(2, demo.getCountExecute(list));
    }

    @Test
    public void testGetCountExecute2() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Student student = new Student("Dmitriev", "Dmitrii", "Dmitrievich", 18, "mathematics");
        Worker worker1 = new Worker("Artemov", "Artem", "Artemovich", 45, "manager", 50);
        Worker worker2 = new Worker("Andreev", "Andrei", "Andreevich", 30, "layer", 60);

        List<Class<?>> list = new ArrayList<>(Arrays.asList(student.getClass(), worker1.getClass(), worker2.getClass()));

        assertEquals(0, demo.getCountExecute(list));
    }

    @Test
    public void testGetCountExecute3() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 45);
        DerivedOne derived1 = new DerivedTwo("Dmitriev", "Dmitrii", "Dmitrievich", 20, "mathematics");
        DerivedTwo derived2 = new DerivedTwo("Artemov", "Artem", "Vladimirovich", 19, "psychology");

        List<Class<?>> list = new ArrayList<>(Arrays.asList(human.getClass(), derived1.getClass(), derived2.getClass()));

        assertEquals(3, demo.getCountExecute(list));
    }

    @Test(expected = Exception.class)
    public void testGetCountExecute4() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        List<Class<?>> list = new ArrayList<>();

        demo.getCountExecute(list);
    }

    @Test(expected = Exception.class)
    public void testGetCountExecute5() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        demo.getCountExecute(null);
    }

    @Test
    public void testGetSetAndGet1() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 45);

        List<String> list = new LinkedList<>(Arrays.asList("getName", "setName", "getPatronymic", "setAge", "getSurname", "setSurname", "getAge", "setPatronymic", "getClass"));

        assertTrue(demo.getSetAndGet(human.getClass()).containsAll(list));
    }

    @Test
    public void testGetSetAndGet2() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Student student = new Student("Dmitriev", "Dmitrii", "Dmitrievich", 18, "mathematics");

        List<String> list = new LinkedList<>(Arrays.asList("getFaculty", "setFaculty", "getName", "setName", "getPatronymic", "setAge", "getSurname", "setSurname", "getAge", "setPatronymic", "getClass"));

        assertTrue(demo.getSetAndGet(student.getClass()).containsAll(list));
    }

    @Test
    public void testGetSetAndGet3() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        Worker worker = new Worker("Artemov", "Artem", "Artemovich", 45, "manager", 50);

        List<String> list = new LinkedList<>(Arrays.asList("getPay", "setPay", "getWork", "setWork", "getName", "setName", "getPatronymic", "setAge", "getSurname", "setSurname", "getAge", "setPatronymic", "getClass"));

        assertTrue(demo.getSetAndGet(worker.getClass()).containsAll(list));
    }

    @Test(expected = Exception.class)
    public void testGetSetAndGet4() throws Exception
    {
        ReflectionDemo demo = new ReflectionDemo();

        demo.getSetAndGet(null);
    }
}