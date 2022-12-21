package com.inti.route;

import org.apache.camel.builder.RouteBuilder;

import com.inti.process.ProcessGetAllAchatGerant;
import com.inti.process.ProcessGetAllLocationGerant;
import com.inti.process.ProcessInsertAchatGerant;
import com.inti.process.ProcessInsertLocationGerant;

public class RouteGerant extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("direct:selectAchatAll")
		.setBody(constant("select * from Achat_Projet"))
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
