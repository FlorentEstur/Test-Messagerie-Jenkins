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
	DataSource dataSource;
	@Override
	public void configure() throws Exception {
		
		//LISTE ACHATS
		from("direct:selectAchatAll")
		.setBody(constant("select * from Achat_Projet"))
		.to("jdbc:dataSource")
		.process(new ProcessGetAllAchatGerant());
		
		// LISTE LOCATION
		from("direct:selectLocationAll")
		.setBody(constant("select * from Location_Projet"))
		.to("jdbc:dataSource")
		.process(new ProcessGetAllLocationGerant());
		
		
		//AFFICHER UN ACHAT
		from("direct:selectAchat")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				int id = (int) exchange.getIn().getBody();
				System.out.println("body : " + id);
				
				String query = "select * from Achat_Projet where id=" + id;
				exchange.getIn().setBody(query);
				
			}
		})
		.to("jdbc:dataSource");
		
		
		//AFFICHER UNE LOCATION
		from("direct:selectLocation")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				int id = (int) exchange.getIn().getBody();
				System.out.println("body : " + id);
				
				String query = "select * from Location_Projet where id=" + id;
				exchange.getIn().setBody(query);
				
			}
		})
		
		.to("jdbc:dataSource");
		
		//ENREGISTRER UN ACHAT
		from("direct:insertAchat")
		.process(new ProcessInsertAchatGerant())
		.to("jdbc:dataSource");
		
		
		//ENREGISTRER UNE LOCATION
		from("direct:insertLocation")
		.process(new ProcessInsertLocationGerant())
		.to("jdbc:dataSource");
		
	}

}
