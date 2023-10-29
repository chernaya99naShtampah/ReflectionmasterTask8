public class Student extends Human
{
    protected String faculty;
    private int got;
    private static int st;

    public Student()
    {

    }

    public Student(String surname, String name, String patronymic, int age, String faculty) throws Exception
    {
        super(surname, name, patronymic, age);

        if ("".equals(faculty) || faculty == null)
        {
            throw new Exception("Wrong faculty!");
        }

        this.faculty = faculty;
    }

    public String getFaculty()
    {
        return faculty;
    }

    public void setFaculty(String faculty) throws Exception
    {
        if ("".equals(faculty) || faculty == null)
        {
            throw new Exception("Wrong faculty!");
        }

        this.faculty = faculty;
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
    public String toString()
    {
        return "Student {" + " surname = " + super.getSurname() + ", name = " + super.getName() + ", patronymic = " + super.getPatronymic() + ", age = " + super.getAge() + ", faculty = " + faculty  + " }";
    }
}