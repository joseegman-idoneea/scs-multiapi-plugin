package com.sngular.scsplugin.streetlights.model.event.consumer;

import com.sngular.scsplugin.streetlights.model.event.DimLightPayloadDTO;

public interface IDimLight {

  void dimLight(final DimLightPayloadDTO value);
}