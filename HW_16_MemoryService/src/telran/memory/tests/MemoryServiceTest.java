package telran.memory.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import telran.memory.MemoryService;

public class MemoryServiceTest {
byte ar[];
	@Test
	public void memoryServiceTest() {
		Runtime runtime=Runtime.getRuntime();      
		System.out.printf
		("max free memory %d,"+ " max  memory %d," + "total memory %d\n",
				runtime.freeMemory(), runtime.maxMemory(),runtime.totalMemory());
		int max=MemoryService.getMaxAvailableMemory();
		ar=new byte[max];
		ar=null;
		boolean fl=false;
		try {
			ar=new byte[max+1];
			fl=false;
		}
		catch (OutOfMemoryError e){
			fl=true;
		}
		assertTrue(fl);
		System.out.println
		("max memory from the function "+max);      // show the size of the created array
		System.out.printf
		("max free memory %d,"+ " max  memory %d," + "total memory %d\n",
				runtime.freeMemory(),runtime.maxMemory(),runtime.totalMemory());
		
	}

}
