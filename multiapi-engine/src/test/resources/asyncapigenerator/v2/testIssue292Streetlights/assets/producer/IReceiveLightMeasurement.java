package com.sngular.scsplugin.streetlights.model.event.producer;

import com.sngular.scsplugin.streetlights.model.event.LightMeasuredPayloadDTO;

public interface IReceiveLightMeasurement {

  LightMeasuredPayloadDTO receiveLightMeasurement();
}