package lab6.task_1;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CalculationEntity implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ID;
	int Number1;
	int Number2;
	String Operation;


}
