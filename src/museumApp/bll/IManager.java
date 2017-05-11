package museumApp.bll;

import java.util.List;

/**
 *
 * JAVADOC MISSING, PLEASE CHECK
 *
 * @param <T>
 */
public interface IManager<T>
  {

    void Add(T objToAdd);

    T Update(T obj);

    List<T> ReadAll();

    T Read(int id);

    void Delete(int id);
  }
