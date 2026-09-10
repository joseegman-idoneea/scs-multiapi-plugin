package com.sngular.scsplugin.streetlights.model.event.consumer;

import com.sngular.scsplugin.streetlights.model.event.TurnOnOffPayloadDTO;

public interface ITurnOn {

  void turnOn(final TurnOnOffPayloadDTO value);
}