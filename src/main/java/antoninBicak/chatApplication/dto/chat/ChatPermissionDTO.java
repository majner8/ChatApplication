package antoninBicak.chatApplication.dto.chat;

import antoninBicak.chatApplication.security.ChatPermission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ChatPermissionDTO {

	private final ChatPermission permission;
}
