package org.academy.assignment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.academy.assignment.dto.Emoji;
import org.academy.assignment.dto.Song;

;


public class EmojiDAO {

	
	public ResultSet executeQuery(String query) {
		String url = "jdbc:mysql://localhost:3306/sr";
		String username = "root";
		String password = "";
		
		ResultSet resultSet = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();// create a statement
			
			System.out.println(query);
			 resultSet = statement.executeQuery(query);
			// statement.close();
				//connection.close();
		}catch(Exception e) {
			
		}
			return resultSet;
	}
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Emoji> getAllEmojiLst() throws SQLException{
		
		List<Emoji> emojis = new ArrayList<>();
		String query = "SELECT emoji_id,description,emoji from emoji1";
		System.out.println(query);
		ResultSet resultSet =executeQuery(query);
		Emoji emoji=null;
		while (resultSet.next()) {
		;
			emoji = new Emoji();
            emoji.setId(resultSet.getInt("emoji_id"));
            emoji.setDescription(resultSet.getString("description"));
            emoji.setEmoji(resultSet.getString("emoji"));
          
            emojis.add(emoji);
            
		}
		return emojis;

		
	}
	public List<Song> getSongsData(int emoji) {

		
		StringBuilder table = new StringBuilder();
		List<Song> songs = new ArrayList<>();
		try {

		
			
			String query = "SELECT s.id,s.author,s.movie_name,s.singer,s.song,s.music_producer FROM emoji1 e left join emoji_song_mappings em on e.emoji_id=em.emoji_id left join songs s on em.id=s.id where  e.emoji_id = "
					+ "'" + emoji + "'";
			System.out.println(query);
			ResultSet resultSet =executeQuery(query);
			table.append(
					"+----------------+---------------------+--------------------------------------------------+\n");
			table.append(String.format("| %-30s | %-50s | %-100s |\n", "Singer", "Song Name", "music producer"));
			table.append(
					"+----------------+---------------------+--------------------------------------------------+\n");
			Song song=null;
			
			while (resultSet.next()) {
				String singer = resultSet.getString("singer");
				String songName = resultSet.getString("song");
				String lyrics = resultSet.getString("music_producer");
				song = new Song();
                song.setId(resultSet.getInt("id"));
                song.setAuthor(resultSet.getString("author"));
                song.setDescription(resultSet.getString("movie_name"));
                song.setFullLyrics(resultSet.getString("music_producer"));
                song.setName(resultSet.getString("song"));
                song.setSinger(resultSet.getString("singer"));
                songs.add(song);
                table.append(String.format("| %-30s | %-50s | %-70s |\n", singer, songName, lyrics));
			}

			table.append(
					"+----------------+---------------------+--------------------------------------------------+\n");
			System.out.println(table.toString());

			// emoji tables .. this returns

			
			// execute query to get all emoji's from

		} catch (Exception e) {
			System.out.println(e);
		}

		return songs;
	}
}
