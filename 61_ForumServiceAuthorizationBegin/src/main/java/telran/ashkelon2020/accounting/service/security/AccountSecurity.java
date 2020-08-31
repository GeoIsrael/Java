package telran.ashkelon2020.accounting.service.security;

public interface AccountSecurity {
	
	String getLogin(String token);         			//возвращает логин
	
	boolean checkExpDate(String login);				//возвращает необходимость смены пароля

}
