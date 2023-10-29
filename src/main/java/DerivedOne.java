public class DerivedOne extends Student implements Executable
{
    public DerivedOne()
    {

    }

    public DerivedOne(String surname, String name, String patronymic, int age, String faculty) throws Exception
    {
        super(surname, name, patronymic, age, faculty);
    }

    @Override
    public void execute()
    {
        System.out.println("Execute");
    }
}
