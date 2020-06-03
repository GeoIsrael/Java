package telran.memory;

public class MemoryService {
static public int getMaxAvailableMemory() {
	int res = 0;                        //result
	int min=1;
	int max=Integer.MAX_VALUE;          //nax value
	int middle=0;
	while(min<max) {                                    //алгоритм бинарного поиска        
		middle=(int) (((long)min+max)/2);                //приведение к лонгу чтоб не выйти за пределы инта
		try {
			byte ar[]=new byte[middle];                 //пробуем создать массив размерностью middle
			res=middle;                                 //если получилось res = middle
			//moving to the right part of memory size   
			min=middle+1;                               //сдвигаем минимум 
		}catch(OutOfMemoryError e) {
			//moving to the left part
			max=middle-1;                              //инкрементируем middle
		}
		
}
	return res;
}
}
