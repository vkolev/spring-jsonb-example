package net.vkolev.springjsonbexample.repositories;

import net.vkolev.springjsonbexample.entities.Recepie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecepieRepository extends JpaRepository<Recepie, Long> {
    @Query(value = """
    SELECT * FROM recepies WHERE jsonb_path_exists(topping, ('$[*] ? (@.type == "'|| :name ||'")')::jsonpath) IS true""", nativeQuery = true)
    List<Recepie> findWithToppings(@Param("name") String name);

    @Query(value = """
    SELECT * FROM recepies WHERE jsonb_path_exists(topping, ('$[*] ? (@.type like_regex "^'|| :name ||'$" flag "i")')::jsonpath) IS true""", nativeQuery = true)
    List<Recepie> findWithToppingsInsensitive(@Param("name") String name);
}
