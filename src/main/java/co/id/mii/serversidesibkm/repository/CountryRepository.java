/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidesibkm.repository;

import co.id.mii.serversidesibkm.model.Country;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MSI-JO
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
    // SELECT * FROM tb_country WHERE name="indonesia" //SQL
    // SELECT c FROM Country c WHERE c.name="indonesia" // Entity
    Optional<Country> findByName(String name);
    Boolean existsByName(String name);
}
