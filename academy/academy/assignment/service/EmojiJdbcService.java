package org.academy.assignment.service;

import java.sql.SQLException;
import java.util.List;

import org.academy.assignment.dao.EmojiDAO;
import org.academy.assignment.dto.Emoji;
import org.academy.assignment.dto.Song;







public class EmojiJdbcService {
	
	
	EmojiDAO emojiDAOService;
	
	public List<Song> getSongsList(int emoji) {
		// get a jdbc connection
		emojiDAOService = new EmojiDAO();													
			List<Song> songs=	emojiDAOService.getSongsData(emoji);																
		
			// System.out.println("size-"+emojiList.size());
			// System.out.println(emojiList);
		
		return songs;

	}
	
	public List<Emoji> getAllEmojiList() {
		// get a jdbc connection
		emojiDAOService = new EmojiDAO();													
			List<Emoji> emojis=null;
			try {
				emojis = emojiDAOService.getAllEmojiLst();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.printStackTrace();
			}																
		
			// System.out.println("size-"+emojiList.size());
			// System.out.println(emojiList);
		
		return emojis;

	}


}
