/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museumApp.bll;

import java.util.List;

/**
 *
 * @author Peder
 */
public interface IManager<T>
  {

    void Add(T objToAdd);

    T Update(T obj);

    List<T> ReadAll();

    T Read(int id);

    void Delete(int id);
  }
