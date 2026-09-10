package com.sngular.scsplugin.streetlights.model.event.consumer;

public enum Channels {

  RECEIVE_LIGHT_MEASUREMENT("smartylighting.streetlights.1.0.event.(.*).lighting.measured"),
  TURN_ON("smartylighting.streetlights.1.0.action.(.*).turn.on"),
  TURN_OFF("smartylighting.streetlights.1.0.action.(.*).turn.off"),
  DIM_LIGHT("smartylighting.streetlights.1.0.action.(.*).dim");

  private final String channel;

  Channels(final String channel) {
    this.channel = channel;
  }

  public String getChannel() {
    return channel;
  }
}