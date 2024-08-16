package antoninBicak.chatApplication.restAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import antoninBicak.chatApplication.dto.message.messageDTO;

@RestController
public class MessageManagementControler   {

	
	public ResponseEntity<messageDTO> getMessage(String chatID, int order) {
		return null;
	}

	
	public ResponseEntity<List<messageDTO>> getMessages(String chatID, int startOffset, int endOffSet) {
		return null;
	}

	

}
