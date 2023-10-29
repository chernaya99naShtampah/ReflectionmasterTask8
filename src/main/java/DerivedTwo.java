public class DerivedTwo extends DerivedOne implements Executable
{
    public DerivedTwo()
    {

    }

    public DerivedTwo(String surname, String name, String patronymic, int age, String faculty) throws Exception
    {
        super(surname, name, patronymic, age, faculty);
    }

    @Override
    public void execute()
    {
        super.execute();
    }
}
