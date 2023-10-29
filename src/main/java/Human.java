import java.util.Comparator;

public class Human implements Comparator<Human>, Executable
{
    private String surname;
    private String name;
    private String patronymic;

    private int age;
    private static int st;
    private int got;

    public Human()
    {

    }

    public Human(String surname, String name, String patronymic, int age) throws Exception
    {
        if ("".equals(surname) || surname == null || "".equals(name) || name == null || "".equals(patronymic) || patronymic == null)
        {
            throw new Exception("Wrong FIO!");
        }
        else if (age < 0)
        {
            throw new Exception("Wrong age!");
        }

        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;

        this.age = age;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname) throws Exception
    {
        if ("".equals(surname) || surname == null)
        {
            throw new Exception("Wrong surname!");
        }

        this.surname = surname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) throws Exception
    {
        if ("".equals(name) || name == null)
        {
            throw new Exception("Wrong name!");
        }

        this.name = name;
    }

    public String getPatronymic()
    {
        return patronymic;
    }

    public void setPatronymic(String patronymic) throws Exception
    {
        if ("".equals(patronymic) || patronymic == null)
        {
            throw new Exception("Wrong patronymic!");
        }

        this.patronymic = patronymic;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age) throws Exception
    {
        if (age < 0)
        {
            throw new Exception("Wrong age!");
        }

        this.age = age;
    }

    public boolean equals(Human obj)
    {
        if (this.surname.equals(obj.getSurname()) && this.name.equals(obj.getName()) && this.patronymic.equals(obj.getPatronymic()) && this.age == obj.getAge())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public String toString()
    {
        return "Human {" + " surname = " + surname + ", name = " + name + ", patronymic = " + patronymic + ", age = " + age + " }";
    }

    @Override
    public int compare(Human human1, Human human2)
    {
        int res = human1.getSurname().compareTo(human2.getSurname());

        if (res != 0)
        {
            return res;
        }

        res = human1.getName().compareTo(human2.getName());

        if (res != 0)
        {
            return res;
        }

        return human1.getPatronymic().compareTo(human2.getPatronymic());
    }

    private int getPrivate()
    {
        return got;
    }

    public static int getStatic()
    {
        return st;
    }

    public int getParam(int a, int b)
    {
        return got;
    }

    public int setInt()
    {
        return got;
    }

    public void setParam(int a, int b)
    {

    }

    public void getVoid()
    {

    }

    private void setPrivate(double a)
    {

    }

    public static void setStatic()
    {

    }

    @Override
    public void execute()
    {
        System.out.println("Execute");
    }
}
