package antoninBicak.chatApplication.security.services;

import org.springframework.stereotype.Component;

@Component
class HashPassword {

	public String hashPassword(String rawPassword) {
		return null;

	}
	public boolean comparePassword(String rawPassword,String hashPassword) {
		return false;
	}
}
