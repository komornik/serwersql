package pl.projektDB.model;

import pl.projektDB.ui.TableFrame;

public class SingleSession{
	
	public static GenericModel getActualModel() {
		return actualModel;
	}
	public static void setActualModel(GenericModel actualModel) {
		SingleSession.actualModel = actualModel;
	}
	public static TableFrame getActualFrame() {
		return actualFrame;
	}
	public static void setActualFrame(TableFrame actualFrame) {
		SingleSession.actualFrame = actualFrame;
	}
	private static GenericModel actualModel;
	private static TableFrame actualFrame;
	
	
	
}