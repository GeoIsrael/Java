
public class StringBuilderInt {

	public static void main(String[] args) {
//		String str = "Hello";
//		str = "Hello";
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.capacity());
		System.out.println(sb.hashCode());
		System.out.println(sb.append('s'));
		System.out.println(sb.capacity());
        System.out.println(sb.length());
        System.out.println(sb.append("  ma ma gg4ggg ggggg ma "));
		System.out.println(sb.capacity());

//		new StringBuilderInt()    создает размерность (capacity = 16)
//		sb = new StringBuilder(180);   //создает объект StringBuilder размерностью 180. следующее увеличение будет х2
//		System.out.println(sb.capacity());
		
		System.out.println(sb.indexOf("mak"));
		System.out.println(sb.deleteCharAt(11));


		
		
		
		
	}

}
