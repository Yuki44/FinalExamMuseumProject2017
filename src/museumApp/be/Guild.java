/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.be;

/**
 *
 * @author Peder
 */
public class Guild extends BusinessEntity
{

    protected String name;
    protected int managerId;

    public Guild(String name, int managerId, int id)
    {
        super(id);
        this.name = name;
        this.managerId = managerId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getManagerId()
    {
        return managerId;
    }

    public void setManagerId(int managerId)
    {
        this.managerId = managerId;
    }

}
