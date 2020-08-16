package telran.person.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = {"id"})

//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)   //при сериализации надо закладывать информацию о классе, при десереализации восстанавливать
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")

@JsonSubTypes(value = {       //задание типов вручную
@Type(value = Child.class, name = "child"),
@Type(value = Employee.class, name = "employee")
})

public class Person {
	
	int id;
	@Setter	String name;
	@JsonFormat(pattern = "yyyy-MM-dd")     //определяет формат даты 
	LocalDate birthDate;
	@Setter	Address address;
	

}
