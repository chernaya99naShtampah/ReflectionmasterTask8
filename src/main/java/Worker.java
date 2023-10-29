public class Worker extends Human
{
    protected String work;
    protected int pay;
    private int got;
    private static int st;

    public Worker()
    {

    }

    public Worker(String surname, String name, String patronymic, int age, String work, int pay) throws Exception
    {
        super(surname, name, patronymic, age);

        if ("".equals(work) || work == null)
        {
            throw new Exception("Wrong string of work!");
        }
        else if (pay < 0)
        {
            throw new Exception("Wrong pay!");
        }

        this.work = work;
        this.pay = pay;
    }

    public String getWork()
    {
        return work;
    }

    public int getPay()
    {
        return pay;
    }

    public void setWork(String work)
    {
        this.work = work;
    }

    public void setPay(int pay)
    {
        this.pay = pay;
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
        return "Worker {" + " surname = " + super.getSurname() + ", name = " + super.getName() + ", patronymic = " + super.getPatronymic() + ", age = " + super.getAge() + ", work = " + work + ", pay = " + pay + " }";
    }
}
