package antoninBicak.chatApplication.dto.message;



/**
 * This enum represents a system-generated message.
 * Each type represents a unique system message and contains different map keys that must be filled.
 */
enum SystemGeneratedMessageEventType {

    /**
     * The following keys must be included in the map:
     * <ul>
     * <li><strong>chatID</strong>: chatID</li>
     * <li><strong>nickName</strong>: The nickname of the user.</li>
     * <li><strong>userID_init</strong>: The user ID of the user who initiated the nickname change request.</li>
     * <li><strong>userID_owner</strong>: The user ID of the user whose nickname will be changed.</li>
     * </ul>
     */
    ChangeUserChatName,

    /**
     * The following keys must be included in the map:
     * <ul>
     * <li><strong>chatID</strong>: chatID</li>
     * <li><strong>chatName</strong>: The chatName chat.</li>
     * <li><strong>userID_init</strong>: The user ID of the user who initiated the chatName change request.</li>
     * </ul>
     */
	ChangeChatName,
	   /**
     * The following keys must be included in the map:
     * <ul>
     * <li><strong>chatID</strong>: chatID</li>
     * <li><strong>userID</strong>: The user ID of the user who will be left chat</li>
     * </ul>
     */
	UserLeftChat,
	   /**
     * The following keys must be included in the map:
     * <ul>
     * <li><strong>chatID</strong>: chatID</li>
     * <li><strong>userID_init</strong>: The user ID of the user who initiated the user kick request.</li>
     * <li><strong>userID_owner</strong>: The user ID of the user who will be kicked.</li>
     * </ul>
     */
	UserWasKick,
	   /**
     * The following keys must be included in the map:
     * <ul>
     * <li><strong>chatID</strong>: chatID</li>
     * <li><strong>userID_init</strong>: The user ID of the user who initiated user added request.</li>
     * <li><strong>userID_owner</strong>: The user ID of the user whose will be added</li>
     * </ul>
     */
	UserWasAdded,
	  
     CreateChat,
     /**
      * The following keys must be included in the map:
      * <ul>
      * <li><strong>chatID</strong>: chatID</li>
      * <li><strong>userID_init</strong>: The user ID of the user who initiated the permission change request.</li>
      * <li><strong>userID_owner</strong>: The user ID of the user whose will be gotten permission.</li>
      * <li><strong>permissionType</strong>: Type of permission, {@link antoninBicak.chatApplication.security.ChatPermission} put them as String name, ChatPermission.name()
      * </ul>
      */
     UserGotPermission;
     
}



