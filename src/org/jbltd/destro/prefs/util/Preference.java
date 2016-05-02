package org.jbltd.destro.prefs.util;

public class Preference {

    private boolean playerVis, msgs, chat, flight, antikb, force, ncp;

    public Preference(boolean playerVis, boolean msgs, boolean chat, boolean flight, boolean antikb, boolean force,
	    boolean ncp) {
	this.playerVis = playerVis;
	this.msgs = msgs;
	this.chat = chat;
	this.flight = flight;
	this.antikb = antikb;
	this.force = force;
	this.ncp = ncp;

    }

    public boolean getPlayerVisibilityPreference() {
	return playerVis;
    }

    public boolean getMessagePreference() {
	return msgs;
    }

    public boolean getChatPreference() {

	return chat;
    }

    public boolean getFlightPreference() {
	return flight;
    }

    public boolean getKnockbackPreference() {
	return antikb;
    }

    public boolean getForcefieldPreference() {
	return force;
    }

    public boolean getNoCheatPreference() {
	return ncp;
    }

    public void setPlayerVisibilityPreference(boolean endis)
    {
	this.playerVis = endis;
    }
    public void setPlayerMessagePreference(boolean endis)
    {
	this.msgs = endis;
    }
    public void setPlayerChatPreference(boolean endis)
    {
	this.chat = endis;
    }
    public void setPlayerFlightPreference(boolean endis)
    {
	this.flight = endis;
    }
    public void setPlayerKnockbackPreference(boolean endis)
    {
	this.antikb = endis;
    }
    public void setPlayerForcefieldPreference(boolean endis)
    {
	this.force = endis;
    }
    public void setPlayerNCPPreference(boolean endis)
    {
	this.ncp = endis;
    }
    
}
