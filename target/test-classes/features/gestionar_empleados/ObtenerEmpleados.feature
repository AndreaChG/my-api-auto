Feature: Obtener detalle de empleados
Como Supervisor 
Deseo encontrar la informacion de un empleado 
Y la lista de empleados por cada area
Para tener actualizado la distribucion de empleados en la empresa

Scenario Outline: Encontrar a un empleados por su codigo
	When El supervisor busque el codigo de empleado <codigo>
	Then podra encontrar al empleado <nombre>
	Examples: 
	|  codigo  	|	nombre  	| 
	| 1        	| George Bluth	|   
	| 2		 	| Janet  Waver 	| 