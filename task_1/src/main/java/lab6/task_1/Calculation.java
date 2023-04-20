package lab6.task_1;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("/calculations")
public class Calculation {
	@Inject
	EntityManager em;
@POST
@Path("/api/calc")
	public Result createCalculation(CalculationEntity e)
	{
		Result result = new Result();
		if (e.Operation.equals("+"))
		{
		result.Result=	e.Number1 + e.Number2;
		}
		else if (e.Operation.equals("-"))
		{
		result.Result=	e.Number1 - e.Number2;
		}
		else if (e.Operation.equals("/"))
		{
		result.Result=	e.Number1 / e.Number2;
		}
		else if (e.Operation.equals("*"))
		{
		result.Result=	e.Number1 * e.Number2;
		}
		em.persist(e);
	    return result;
	}
@GET 
@Path("/api/calculations")
public List<CalculationEntity> getCalculationEntities()
{
	
	  TypedQuery<CalculationEntity> query = em.createQuery("select c from CalculationEntity c", CalculationEntity.class);
	return query.getResultList();
	
}
}
