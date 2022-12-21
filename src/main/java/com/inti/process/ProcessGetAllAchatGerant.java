package com.inti.process;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;

import com.inti.model.Achat;



public class ProcessGetAllAchatGerant implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().getBody();
		List<Achat> listeAchats = (List<Achat>) exchange.getIn().getBody();
		exchange.getIn().setBody(listeAchats);
		
		
	}

}
