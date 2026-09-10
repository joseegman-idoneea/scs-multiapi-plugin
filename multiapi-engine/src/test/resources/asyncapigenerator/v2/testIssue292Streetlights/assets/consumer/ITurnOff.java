package com.sngular.scsplugin.streetlights.model.event.consumer;

import com.sngular.scsplugin.streetlights.model.event.TurnOnOffPayloadDTO;

public interface ITurnOff {

  void turnOff(final TurnOnOffPayloadDTO value);
}