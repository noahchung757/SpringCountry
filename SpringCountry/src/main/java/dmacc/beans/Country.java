package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 2, 2021
 */

@Data
@Entity
public class Country {
	@Id
	@GeneratedValue
	private long id;
	String name;
	String leader;
	double population;
}
