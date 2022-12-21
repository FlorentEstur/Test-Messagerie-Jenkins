package com.inti.route;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.process.ProcessGetAllAchatGerant;
import com.inti.process.ProcessGetAllLocationGerant;
import com.inti.process.ProcessInsertAchatGerant;
import com.inti.process.ProcessInsertLocationGerant;

@Service
public class RouteGerant extends RouteBuilder {

	@Autowired
	DataSource datasource;
	
	@Override
	public void configure() throws Exception {
		
		from("direct:selectAchatAll").log("Début de route")
		.setBody(constant("select * from Achat_Projet"))
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				System.out.println(exchange.getIn().getBody());
			}
		})
		.to("jdbc:dataSource")
		.process(new ProcessGetAllAchatGerant());
		
		
		from("direct:selectLocationAll")
		.setBody(constant("select * from Location_Projet"))
		.to("jdbc:dataSource")
		.process(new ProcessGetAllLocationGerant());
		
		from("direct:selectAchat")
		.setBody(constant("select * from Achat_Projet"))
		.to("jdbc:dataSource");
		
		from("direct:selectLocation")
		.setBody(constant("select * from Location_Projet"))
		.to("jdbc:dataSource");
		
		from("direct:insertAchat")
		.process(new ProcessInsertAchatGerant())
		.to("jdbc:dataSource");
		
		from("direct:insertLocation")
		.process(new ProcessInsertLocationGerant())
		.to("jdbc:dataSource");
		
	}

}
