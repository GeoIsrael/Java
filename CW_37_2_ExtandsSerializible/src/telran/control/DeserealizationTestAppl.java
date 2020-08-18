package telran.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.omg.CORBA.SystemException;

import telran.model.Child;

public class DeserealizationTestAppl {

	public static void main(String[] args) {
		

		try { ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test"));
		System.out.println("Creaning..");
		Child child = new Child(10);
		child.setParentField(100);
		System.out.println("Serialize..");  //parent сделать не SZ и SZ
		out.writeObject(child);                   //сериализовали объект
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {ObjectInputStream in = new ObjectInputStream(new FileInputStream("test"));
			System.out.println("DeSerialize..");      //При десереализации никакие кнструктооры не вызываются если у парент - сериалайзбл
			Child child = (Child) in.readObject();        //есть ситуация без дефолтного конструктора
			System.out.println(child.getChildField() + "CF");
			System.out.println(child.getParentField() + "PF");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//вывод если ребенок SZ и родитель SZ  все ок, если родитель не SZ то у него должен быть дефолтный конструктор
		//если дефолтного конструктора нет - то не пройдет
		
		
	}

}
