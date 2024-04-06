package project4.json;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.*;

import project4.Employee;
import project4.Manager;
import project4.Operator;
import project4.Provider;

public class EmployeeAdapter implements JsonDeserializer<ArrayList<Employee>> {

	@Override
	public ArrayList<Employee> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonArray jsonObjectArray = json.getAsJsonArray();
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		for(JsonElement jsonElement : jsonObjectArray) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			short type = jsonObject.get("employeeType").getAsShort();
			if(type == Employee.MANAGER) {
				employeeList.add(context.deserialize(jsonElement, Manager.class));
			} else if(type == Employee.OPERATOR) {
				Operator op = context.deserialize(jsonElement, Operator.class);
				employeeList.add(context.deserialize(jsonElement, Operator.class));
			} else if(type == Employee.PROVIDER) {
				employeeList.add(context.deserialize(jsonElement, Provider.class));
			} else {
				throw new JsonParseException("Unknown employee type: " + String.valueOf(type));
			}
		}
		return employeeList;
		
	}

}
