package com.sngular.scsplugin.streetlights.model.event.producer;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sngular.scsplugin.streetlights.model.event.LightMeasuredPayloadDTO;

@Configuration
public class Producer {

  private final IReceiveLightMeasurement receiveLightMeasurement;

  protected Producer(final IReceiveLightMeasurement receiveLightMeasurement) {
    this.receiveLightMeasurement = receiveLightMeasurement;
  }

  @Bean
  public Supplier<LightMeasuredPayloadDTO> receiveLightMeasurement() {
    return () -> receiveLightMeasurement.receiveLightMeasurement();
  }


}
