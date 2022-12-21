package com.inti.process;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.inti.model.Location;

public class ProcessGetAllLocationGerant implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().getBody();
		List<Location> listeLocations = (List<Location>) exchange.getIn().getBody();
		exchange.getIn().setBody(listeLocations);
		
	}

}
