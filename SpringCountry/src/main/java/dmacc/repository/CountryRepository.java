package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Country;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 2, 2021
 */

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
