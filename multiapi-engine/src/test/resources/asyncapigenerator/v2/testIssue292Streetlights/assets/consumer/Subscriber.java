package com.sngular.scsplugin.streetlights.model.event.consumer;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sngular.scsplugin.streetlights.model.event.TurnOnOffPayloadDTO;
import com.sngular.scsplugin.streetlights.model.event.TurnOnOffPayloadDTO;
import com.sngular.scsplugin.streetlights.model.event.DimLightPayloadDTO;

@Configuration
public class Subscriber {

  private final ITurnOn turnOn;

  private final ITurnOff turnOff;

  private final IDimLight dimLight;

  protected Subscriber(final ITurnOn turnOn, final ITurnOff turnOff, final IDimLight dimLight) {
    this.turnOn = turnOn;
    this.turnOff = turnOff;
    this.dimLight = dimLight;
  }

  @Bean
  public Consumer<TurnOnOffPayloadDTO> turnOn() {
    return value -> turnOn.turnOn(value);
  }

  @Bean
  public Consumer<TurnOnOffPayloadDTO> turnOff() {
    return value -> turnOff.turnOff(value);
  }

  @Bean
  public Consumer<DimLightPayloadDTO> dimLight() {
    return value -> dimLight.dimLight(value);
  }


}
