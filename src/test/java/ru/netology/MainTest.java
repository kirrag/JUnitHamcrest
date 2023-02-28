package ru.netology;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;


public class MainTest {
	@Test
	public void testReadString_validArgument_success() {
		// given:
		final String argument = "testData.json";
		final String expected = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Inav\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
	
		// when:
		final Main newMain = new Main();
		final String result = newMain.readString(argument);

		// then:
		assertThat(expected, equalTo(result));

	}

	@Test
	public void testReadString_nullArgument_throwsException() {
		// given:
		final Main newMain = new Main();
		final String argument = null;
		// expect:
		Assertions.assertThrows(NullPointerException.class, () -> {
			newMain.readString(argument);
		});
	}

	@Test
	public void testJsonToList_classType() {
		// given
		final String argument = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Inav\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
		final String expected = "class java.util.ArrayList";

		final Main newMain = new Main();
		final List<Employee> list = newMain.jsonToList(argument);
		final String result = list.getClass().toString();
		// then
		assertThat(expected, equalTo(result));
	}
	
	@Test
	public void testHasToStringObj() {
		// given
		final String argument = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Inav\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
		final String expected = "Employee{id='1', firstName='John', lastName='Smith', country='USA', age='25'}";

		final Main newMain = new Main();
		final List<Employee> list = newMain.jsonToList(argument);
		final Employee result = list.get(0);
		// then
		assertThat(result, hasToString(expected));
	}
	@Test
	public void testInstanceOfClassEmployee() {
		// given
		final String argument = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Inav\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
		final String expected = "Employee{id='1', firstName='John', lastName='Smith', country='USA', age='25'}";

		final Main newMain = new Main();
		final List<Employee> list = newMain.jsonToList(argument);
		final Employee result = list.get(0);
		// then
		assertThat(result, instanceOf(Employee.class));
	}

	@Test
	public void testInstanceOfClassList() {
		// given
		final String argument = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Inav\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
		final String expected = "Employee{id='1', firstName='John', lastName='Smith', country='USA', age='25'}";

		final Main newMain = new Main();
		final List<Employee> list = newMain.jsonToList(argument);
		// then
		assertThat(list, instanceOf(ArrayList.class));
	}
}
