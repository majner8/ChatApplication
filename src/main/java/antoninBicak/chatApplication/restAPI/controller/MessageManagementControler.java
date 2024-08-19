package antoninBicak.chatApplication.restAPI.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import antoninBicak.chatApplication.dto.message.MessageDTO;


@RestController
public class MessageManagementControler   {


	public ResponseEntity<MessageDTO> getMessage(String chatID, int order) {
		return null;
	}


	public ResponseEntity<List<MessageDTO>> getMessages(String chatID, int startOffset, int endOffSet) {
		return null;
	}



}
