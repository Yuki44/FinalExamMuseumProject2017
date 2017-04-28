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
public abstract class BusinessEntity
{

    protected final int id;

    public BusinessEntity(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

}
