package com.everis.step_definitions;

import static org.junit.Assert.assertTrue;
import com.everis.objects.User;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class GestionDeEmpleadosStepDefinition{

    private Actor supervisor;
    private String theRestApiBaseUrl="https://reqres.in/api";
    
   
    @When("^El supervisor busque el codigo de empleado (.*)$")
    public void el_supervisor_busca_por_codigo_empleado(String codigo) throws Exception{
    	supervisor = Actor.named("El Supervisor").whoCan(CallAnApi.at(theRestApiBaseUrl));
    	supervisor.attemptsTo(
         		Get.resource("/users/{id}")
         		.with(request -> request.header("Content-Type", "application/json"))
         		.with( request -> request.pathParam("id", codigo))
         		);
    }
    
	@Then("^podra encontrar al empleado (.*)$")
    public void podra_ver_los_detalles_del_empleado(String nombres) throws Exception{
		String [] nombres_empleado = nombres.split(" ");
		User user = SerenityRest.lastResponse() 
                .jsonPath()
                .getObject("data", User.class);
		
		assertTrue(user.getFirstName().contains(nombres_empleado[0].toString().trim()));
		assertTrue(user.getLastName().contains(nombres_empleado[1].toString().trim()));
		
    }
    


   

}