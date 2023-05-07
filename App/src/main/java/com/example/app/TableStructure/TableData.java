package com.example.app.TableStructure;

public class TableData
{
    //Usikker om det er en god idé om at have en hel klasse dedikeret til data i tableview,
    //men det var den eneste måde for at få dataen til at loade ordentligt.

    private int id;
    private String name;
    private String password;

    public TableData(int id, String name, String password)
    {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
}
