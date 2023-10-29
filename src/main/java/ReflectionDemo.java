import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReflectionDemo
{
    public int findObject(List<?> list) throws Exception
    {
        if (list == null)
        {
            throw new Exception("Wrong list!");
        }

        int count = 0;

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) instanceof Human)
            {
                count++;
            }
        }

        return count;
    }

    public List<String> getNamesOfOpenMethods(Class<?> obj) throws Exception
    {
        if (obj == null)
        {
            throw new Exception("Wrong class!");
        }

        Method[] arr = obj.getMethods();

        List<String> list = new LinkedList<>();

        for (int i = 0; i < arr.length; i++)
        {
            list.add(arr[i].getName());
        }

        return list;
    }

    public List<String> getNameSuperClass(Class<?> obj) throws Exception
    {
        if (obj == null)
        {
            throw new Exception("Wrong class!");
        }

        List<String> list = new ArrayList<>();

        while (obj != null)
        {
            list.add(obj.getName());

            obj = obj.getSuperclass();
        }

        list.remove(0);

        return list;
    }

    public int getCountExecute(List<Class <?>> list) throws Exception
    {
        if (list == null || list.isEmpty())
        {
            throw new IllegalArgumentException("Wrong list!");
        }

        int count = 0;

        for (int i = 0; i < list.size(); i++)
        {
            Class<?>[] classes = list.get(i).getInterfaces();

            for (int j = 0; j < classes.length; j++)
            {
                if (classes[j].getName().equals("Executable"))
                {
                    Method method = list.get(i).getMethod("execute");

                    method.invoke(list.get(i).getDeclaredConstructor().newInstance());

                    count++;
                }
            }
        }

        return count;
    }

    public List<String> getSetAndGet(Class<?> obj) throws Exception
    {
        if (obj == null)
        {
            throw new Exception("Wrong class!");
        }

        List<String> list = new LinkedList<>();

        Method[] methods = obj.getMethods();

        for (int i = 0; i < methods.length; i++)
        {
            int mods = methods[i].getModifiers();

            if (!Modifier.isStatic(mods) && methods[i].getParameterCount() == 0 && !methods[i].getReturnType().toString().equals("void") && methods[i].getName().startsWith("get"))
            {
                list.add(methods[i].getName());
            }
            else if (!Modifier.isStatic(mods) && methods[i].getParameterCount() == 1 && methods[i].getReturnType().toString().equals("void") && methods[i].getName().startsWith("set"))
            {
                list.add(methods[i].getName());
            }
        }

        return list;
    }
}
