package com.p532.commands;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.p532.model.Sprite;
import com.p532.view.GameArena;

@SuppressWarnings("serial")
public class CommandLogic {
	Logger log = Logger.getLogger(CommandLogic.class);
	private GameArena gameArena = GameArena.getInstance();
	private Sprite s;
	private JSONParser parser = new JSONParser();
	private static ArrayList<Sprite> newlist = new ArrayList<Sprite>();
	private JSONObject obj;
	private JSONObject mainobj = new JSONObject();
	private JSONArray savearray = new JSONArray();
	public int i;

	public void addBackground() {
		gameArena.revalidate();
		gameArena.repaint();
	}

	public void getComp(String test) {
		try {
			File file = new File(test + ".json");
			FileWriter fw = new FileWriter(file);
			for (Sprite sprite : AddSpriteCommand.getSpriteList()) {
				obj = new JSONObject();
				obj.put("id", sprite.getSpriteId());
				// obj.put("events", sprite.getEvent());
				// obj.put("actions", Sprite.getSpriteActions());
				obj.put("type", sprite.getSpriteType());
				obj.put("posx", sprite.getPosX());
				obj.put("posy", sprite.getPosY());
				savearray.add(obj);

			}
			mainobj.put("spritedetails", savearray);
			fw.write(mainobj.toJSONString());

			fw.flush();
			fw.close();
			log.info("successful save");
		} catch (IOException io) {
			System.exit(1);
		}
	}

	public void load(File f) throws IOException, ClassNotFoundException {
		try {

			Object obj = parser.parse(new FileReader(f));
			JSONObject jsonobj = (JSONObject) obj;
			JSONArray jarray = (JSONArray) jsonobj.get("spritedetails");
			for (i = 0; i < jarray.size(); i++) {

				JSONObject object = (JSONObject) jarray.get(i);

				s.setPosX((Integer) object.get("posx"));
				// Sprite.setSpriteActions((HashMap<Integer,
				// ArrayList<Integer>>) object.get("actions"));
				s.setPosY((Integer) object.get("posy"));
				s.setPosition();
				// s.setEvent((Integer) object.get("events"));
				s.setSpriteId((Integer) object.get("id"));
				s.setSpriteType((String) object.get("type"));
				gameArena.spriteLabel.add(s.getLblSprite());
				gameArena.revalidate();
				gameArena.repaint();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}